grammar IsiLanguage;

@header {
    import datastructures.*;
    import exceptions.*;
    import ast.*;
    import util.*;
    import java.util.*;
}

@members {
    private IsiType type;
    private String value;
    private IsiSymbolTable symbolTable = new IsiSymbolTable();
    private IsiSymbol symbol;

    private String _test;
    
    private String currentID;
    private String content;
    private IsiProgram program = new IsiProgram();
    private List<AbstractCommand> currentThread;
    private Stack<List<AbstractCommand>> stack = new Stack<>();

    private List<AbstractCommand> trueList;
    private List<AbstractCommand> falseList;

    // Start - Unary operations related
    private boolean isPostUnary;
    // End - Unary operations related

    // Start - Expression validation related
    private List<IsiType> expressionTypes;
    private List<String> mathOperators;
    private IsiType expressionIsiType;
    private String assigningVariableID;

    public void setExpressionType() {
        if (expressionTypes.contains(IsiType.TEXT)) {
            expressionIsiType = IsiType.TEXT;
            return;
        }
        expressionIsiType = IsiType.NUMBER;
    }

    public void verifyAssignmentType() {
        IsiType variableType = getSymbolType(assigningVariableID);
        if (variableType != expressionIsiType) {
            throw new IsiSemanticException("Can't assign '" + expressionIsiType + "' to a '" + variableType + "' variable. Variable name: " + assigningVariableID);
        }
    }

    public void verifyOperationValidity() {       
        if (expressionIsiType == IsiType.NUMBER || mathOperators.size() == 0) {
            return;
        }

        int minusOperatorIndex = mathOperators.indexOf("-");
        int textTypeIndex = expressionTypes.indexOf(IsiType.TEXT);

        if (minusOperatorIndex != -1 && minusOperatorIndex >= textTypeIndex) {
            throw new IsiSemanticException("A TEXT expression cannot be operated by a '-' operator.");
        }

        for (int i = 1; i < expressionTypes.size(); i++) {
            if (!mathOperators.get(i -1).equals("+") && (expressionTypes.get(i) == IsiType.TEXT || expressionTypes.get(i - 1) == IsiType.TEXT)) {
                throw new IsiSemanticException("Invalid operation.");
            }
        }
    }
    // End - Expression validation related

    // Start - Loop-for related
    private String loopForVariables;
    private String loopForCondition;
    private String loopForIncrementer;
    // End - Loop-for related
    
    public IsiType getSymbolType(String id) {
        return ((IsiVariable) symbolTable.get(id)).getType();
    }

    public void addSymbol(String id, IsiType type, String value) {
        if (symbolTable.contains(id)) {
            throw new IsiSemanticException("Symbol '" + id + "' already declared.");
        }

        IsiSymbol newSymbol = new IsiVariable(id, type, value);
        symbolTable.add(newSymbol);        
    }

    public void verifySymbolDeclaration(String id) {
        if (!symbolTable.contains(id)) {
            throw new IsiSemanticException("Symbol '" + id + "' wasn't declared.");            
        }
    }

    public void setSymbolToBeInUse(String id) {
        verifySymbolDeclaration(id);
        IsiVariable variable = (IsiVariable) symbolTable.get(id);
        variable.becomeInUse();
        symbolTable.add(variable);
    }

    public void verifyIfAllVariablesAreInUse() {
        Optional<IsiSymbol> variable = symbolTable.getSymbols().stream().filter(var -> !((IsiVariable) var).getIsBeingUsed()).findFirst();

        if (variable.isPresent()) {
            throw new IsiSemanticException("The varible  '" + variable.get().getName() + "' wasn't used.");
        }
    }

    public void verifyType(String id, IsiType type) {
        if (getSymbolType(id) != type) {
            throw new IsiSemanticException("The variable is not a " + type);
        }
    }

    public void verifyExpectedExpressionType(IsiType type) {
        if (expressionIsiType != type) {
            throw new IsiSemanticException("The variable is not a " + type);
        }
    }

    public void verifyBooleanExpression() {
        if (expressionIsiType != IsiType.NUMBER) {
            throw new IsiSemanticException("A boolean expression can only contain subexpressions of type NUMBER");
        }
    }


    public void generateProgram() {
        program.generateProgram();
    }

    public void showCommands() {
        for (AbstractCommand c : program.getCommands()) {
            System.out.println(c);
        }
    }  
    
}

