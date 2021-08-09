package datastructures;

public abstract class IsiSymbol {

    private String name;

    public IsiSymbol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String generateCode();

    @Override
    public String toString() {
        return "IsiSymbol [name=" + name + "]";
    }
    
}
