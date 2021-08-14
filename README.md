# Projeto compiladores

Membros:   
    André Ricca Yoshida - RA 11126515
    
    Maik Henrique - RA 11201720058

Projeto final da matéria Compiladores, utilizando como base o IsiLanguage e compilando em Java.

## O Projeto

A proposta do projeto era aplicar os conceitos aprendidos em aula e criar o nosso próprio compilador. Tivemos como objetivo seguir a risca os itens obrigatórios e desenvolver um código limpo, de fácil entendimento.

### Executando o projeto

O fluxo consiste em escrever um código baseado em IsiLanguage no arquivo `input.isi`, podendo conter todos os comandos previstos como, `leia`, `faca`, `se`, `entao`, `senao`...
Com o código escrito e a sintaxe correta, o arquivo `main/Main.java` pode ser executado. É nesse ponto que o compilador começa a agir, onde toda a análise léxica acontece, toda análise utiliza o arquivo `util/IsiLanguage.g4` como base para interpretador. 
Após interpretar e compilar todo o `input.isi`, um arquivo `Main.java` é gerado na pasta raíz, contendo todo o código em Java correspondente ao IsiLanguage.

Durante toda a execução do compilador, diversos logs são gerados e impressos de maneira síncrona no terminal, possibilitando ao usuário o acompanhamento e identificação de eventuais erros.
