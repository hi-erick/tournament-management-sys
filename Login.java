import javax.swing.JOptionPane;
import java.nio.file.*;
import java.io.*;

public class Login {
        Path file = Paths.get("Key.txt");
        private InputStream input = null;
        private String line = null;
        private boolean log;
        
        public Login() {
        }
        public void verify() {
            try {
                input = Files.newInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                line = reader.readLine();
                input.close();
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Message: " + e);
            }
        }
        
        public void pass(String value) {
            if ( value.equals(line)) {
                JOptionPane.showMessageDialog(null, "Correct");
                log = true;
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect");
                log = false;
            }  
        }
        
        public boolean getBoolean() {
            return log;
        }
}
