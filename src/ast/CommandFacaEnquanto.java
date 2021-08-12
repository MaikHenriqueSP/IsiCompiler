package ast;

import java.util.List;

public class CommandFacaEnquanto extends AbstractCommand {
    private String condition;
    private List<AbstractCommand> commands;

    public CommandFacaEnquanto(String condition, List<AbstractCommand> commands) {
        this.condition = condition;
        this.commands = commands;
    }

    @Override
    public String generateCode() {
        StringBuilder code = new StringBuilder();

        code.append("\n\t\tdo {\n");
        generateBlock(code, commands);
        code.append("\t\t} while(");
        code.append(condition);
        code.append(")\n");

        return code.toString();
    }

    private static void generateBlock(StringBuilder code, List<AbstractCommand> commands) {
        for (AbstractCommand abstractCommand : commands) {
            code.append("\t\t\t" + abstractCommand.generateCode() + "\n");
        }
    }

    @Override
    public String toString() {
        return "CommandFacaEnquanto [commands=" + commands + ", condition=" + condition + "]";
    }

    
    
}
