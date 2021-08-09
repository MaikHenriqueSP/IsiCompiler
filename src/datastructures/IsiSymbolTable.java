package datastructures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<IsiSymbol> getSymbols() {
        return mapToSymbol.values().stream().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "IsiSymbolTable [mapToSymbol=" + mapToSymbol + "]";
    }
    
}
