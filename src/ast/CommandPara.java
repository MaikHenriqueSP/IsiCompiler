package ast;

import java.util.List;

public class CommandPara extends AbstractCommand {
   
    private String loopForVariables;
    private String loopForCondition;
    private String loopForIncrementer;
    private List<AbstractCommand> commands;

    

    public CommandPara(String loopForVariables, String loopForCondition, String loopForIncrementer, List<AbstractCommand> commands) {
        this.loopForVariables = loopForVariables;
        this.loopForCondition = loopForCondition;
        this.loopForIncrementer = loopForIncrementer;
        this.commands = commands;
    }

    @Override
    public String generateCode() {
        StringBuilder code = new StringBuilder();
        
        code.append("\n\t\tfor (");
        code.append(loopForVariables + ";");
        code.append(loopForCondition + ";");
        code.append(loopForIncrementer + ") {\n");
        generateBlock(code, commands);
        code.append("\n\t\t}\n");

        return code.toString();
    }

    private static void generateBlock(StringBuilder code, List<AbstractCommand> commands) {
        for (AbstractCommand abstractCommand : commands) {
            code.append("\t\t\t" + abstractCommand.generateCode() + "\n");
        }
    }

    @Override
    public String toString() {
        return "CommandPara [commands=" + commands + ", loopForCondition=" + loopForCondition + ", loopForIncrementer="
                + loopForIncrementer + ", loopForVariables=" + loopForVariables + "]";
    }

}
