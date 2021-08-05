grammar IsiLanguage;

@header {
    import datastructures.*;
    import exceptions.*;
    import util.*;
}

@members {
    private IsiType type;
    private String name;
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

TIPO        :   'numero' | 'texto'
            ;

bloco       :   (cmd)*
            ;

ID          :   [a-z] ([a-z] | [A-Z] | [0-9])*
            ;
            
cmd         :   cmdLeitura
            |   cmdEscrita
            |   cmdExpr
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

cmdExpr     :   ID {verifySymbolDeclaration(_input.LT(-1).getText());}
                ATR 
                expr 
                FIM
            ;

cmdIf       :   'se' AP expr OPREL expr FP
                'entao' AC (cmd)+ FC
                ('senao' AC (cmd)+ FC)?
            ;

cmdEnquanto :   'enquanto' AP expr OPREL expr FP
                AC
                (cmd)+
                FC
            ;

cmdPara     :   'para' AP ((cmdExpr)(VIR cmdExpr)*)* SEMICOLON ((expr OPREL expr)(OPREL expr)*)*  SEMICOLON ((cmdExpr)(VIR cmdExpr)*)*  FP
                AC
                (cmd)+
                FC
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