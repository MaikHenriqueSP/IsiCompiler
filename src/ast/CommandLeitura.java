package ast;

import datastructures.IsiVariable;
import util.IsiType;

public class CommandLeitura extends AbstractCommand {
    private String id;
    private IsiVariable variable;
    
    public CommandLeitura(String id, IsiVariable variable) {
        this.id = id;
        this.variable = variable;
    }

    @Override
    public String generateCode() {        
        return id + "= reader." + getReadType();
    }

    private String getReadType() {
        return variable.getType() == IsiType.NUMBER ? "nextDouble();" : "nextLine();";
    }

    @Override
    public String toString() {
        return "CommandLeitura [id=" + id + ", variable=" + variable + "]";
    }    
    
}