programa    :   'programa' 
                declara 
                bloco
                'fimprog' 
                FIM {
                    verifyIfAllVariablesAreInUse();
                    program.setSymbolTable(symbolTable);
                    program.setCommands(stack.pop());
                }

            ;

declara     :   (declaraVar)+
            ;

declaraVar  :   tipo 
                ID {
                    addSymbol(_input.LT(-1).getText(), type, null);
                }
                (
                    VIR ID {
                        addSymbol(_input.LT(-1).getText(), type, null);
                    }
                )*
                FIM
            ;

tipo        :   'numero' { type = IsiType.NUMBER; }
            |   'texto'  { type = IsiType.TEXT; }
            ;

bloco       :   {
                    currentThread = new ArrayList<>();
                    stack.push(currentThread);        
                }
                (cmd)*
            ;

ID          :   [a-z] ([a-z] | [A-Z] | [0-9])*
            ;
            
cmd         :   cmdLeitura
            |   cmdEscrita
            |   cmdAtr
            |   cmdIf
            |   cmdEnquanto
            |   cmdPara
            |   cmdUnario
            |   cmdComentario
            |   cmdFacaEnquanto
            ;

cmdLeitura  :  'leia' 
                AP 
                ID  { 
                        currentID = _input.LT(-1).getText();
                        verifySymbolDeclaration(currentID);
                    }
                FP 
                FIM {
                    IsiVariable variable = (IsiVariable) symbolTable.get(currentID);
                    CommandLeitura cmd = new CommandLeitura(currentID, variable);
                    stack.peek().add(cmd);
                    setSymbolToBeInUse(currentID);
                }
            ;

cmdEscrita  :   'escreva' 
                AP 
                ID {
                    currentID = _input.LT(-1).getText();
                    verifySymbolDeclaration(currentID);
                }
                FP 
                FIM {
                    CommandEscrita cmd = new CommandEscrita(currentID);
                    stack.peek().add(cmd);
                    setSymbolToBeInUse(currentID);
                }
            ;

cmdAtr      :   ID {
                    currentID = _input.LT(-1).getText();
                    assigningVariableID = currentID;
                    verifySymbolDeclaration(currentID);
                    expressionTypes = new ArrayList<>();
                    mathOperators = new ArrayList<>();
                }
                ATR { content = ""; }
                expr {
                    setExpressionType();
                    verifyAssignmentType();
                    verifyOperationValidity();
                }
                FIM {
                    CommandAtribuicao cmd = new CommandAtribuicao(assigningVariableID, content);
                    stack.peek().add(cmd);
                    setSymbolToBeInUse(currentID);
                    
                }
            ;

cmdIf       :   {
                    content = "";
                    falseList = new ArrayList<>();
                }
                'se' 
                    AP 
                        conditional 
                    FP
                'entao' 
                    AC { 
                        currentThread = new ArrayList<>();
                        stack.push(currentThread);
                    } 
                        (cmd)+ 
                    FC {
                        trueList = stack.pop();
                      
                    }
                (
                    'senao' 
                    AC {
                        currentThread = new ArrayList<>();
                        stack.push(currentThread);
                    } 
                        (cmd)+ 
                    FC {
                        falseList = stack.pop();
                        
                    }
                )?{
                    CommandIf cmd = new CommandIf(content, trueList, falseList);
                    stack.peek().add(cmd);
                }
            ;

cmdEnquanto :   {
                    content = "";                    
                }

                'enquanto' 
                    AP 
                        conditional 
                    FP
                    AC {
                        currentThread = new ArrayList<>();
                        stack.push(currentThread);
                    }
                        (cmd)+
                    FC
                {
                    CommandEnquanto enquanto = new CommandEnquanto(content, stack.pop());
                    stack.peek().add(enquanto);
                }
            ;


cmdPara     :   {
                    loopForVariables = "";
                    currentThread = new ArrayList<>();
                    stack.push(currentThread);
                    content = "";
                }
                'para' 
                    AP 
                        (cmdAtrPara) { loopForVariables = content; }
                        SEMICOLON { content = "";}
                        (conditional) {loopForCondition = content;} 
                        SEMICOLON { content = "";}
                        (cmdAtrPara)(VIR cmdAtrPara)* {loopForIncrementer = content;}
                        
                    FP                    
                'faca'
                    AC
                        (cmd)+
                    FC
                {
                    List<AbstractCommand> cmds = stack.pop();
                    CommandPara cpara = new CommandPara(loopForVariables, loopForCondition, loopForIncrementer, cmds);
                    stack.peek().add(cpara);
                }
            ;

