package rpn;

import tokens.TokenType;

public class Regex {
    static private final String PATTERN_OPERATION = "\\+|\\*|-|/|=";
    static private final String PATTERN_NUMBER    = "\\d+";
    static private final String PATTERN_VARIABLE = "\\w[a-zA-Z0-9_]+|_+\\w[a-zA-Z0-9_]+";

    static public boolean isOp(String lexeme) {
    	return lexeme.matches(PATTERN_OPERATION);
    }
    
    static public boolean isNum(String lexeme) {
    	return lexeme.matches(PATTERN_NUMBER);
    }

    static public boolean isIdentifier(String lexeme) {
        return lexeme.matches(PATTERN_VARIABLE);
    }
    
    static public TokenType getOpType(String lexeme) {    	
    	switch (lexeme) {
        case "+":
            return TokenType.PLUS;
        case "-":
            return TokenType.MINUS;
        case "*":
            return TokenType.MULT;
        case "/":
            return TokenType.DIV;
        case "=":
            return TokenType.ASSIGN;
        default:
            return TokenType.NULL;
    	}
    }
}
