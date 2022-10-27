package rpn;

import tokens.Token;
import tokens.TokenType;
import tokens.UnexpectedIdentifierException;


public class Tokenizer {
    public Token getToken(String str) throws UnexpectedIdentifierException {
    	if (Regex.isNum(str))
    		return new Token(TokenType.NUM, str);
    	
    	if (Regex.isOp(str))
            return new Token(Regex.getOpType(str), str);

        if (Regex.isIdentifier(str))
            return new Token(TokenType.VAR, str);

        throw new UnexpectedIdentifierException(str);
    }
}
