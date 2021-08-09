grammar IsiLanguage;

@header {
    import datastructures.*;
    import exceptions.*;
    import util.*;
}

@members {
    private IsiType type;
    private String value;
    private IsiSymbolTable symbolTable = new IsiSymbolTable();
    private IsiSymbol symbol;

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
    
}

programa    :   'programa' 
                declara 
                bloco
                'fimprog' FIM
            ;

declara     :   (declaraVar)+
            ;

declaraVar  :   TIPO ID {addSymbol(_input.LT(-1).getText(), type, null);}
                (VIR ID {addSymbol(_input.LT(-1).getText(), type, null);})*
                FIM
            ;

TIPO        :   'numero' {type = IsiType.NUMBER;}
            |   'textdo' {type = IsiType.TEXT;}
            ;

bloco       :   (cmd)*
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
                ID {verifySymbolDeclaration(_input.LT(-1).getText());}
                FP 
                FIM
            ;

cmdEscrita  :   'escreva' 
                AP 
                ID {verifySymbolDeclaration(_input.LT(-1).getText());}
                FP 
                FIM
            ;

cmdAtr     :   ID {verifySymbolDeclaration(_input.LT(-1).getText());}
                ATR 
                expr 
                FIM
            ;

cmdIf       :   'se' AP conditional FP
                'entao' AC (cmd)+ FC
                ('senao se' AP conditional FP
                    AC (cmd)+ FC
                )*
                ('senao' AC (cmd)+ FC)?
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

conditional :   ((expr OPREL expr)(LOP expr OPREL expr)*)*
            ;

AP          :   '('
            ;

FP          :   ')'
            ;

ATR         :   ':='
            ;

expr        :   termo (OP termo)*
            ;

termo       :   NUM |  ID
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