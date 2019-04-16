import javax.swing.JOptionPane;
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
       
        String inPass = JOptionPane.showInputDialog("Enter Password: ");

        if ( inPass.equals(line)) {
            JOptionPane.showMessageDialog(null, "Correct");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect");
        }  
    }
}