cmdAtrPara  :
                (
                    (
                        cmdParaVar
                    )
                    (
                        VIR { content += ",";}
                        cmdParaVar
                    )*
                )*
            ;
cmdParaVar :    ID { 
                    currentID = _input.LT(-1).getText();
                    content += currentID;
                    verifySymbolDeclaration(currentID);
                    verifyType(currentID, IsiType.NUMBER);
                }
                ATR { content += "=";}
                expr {
                    {
                        setExpressionType();
                        verifyExpectedExpressionType(IsiType.NUMBER);
                    }
                }
            ;

cmdUnario   : 
                (
                        ID { 
                            currentID = _input.LT(-1).getText();
                            verifySymbolDeclaration(currentID);
                            verifyType(currentID, IsiType.NUMBER);                            
                        }
                        UNARY {
                            content = _input.LT(-1).getText(); 
                            isPostUnary = true;}
                    | 
                        UNARY {
                            content = _input.LT(-1).getText();
                            isPostUnary = false;
                        } 
                        ID { 
                            currentID = _input.LT(-1).getText();
                            verifySymbolDeclaration(currentID);
                            verifyType(currentID, IsiType.NUMBER);
                        }
                )* 
                FIM
                {
                    CommandUnary cmdUn = new CommandUnary(content, currentID, isPostUnary);
                    stack.peek().add(cmdUn);
                }
            ;

cmdComentario   :   CMT {
                        CommandComentario cmdComentario = new CommandComentario(_input.LT(-1).getText());
                        stack.peek().add(cmdComentario);
                    }
                ;

cmdFacaEnquanto     :   {
                            content = "";
                        }
                        'faca' 
                            AC {
                                currentThread = new ArrayList<>();
                                stack.push(currentThread);
                            }                                
                                (cmd)*
                            FC
                        'enquanto' AP conditional FP
                        {
                            List<AbstractCommand> commands = stack.pop();
                            CommandFacaEnquanto cfe = new CommandFacaEnquanto(content, commands);
                            stack.peek().add(cfe);                            
                        }
                    ;

conditional :   (
                    (
                        booleanExpr 
                        OPREL {content += _input.LT(-1).getText();}
                        booleanExpr
                    )
                    (
                        LOP {content += _input.LT(-1).getText();}
                        booleanExpr 
                        OPREL {content += _input.LT(-1).getText();}
                        booleanExpr
                    )*
                )*
            ;

booleanExpr :   {
                    expressionTypes = new ArrayList<>();
                }
                expr {
                    setExpressionType();
                    verifyBooleanExpression();
                }
            ;

AP          :   '('
            ;

FP          :   ')'
            ;

ATR         :   ':='
            ;

expr        :   termo
                (
                    OP {
                        content += _input.LT(-1).getText();
                        mathOperators.add(_input.LT(-1).getText());
                    }
                    termo
                )*
            ;

termo       :   NUM { 
                    content += _input.LT(-1).getText(); 
                    expressionTypes.add(IsiType.NUMBER);
                }
            |   TEXT { 
                    content += _input.LT(-1).getText();
                    expressionTypes.add(IsiType.TEXT);
                }
            |   ID  {                
                    currentID = _input.LT(-1).getText();
                    verifySymbolDeclaration(currentID);
                    setSymbolToBeInUse(currentID);
                    content += currentID;
                    expressionTypes.add(getSymbolType(currentID));
                }
            ;

OP          :   '+' | '-' | '*' | '/'
            ;

NUM         :   [0-9]+('.'[0-9]+)? 
            ;

TEXT        :   '"'([a-z] | [A-Z] | [0-9] | WS)*'"'
            ;

CMT         :   '#'([a-z] | [A-Z] | [0-9] | WS)*'#'
            ;

OPREL       :   '<' | '>' | '<=' | '>=' | '!=' | '=='
            ;

LOP         :   '&&' | '||'
            ;

AC          :   '{'
            ;

FC          :   '}'
            ;

WS          :   (' ' | '\n' | '\t' | '\r')  -> channel(HIDDEN)
            ;

FIM         :   '.'
            ;

VIR         :   ','
            ;

SEMICOLON   :   ';'
            ;

UNARY       :   '++' | '--'
            ;