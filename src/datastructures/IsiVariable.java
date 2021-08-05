package datastructures;

import util.IsiType;

public class IsiVariable extends IsiSymbol {
    
    private IsiType type;
    private String value;
    
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

    @Override
    public String toString() {
        return "IsiVariable [type=" + type + ", value=" + value + "]";
    }
}
