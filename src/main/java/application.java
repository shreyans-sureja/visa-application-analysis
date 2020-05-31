import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class application {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Running...");

        //reading file from location
        File file = new File("/home/shreyans/projects/Assignment/src/files/input.txt");

        //seperating bussiness logic from main method
        service server = new service();
        server.readFile(file);
    }
}
