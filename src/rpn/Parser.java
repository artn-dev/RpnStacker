package rpn;

import java.util.Stack;
import java.util.HashMap;

import tokens.Token;

public class Parser {
    static Stack<Integer> s = new Stack<Integer>();
    static HashMap<String, Integer> hm;

    static public void setVariables(HashMap<String, Integer> hm) {
        this.hm = hm;
    }

    static public Integer parse(Token token) {
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
        case IDENTIFIER: {
            Integer value = s.push(hm.get(token.lexeme));
            if (value == null)
                throw new UnexpectedVariableException(token.lexeme);
        }
		default:
			return 0;
        }
    }
}
