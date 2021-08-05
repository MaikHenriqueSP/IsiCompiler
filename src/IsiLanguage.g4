grammar IsiLanguage;

programa    :   'programa' 
                declara 
                bloco
                'fimprog' FIM
            ;

declara     :   (declaraVar)+
            ;

declaraVar  :   TIPO ID (',' ID)* FIM
            ;

TIPO        :   'numero' | 'texto'
            ;

bloco       :   (cmd'.')+
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

cmdLeitura  :  'leia' AP ID FP FIM
            ;

cmdEscrita  :   'escreva' AP ID FP FIM
            ;

cmdExpr     :   ID ATR expr FIM
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

cmdPara     :   'para' AP (cmdExpr)* ';' (termo OPREL termo)*  ';' (cmdExpr)*  FP
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