import javax.swing.*;
import java.util.*;

public class Teams {

   private String[] a;
   private int nElems = 0; //counter to keep track of # of teams

   public Teams() {
      a = new String[10];
   }

   public void insert(String value) {
      a[nElems] = value;
      nElems++;
   }

   //show team names randomized
   public void display() {
      List<String> nameList = Arrays.asList(a);
      Collections.shuffle(nameList);
      a = nameList.toArray(new String[nameList.size()]);
      JOptionPane.showMessageDialog(null, Arrays.toString(a));
   }
}