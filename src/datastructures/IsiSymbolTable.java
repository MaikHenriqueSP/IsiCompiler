package datastructures;

import java.util.HashMap;
import java.util.Map;

public class IsiSymbolTable {

    Map<String, IsiSymbol> mapToSymbol;

    public IsiSymbolTable() {
        mapToSymbol = new HashMap<>();
    }
    
    public void add(IsiSymbol symbol) {
        mapToSymbol.put(symbol.getName(), symbol);
    }

    public boolean contains(String name) {
        return mapToSymbol.containsKey(name);
    }
    
    public IsiSymbol get(String name) {
        return mapToSymbol.get(name);
    }
}
