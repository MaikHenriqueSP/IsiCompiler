package datastructures;

import util.IsiType;

public class IsiVariable extends IsiSymbol {
    
    private IsiType type;
    private String value;
    private boolean isBeingUsed;
    
    public IsiVariable(String name, IsiType type, String value) {
        super(name);
        this.type = type;
        this.value = value;
    }

    public IsiType getType() {
        return type;
    }

    public void setType(IsiType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getIsBeingUsed() {
        return isBeingUsed;
    }

    public void becomeInUse() {
        this.isBeingUsed = true;
    }

    @Override
    public String generateCode() {
        String code = type == IsiType.NUMBER ? "double" : "String";
        return code + " " + super.getName() + ";";
    }

    @Override
    public String toString() {
        return "IsiVariable [name=" + super.getName() + " type=" + type + ", value=" + value + " isBeingUsed= " + isBeingUsed + "]";
    }

    



}
