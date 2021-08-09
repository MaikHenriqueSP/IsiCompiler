package ast;

public class CommandEscrita extends AbstractCommand {
    private String id;

    public CommandEscrita(String id) {
        this.id = id;
    }

    @Override
    public String generateCode() {        
        return String.format("System.out.println(%s);", id);
    }

    @Override
    public String toString() {
        return "CommandEscrita [id=" + id + "]";
    }
    
}
