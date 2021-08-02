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
            
cmd         :   
            ;