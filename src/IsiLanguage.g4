grammar IsiLanguage;

programa    :   'programa' 
                declara 
                bloco
            ;

declara     :   'declare' ID (',' ID)* '.'
            ;

bloco       :   (cmd'.')+
            ;

ID          :   [a-z] ([a-z] | [A-Z] | [0-9])*
            ;
            
cmd         :   cmdLeitura
            |   cmdEscrita
            |   cmdExpr
            |   cmdIf
            ;

cmdLeitura  :  'leia' AP ID FP;

cmdEscrita  :   'escreva' AP ID FP;

cmdExpr     :   ID  ATR expr;

cmdIf       :   'se' AP expr OPREL FP
                'entao' AC cmd+ FC
                ('senao' AC cmd+ FC)?
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

NUM         :   [0-9]+
            ;

OPREL       :   '<' | '>' | '<=' | '>=' | '!=' | '=='
            ;

AC          :   '{'
            ;

FC          :   '}'
            ;