package rpn;

public class UnexpectedVariableException extends Exception {
	String variable;

    public UnexpectedVariableException(String s) {
        variable = s;
    }

    public String toString() {
        return "Error: Unassigned variable: "+variable;
    }
}
