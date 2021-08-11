package ast;

import java.util.List;

public class CommandEnquanto extends AbstractCommand {
    private String condition;
    private List<AbstractCommand> commands;

    public CommandEnquanto(String condition, List<AbstractCommand> commands) {
        this.condition = condition;
        this.commands = commands;
    }


    @Override
    public String generateCode() {
        StringBuilder code = new StringBuilder();
        code.append("while (" + condition + ") {\n");
        generateBlock(code, commands);
        code.append("\t\t}\n");
        return code.toString();
    }
    
    private static void generateBlock(StringBuilder code, List<AbstractCommand> commands) {
        for (AbstractCommand abstractCommand : commands) {
            code.append("\t\t\t" + abstractCommand.generateCode() + "\n");
        }
    }


    @Override
    public String toString() {
        return "CommandEnquanto [commands=" + commands + ", condition=" + condition + "]";
    }
    
}
