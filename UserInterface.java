
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

//possibly update to make more visually pleaseing once done//
public class UserInterface extends JFrame implements ActionListener {
   Container con = getContentPane();
   JPanel buttons = new JPanel();
   JPanel fill = new JPanel();
   JLabel tips = new JLabel("<html>This is temporary <br> so is this <html>");
   JButton match = new JButton("Match-ups");
   JButton team = new JButton("Add Teams");
   JButton score = new JButton("Scoreboard");
   JButton info = new JButton("Information");
   JButton help = new JButton("Help");
   JButton admin = new JButton("Admin");
   boolean log = false;
   
   public static void main (String [] args) {
      UserInterface frame = new UserInterface(); 
      frame.setSize(700,500);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
   }
   public UserInterface() {
      super ("Tournament Organization");
      con.setLayout( new BorderLayout() );
      con.add(buttons,BorderLayout.NORTH);
      buttons.add(match);
      buttons.add(score);
      buttons.add(info);
      buttons.add(help);
      buttons.add(admin);    
      con.add(fill,BorderLayout.CENTER);
      admin.setToolTipText("<html>Allows an admin to login<html?");
      match.setToolTipText("<html>Displays upcoming<br>tournament match-ups</html>");
      score.setToolTipText("<html>Displays current standings <br> of the teams</html>");
      info.setToolTipText("<html>Provides information pertaining <br> to tournament scheduling</html>");
      help.setToolTipText("<html>Provides additional information <br> on how to use the program</html>");
      admin.addActionListener(this);
      match.addActionListener(this);
      score.addActionListener(this);
      info.addActionListener(this);
      help.addActionListener(this);
   }
      public void actionPerformed(ActionEvent e) { 
         if(e.getSource()==admin){ 
           login(); 
         }
         if (e.getSource()==match) {
            matchups();
         }
         if (e.getSource()==score) {
            scoreboard();
         }
         if (e.getSource()==info) {
            information();
         }
         if (e.getSource()==help) {
           help(); 
         }
         if (e.getSource()==team) {
           team();
         }
      }
      
      public void login() {  
         Path file = Paths.get("Key.txt");
         InputStream input = null;
         String line = null;
         Scanner in = new Scanner(System.in);
            try {
               input = Files.newInputStream(file);
               BufferedReader reader = new BufferedReader(new InputStreamReader(input));
               line = reader.readLine();
               input.close();
    
               String inPass = JOptionPane.showInputDialog("Enter Passwird: ");
            
            if (inPass.equals(line)) {
               JOptionPane.showMessageDialog(null, "Correct");
               log=true;
            }
            else {
               JOptionPane.showMessageDialog(null, "Incorrect");
            }
            }
            catch (Exception ex) {
               System.out.println("Message: " + ex); //might want to make this a JOptionPane popup//
            }
      }
      //pull matchups and place them in a table
      public void matchups() { 
         clear();
         if (log==true ) {
         fill.add(team);
         team.setToolTipText("<html>Add teams to the tournament roster<html?");
         team.addActionListener(this);  
         }
         else {
         
         }            
         validate();
         repaint();
      }
      //displays the current scores of each team from highest to lowest
      public void scoreboard() { 
         clear();
         validate();
         repaint();
      }
      //provides the user with tips for how to better navigate the program
      public void help() {  
         fill.add(tips);
         tips.setVisible(true);
         validate();
         repaint();
      }
      //provides information relating to schedualing of events
      public void information () {  
         clear();
         validate();
         repaint();
      }
      public void team () {
         scheduleManagement schedule = new scheduleManagement();
         schedule.setSize(400,200);
         schedule.setLocationRelativeTo(null);
         schedule.setVisible(true);     
      }
      //removes items from other "screens"
      public void clear () { 
         fill.remove(tips);
         fill.remove(team);
         validate();
         repaint();
      }
}
      
