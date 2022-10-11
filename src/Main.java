import java.nio.file.Path;
import java.nio.file.Paths;

import rpn.RpnInterpreter;

public class Main {
    public static void main(String args[]) {
        try {
        	Path filepath = Paths.get(args[0]);
        	RpnInterpreter.readFile(filepath);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Forneça o caminho para um arquivo.");
        }
    }
}