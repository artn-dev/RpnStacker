package rpn;

import java.util.Stack;
import java.util.HashMap;

import tokens.Token;

public class Parser {
    static Stack<Integer> s = new Stack<Integer>();
    static HashMap<String, Integer> hm;

    static public void setVariables(HashMap<String, Integer> hm) {
        Parser.hm = hm;
    }

    static public Integer parse(Token token) throws UnexpectedVariableException {
        switch (token.getType()) {
        case PLUS:
            return s.push(s.pop() + s.pop());
        case MINUS:
            return s.push(s.pop() - s.pop());
        case MULT:
            return s.push(s.pop() * s.pop());
        case DIV:
            return s.push(s.pop() / s.pop());
        case NUM:
            s.push(Integer.parseInt(token.lexeme));
            return 0;
        case VAR: {
            Integer value = s.push(hm.get(token.lexeme));
            if (value == null)
                throw new UnexpectedVariableException(token.lexeme);
			return 0;
        	}
		default:
			return 0;
        }
    }
}
