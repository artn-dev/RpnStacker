package rpn;

import java.util.Stack;
import java.util.HashMap;

import tokens.Token;

public class Parser {
    static Stack<Integer> s = new Stack<Integer>();
    static HashMap<String, Integer> hm = new HashMap<String, Integer>();
    
    static String tmp = ""; // Para guardar is ids até que um valor seja atribuído

    static public boolean parseVariables(Token token) {
    	switch (token.getType()) {
    	case NUM:
    		s.push(Integer.parseInt(token.getLexeme()));
    		break;
    		
    	case VAR: {
	    		if (hm.get(token.getLexeme()) == null)
    				Parser.tmp = token.getLexeme();
    			else	// Caso já esteja usando uma variável depois de ler
	    			s.push(0);
    		}
    		break;
    		
    	case ASSIGN: {
    			hm.put(tmp, s.pop());
    			tmp = "";
    		}
    		break;
    		
    	default:	// Detecta que terminou de ler variáveis
    		s.pop();
    		s.pop();
    		return false;
    	}
    	
    	return true;
    }

    static public Integer parseOperations(Token token) throws UnexpectedVariableException {
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
            s.push(Integer.parseInt(token.getLexeme()));
            return 0;
        case VAR: {
            Integer value = s.push(hm.get(token.getLexeme()));
            if (value == null)
                throw new UnexpectedVariableException(token.getLexeme());
			return 0;
        	}
        // Valores de assign não servem para cálculo
        case ASSIGN:
        	s.pop();
        	s.pop();
		default:
			return 0;
        }
    }
}
