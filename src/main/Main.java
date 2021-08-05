package main;

import java.io.IOException;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.*;

public class Main {
    public static void main(String[] args) {
        try {            
            IsiLanguageLexer lexer = new IsiLanguageLexer(CharStreams.fromFileName("input.isi"));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            IsiLanguageParser parser = new IsiLanguageParser(tokenStream);
            parser.programa();
            System.out.println("Compilation successful");

        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }

}
