package rpn;

import tokens.TokenType;

public class Regex {
    static private final String PATTERN_OPERATION = "\\+|\\*|-|/";
    static private final String PATTERN_NUMBER    = "\\d+";

    static public boolean isOp(String lexeme) {
    	return lexeme.matches(PATTERN_OPERATION);
    }
    
    static public boolean isNum(String lexeme) {
    	return lexeme.matches(PATTERN_NUMBER);
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
        default:
            return TokenType.NULL;
    	}
    }
}
