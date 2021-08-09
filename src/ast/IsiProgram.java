package ast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import datastructures.IsiSymbol;
import datastructures.IsiSymbolTable;

public class IsiProgram {
    private IsiSymbolTable symbolTable;
    private List<AbstractCommand> commands;
    private String programName;
    private StringBuilder program;    

    public IsiProgram() {
        program = new StringBuilder();
    }

    public void generateProgram() {
        generateProgramCode();
        generateFile();
    }

    private void generateProgramCode() {
        program.append("import java.util.Scanner;\n");        
        program.append("public class Main {\n");
        program.append("\tpublic static void main(String args[]){\n");
        program.append("\t\tScanner reader = new Scanner(System.in);\n");
        
        for (IsiSymbol symbol : symbolTable.getSymbols()) {
            program.append("\t\t" + symbol.generateCode() + "\n");            
        }

        for (AbstractCommand command : commands) {
            program.append("\t\t" + command.generateCode() + "\n");
        }
        program.append("\t}\n");
        program.append("}");
    }

    private void generateFile() {
        try {
            FileWriter fileWriter = new FileWriter(new File("Main.java"));
            fileWriter.write(program.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public IsiSymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(IsiSymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public List<AbstractCommand> getCommands() {
        return commands;
    }

    public void setCommands(List<AbstractCommand> commands) {
        this.commands = commands;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }    
}
