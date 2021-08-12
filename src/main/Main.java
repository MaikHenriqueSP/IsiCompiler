package main;

import java.io.IOException;
import java.util.Optional;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import errors.SyntaxErrorListener;
import exceptions.IsiSemanticException;
import exceptions.IsiSyntaxException;
import parser.*;

public class Main {
    public static void main(String[] args) {
        try {            
            IsiLanguageLexer lexer = new IsiLanguageLexer(CharStreams.fromFileName("input.isi"));            
            
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            IsiLanguageParser parser = new IsiLanguageParser(tokenStream);
            parser.removeErrorListeners();
            SyntaxErrorListener syntaxErrorListener = new SyntaxErrorListener();
            parser.addErrorListener(syntaxErrorListener);
            
            parser.programa();
            
            if (syntaxErrorListener.hasErrors()) {
                throw new IsiSyntaxException(syntaxErrorListener.getLine(), syntaxErrorListener.getColumn(), syntaxErrorListener.getMessage());
            }

            System.out.println("Compilation successful");
            parser.showCommands();
            parser.generateProgram();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IsiSemanticException e) {
            System.err.println("Semantic Error: " + e.getMessage());
        } catch (IsiSyntaxException e) {
            System.err.println(e.getMessage());            
        }
        //String a = 1 + 2 + 3 / "a";
        //arrayType =[number, number, number, number];
        //operatorsSequence = [+, +, /]

    }

}

