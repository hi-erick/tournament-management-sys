import java.util.Scanner;
import java.nio.file.*;
import java.io.*;

public class Login {
    public static void main(String[] args) {
        Path file = Paths.get("Key.txt");
        InputStream input = null;
        String line = null;
        Scanner in = new Scanner(System.in);
        
        try {
            input = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            line = reader.readLine();
            input.close();
        }
        catch (Exception e) {
            System.out.println("Message: " + e);
        }
       
        System.out.println("type in password");
        String inPass = in.nextLine();

        if ( inPass.equals(line)) {
            System.out.print("correct");
        } else {
            System.out.print("incorrect");
        }  
    }
}