package rpn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import tokens.Token;
import tokens.UnexpectedIdentifierException;

public class RpnInterpreter {

    static public void readFile(Path path){
        try {
            ArrayList<Token> tokens = new ArrayList<Token>();
            
            for (String line : Files.readAllLines(path)) {
            	Token t = Tokenizer.getToken(line);
            	
            	if (t != null) {
	            	tokens.add(t);
	            	System.out.println(t);
            	}
            }
            
            for (Token t : tokens) {
            	boolean readingVars = Parser.parseVariables(t);
            	if (!readingVars)
            		break;
            }
            
            Integer result = 0;
            for (Token t : tokens)
            	result = Parser.parseOperations(t);
            
            System.out.println(result);

        } catch (UnexpectedIdentifierException e) {
            System.out.println(e);
           
        } catch (UnexpectedVariableException e) {
        	System.out.println(e);
        
        } catch (IOException e) {
        	System.out.println("Problema ao abrir arquivo: " + path);
			e.printStackTrace();
		}
    }
}
