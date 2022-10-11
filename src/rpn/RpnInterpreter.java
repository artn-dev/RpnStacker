package rpn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import tokens.Token;
import tokens.UnexpectedIdentifierException;

public class RpnInterpreter {
    private static Tokenizer tokenizer = new Tokenizer();
    private static Parser parser       = new Parser();

    static public void readFile(Path path){
        try {
            ArrayList<Token> tokens = new ArrayList<Token>();
            
            for (String line : Files.readAllLines(path)) {
            	Token t = tokenizer.getToken(line);
            	
            	tokens.add(t);
            	System.out.println(t);
            }
            
            Integer result = 0;
            for (Token t : tokens)
            	result = parser.parse(t);
            
            System.out.println(result);

        } catch (UnexpectedIdentifierException e) {
            System.out.println(e);
            
        } catch (IOException e) {
        	System.out.println("Problema ao abrir arquivo: " + path);
			e.printStackTrace();
		}
    }
}
