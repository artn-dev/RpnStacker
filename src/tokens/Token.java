package tokens;

public class Token {
    public TokenType type;
    public String lexeme;
    
    public Token(TokenType type, String lexeme) {
    	this.type = type;
    	this.lexeme = lexeme;
    }
    
    public TokenType getType() {
    	return type;
    }
    
    public String getLexeme() {
    	return lexeme;
    }
    
    public String toString() {
        return "Token [type="+type+",lexeme="+lexeme+"]";
    }
}
