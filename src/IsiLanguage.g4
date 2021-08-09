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
                    System.out.println(stack);
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
                }
            ;

cmdAtr      :   ID {
                    currentID = _input.LT(-1).getText();
                    verifySymbolDeclaration(currentID);
                }
                ATR { content = ""; }
                expr 
                FIM {
                    CommandAtribuicao cmd = new CommandAtribuicao(currentID, content);
                    stack.peek().add(cmd);
                }
            ;

cmdIf       :   {
                    content = "";
                    falseList = null;
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
                ('senao se' AP conditional FP
                    AC (cmd)+ FC
                )*
                (
                    'senao' 
                    AC {
                        currentThread = new ArrayList<>();
                        stack.push(currentThread);
                    } 
                        (cmd)+ 
                    FC {
                        falseList = stack.pop();
                        CommandIf cmd = new CommandIf(content, trueList, falseList);
                        stack.peek().add(cmd);
                    }
                )?
            ;

cmdEnquanto :   'enquanto' AP conditional FP
                AC
                (cmd)+
                FC
            ;

cmdPara     :   'para' AP ((cmdAtr)(VIR cmdAtr)*)* SEMICOLON conditional  SEMICOLON ((cmdAtr)(VIR cmdAtr)*)*  FP
                AC
                (cmd)+
                FC
            ;

conditional :   (
                    (
                        expr 
                        OPREL {content += _input.LT(-1).getText();}
                        expr
                    )
                    (
                        LOP {content += _input.LT(-1).getText();}
                        expr 
                        OPREL {content += _input.LT(-1).getText();}
                        expr
                    )*
                )*
            ;

AP          :   '('
            ;

FP          :   ')'
            ;

ATR         :   ':='
            ;

expr        :   termo 
                (
                    OP {content += _input.LT(-1).getText();}
                    termo
                )*
            ;

termo       :   NUM  { content += _input.LT(-1).getText();}
            |   ID   {
                    currentID = _input.LT(-1).getText();
                    verifySymbolDeclaration(currentID);
                    content += currentID;
                }
            ;

OP          :   '+' | '-' | '*' | '/'
            ;

NUM         :   [0-9]+('.'[0-9]+)?
            ;

OPREL       :   '<' | '>' | '<=' | '>=' | '!=' | '=='
            ;

LOP         :   '&&' | '||'
            ;

AC          :   '{'
            ;

FC          :   '}'
            ;

WS          :   (' ' | '\n' | '\t' | '\r')  -> skip
            ;

FIM         :   '.'
            ;

VIR         :   ','
            ;

SEMICOLON   :   ';'
            ;