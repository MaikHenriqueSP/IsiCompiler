package exceptions;

public class IsiSyntaxException extends RuntimeException{
  
    public IsiSyntaxException(int line, int column, String message) {        
        this(String.format("A syntax error was found at %d:%d. Specific error message: %s.", line, column, message));
    }

    private IsiSyntaxException(String message) {
        super(message);
    }
    
}
