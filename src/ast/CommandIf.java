package ast;

import java.util.List;

public class CommandIf extends AbstractCommand {

    private String condition;
    private List<AbstractCommand> trueList;
    private List<AbstractCommand> falseList;
   
    public CommandIf(String condition, List<AbstractCommand> trueList, List<AbstractCommand> falseList) {
        this.condition = condition;
        this.trueList = trueList;
        this.falseList = falseList;
    }
    
    @Override
    public String generateCode() {
        StringBuilder code = new StringBuilder();

        code.append("if (" + condition + ") {\n");
        generateBlock(code, trueList);
        code.append("\n\t\t}\n");
        if (falseList.size() > 0){
            code.append("\t\t else{\n");
            generateBlock(code, falseList);
            code.append("}\n");            
        }
        
        return code.toString();
    }

    private static void generateBlock(StringBuilder code, List<AbstractCommand> commands) {
        for (AbstractCommand abstractCommand : commands) {
            code.append("\t\t\t" + abstractCommand.generateCode());
        }
    }

    @Override
    public String toString() {
        return "CommandIf [condition=" + condition + ", falseList=" + falseList + ", trueList=" + trueList + "]";
    }
    
}
