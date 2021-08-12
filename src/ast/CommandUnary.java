package ast;

public class CommandUnary extends AbstractCommand {
    private String unaryOperation;
    private String id;
    private boolean isPostUnary;

    public CommandUnary(String unaryOperation, String id, boolean isPostUnary) {
        this.unaryOperation = unaryOperation;
        this.id = id;
        this.isPostUnary = isPostUnary;
    }

    @Override
    public String generateCode() {
        System.out.println(isPostUnary);
        String expression = isPostUnary ? id + unaryOperation : unaryOperation + id;
        return "\n\t\t" + expression + ";\n";
    }
   

    @Override
    public String toString() {
        return "CommandUnary [id=" + id + ", isPostUnary=" + isPostUnary + ", unaryOperation=" + unaryOperation + "]";
    }

    
    
}
