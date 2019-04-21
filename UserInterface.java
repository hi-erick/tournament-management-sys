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
   JTextField in = new JTextField(50);
   JLabel tips = new JLabel("<html>This is temporary <br> so is this <html>");
   JButton match = new JButton("Match-ups");
   JButton teams = new JButton("Enter Teams");
   JButton displayTeams = new JButton("Show Teams");
   JButton score = new JButton("Scoreboard");
   JButton info = new JButton("Information");
   JButton help = new JButton("Help");
   JButton admin = new JButton("Admin");
   
   JLabel names = new JLabel();
   JLabel instructions = new JLabel("The team names for this tournament are:");
   String st ;
      
   boolean log ;
   
   Teams array = new Teams();
   Login access = new Login();
   
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
      fill.setLayout(new FlowLayout());
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
         if (e.getSource()==in) {
            inField();  
         }
         if (e.getSource()==teams) {
            teams();
            /*for(int i = 0; i<10; i++) {
               String input = JOptionPane.showInputDialog("Enter team names: ");
               array.insert(input);
            } */
         }
         if (e.getSource()==displayTeams) {
            display();
         }
      }
      
      public void login() {  
         String inPass = JOptionPane.showInputDialog("Enter Password: ");
         access.verify();
         access.pass(inPass);
         log = access.getBoolean();
      }
      //pull matchups and place them in a table
      public void matchups() { 
         clear();
         if (log==true ) {
         fill.add(teams);
         fill.add(displayTeams);
         teams.setToolTipText("<html>Add teams to the tournament roster<html?");
         teams.addActionListener(this); 
         displayTeams.addActionListener(this); 
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
      public void teams() {
         fill.add(in);
         in.addActionListener(this);            
         validate();
         repaint();     
      }
      //removes items from other "screens"
      public void clear() { 
         fill.remove(tips);
         fill.remove(teams);
         fill.remove(in);
         fill.remove(teams);
         fill.remove(displayTeams);
         validate();
         repaint();
      }
      public void display() {
         System.out.println(st);
      }
      public void inField() {
         try {
               String str = in.getText();            
               String [] s = str.split("[ ]*,[ ]*"); 
               
               if(s.length>10) {
                  JOptionPane.showMessageDialog(null, "<html>too many teams entered<br>please try again<html>");
                  Arrays.fill(s,null);
               }
               else {
               fill.add(instructions);
               fill.add(names);
               names.setText(str);
               System.out.println(Arrays.toString(s));
               st = Arrays.toString(s);
               validate();
               repaint();
               }
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Message: " + ex);
            }
      }

}
   
