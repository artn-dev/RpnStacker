package rpn;

import tokens.TokenType;

public class Regex {
    static private final String PATTERN_OPERATION  = "\\+|\\*|-|/|=";
    static private final String PATTERN_NUMBER     = "\\d+";
    static private final String PATTERN_VARIABLE   = "_*\\w[a-zA-Z0-9_]*";
    static private final String PATTERN_WHITEPSACE = "\\s|\\n|\\r|";

    static public boolean isOp(String lexeme) {
    	return lexeme.matches(PATTERN_OPERATION);
    }
    
    static public boolean isNum(String lexeme) {
    	return lexeme.matches(PATTERN_NUMBER);
    }

    static public boolean isIdentifier(String lexeme) {
        return lexeme.matches(PATTERN_VARIABLE);
    }
    
    static public boolean isWhiteSpace(String lexeme) {
    	return lexeme.matches(PATTERN_WHITEPSACE);
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
