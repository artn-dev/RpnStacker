package rpn;

import java.util.Stack;

import tokens.Token;

public class Parser {
    Stack<Integer> s = new Stack<Integer>();

    public Integer parse(Token token) {
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
		default:
			return 0;
        }
    }
}