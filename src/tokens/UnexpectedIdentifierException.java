package tokens;

public class UnexpectedIdentifierException extends Exception {
	String identifier;

    public UnexpectedIdentifierException(String s) {
        identifier = s;
    }

    public String toString() {
        return "Error: Unexpected identifier: "+identifier;
    }
}
