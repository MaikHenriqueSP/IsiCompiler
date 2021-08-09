package main;

import java.io.IOException;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import exceptions.IsiSemanticException;
import parser.*;

public class Main {
    public static void main(String[] args) {
        try {            
            IsiLanguageLexer lexer = new IsiLanguageLexer(CharStreams.fromFileName("input.isi"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            IsiLanguageParser parser = new IsiLanguageParser(tokenStream);
            parser.programa();
            System.out.println("Compilation successful");
            parser.showCommands();
            parser.generateProgram();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IsiSemanticException e)
        {
            System.err.println("Semantic Error: " + e.getMessage());
        }


    
    }

}

