
import javax.swing.*;
import java.util.*;

public class Teams {

   private String[] a;
   private int nElems = 0;
   private String names;

   Teams() {
      a = new String[10];
   }

   public void insert(String value) {
      a[nElems] = value;
      nElems++;
   }

  //show team names
    public void display() {
        JOptionPane.showMessageDialog(null, Arrays.toString(a));
   }
}
