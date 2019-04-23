import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
   JPanel adminButtons = new JPanel();
   JPanel centerFill = new JPanel();
   JTextField in = new JTextField(50);
   JLabel tips = new JLabel();
   JButton match = new JButton("Match-ups");
   JButton teams = new JButton("Enter Teams");
   JButton displayTeams = new JButton("Show Teams");
   JButton score = new JButton("Scoreboard");
   JButton info = new JButton("Information");
   JButton help = new JButton("Help");
   JButton admin = new JButton("Admin");
   JButton logout = new JButton("logout");
   JButton generate = new JButton("Generate Schedule");
   JTable table;

   JLabel scheduleTip = new JLabel("");
   JLabel names = new JLabel();
   JLabel guides = new JLabel("Enter the names of the teams participating in this tournament seperated by commas.");
   JLabel instructions = new JLabel("The team names for this tournament are:");
   String st;
   String[] s; //team names
   int[] scoreList;

   JScrollPane scrollPane;

   //int a, b, c, d, e, f, g, h, i, j; 
   String teamA, teamB, teamC, teamD, teamE, teamF, teamG, teamH, teamI, teamJ, teamK;

   boolean log ;
   boolean teamEntered = false;
   boolean delay =  false;
   Login access = new Login();
   //Points points = new Points();
   Teams array = new Teams();
   //Matchups1 matches = new Matchups1();

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
      fill.setLayout(new BorderLayout()); 
      fill.add(adminButtons,BorderLayout.NORTH);
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
      teams.addActionListener(this); 
      in.addActionListener(this);
      logout.addActionListener(this); 
      generate.addActionListener(this);
   }

   public void actionPerformed(ActionEvent e) { 

      if(e.getSource()==admin){ 
         login(); 
      }

      if(e.getSource()==generate){ 
         String sche = "";
         try{
            Matchups1 matches = new Matchups1(s);           
         }
         catch(Exception ee) {
         }
         try {
            BufferedReader reader = new BufferedReader(new FileReader("schedule.txt"));
            //String helpIn = "";
            while((sche = reader.readLine()) != null) {
               scheduleTip.setText(sche);
            }
            reader.close();
         }
         catch(Exception eee) {
            JOptionPane.showMessageDialog(null, "Message: " + eee);
         }
         centerFill.add(scheduleTip);
         validate();
         repaint();
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
      }

      if (e.getSource()==logout) {
         buttons.remove(logout);
         log = false;
         validate();
         repaint();
      }
   }

      
   public void login() {  
      String inPass = JOptionPane.showInputDialog("Enter Password: ");
      access.verify();
      access.pass(inPass);
      log = access.getBoolean();
      if (log== true) {
         buttons.add(logout);
      }
      validate();
      repaint();
   }

      //pull matchups and place them in a table

   public void matchups() { 
      clear();
      if (log==true ) {
      adminButtons.add(teams);
      fill.add(adminButtons,BorderLayout.NORTH);
      teams.setToolTipText("<html>Add teams to the tournament roster<html?"); 
      }
      else {
      }            
      validate();
      repaint();
   }

      //displays the current scores of each team

   public void scoreboard() { 
      clear();
      if (teamEntered == true)
         scoreTable();
      else {
         names.setText("No teams have been added yet.");
         adminButtons.add(names);
         fill.add(adminButtons,BorderLayout.NORTH);
      }
      validate();
      repaint();
   }

      //provides the user with tips for how to better navigate the program

   public void help() { 
      clear();
      try {
         BufferedReader inHelp =new BufferedReader(new FileReader ("helpScreen.txt"));
         String helpIn;
         while((helpIn = inHelp.readLine()) != null) {
            tips.setText(helpIn);
         }
         inHelp.close();
      }

      catch (Exception ex) {
         JOptionPane.showMessageDialog(null, "Message: " + ex);
      }

      adminButtons.add(tips);
      fill.add(adminButtons,BorderLayout.NORTH);
      validate();
      repaint();
   }

      //provides information relating to schedualing of events

   public void information () {  
      clear();
      if (delay==false) {
         JLabel noDelay = new JLabel("There are no delays in this tournament");
         fill.add(adminButtons, BorderLayout.NORTH);
         adminButtons.add(noDelay,BorderLayout.NORTH);
      }
      else {
      }
      validate();
      repaint();
   }

   public void teams() {
      centerFill.add(guides);
      centerFill.add(in); 
      fill.add(centerFill,BorderLayout.CENTER);          
      validate();
      repaint();     
   }

      //removes items from other screens

   public void clear() { 
      fill.removeAll();
      centerFill.removeAll();
      adminButtons.removeAll();
      validate();
      repaint();
   }

   public void scoreTable() {
      String[] columnNames = {"Team Name","Score"};
      String[] scorePrint = new String[scoreList.length];
      for (int i = 0;i<scoreList.length;i++) {
         scorePrint[i] = String.valueOf(scoreList[i]);
      }

      DefaultTableModel model = new DefaultTableModel (columnNames, 0);
      for(int i=0;i<s.length;i++) {
         Vector row = new Vector(2);
         row.add(s[i]);
         row.add(scorePrint[i]);
         model.addRow(row);
      }
      JTable table = new JTable (model);
      table.setLayout(new FlowLayout());
      table.setPreferredScrollableViewportSize(new Dimension(500,s.length*16));
      table.setFillsViewportHeight(true);
      table.getTableHeader().setReorderingAllowed(false);
      scrollPane = new JScrollPane(table);
      centerFill.add(scrollPane,BorderLayout.CENTER);
      fill.add(centerFill,BorderLayout.CENTER);
   }

   public void inField() {
      try {
         String str = in.getText();            
         s = str.split("[ ]*,[ ]*"); 
         if(s.length>10) {
            JOptionPane.showMessageDialog(null, "<html>too many teams entered<br>please try again<html>");
            Arrays.fill(s,null);
         }
         else {
            fill.add(instructions);
            fill.add(names);
            names.setText(str);
            System.out.println(Arrays.toString(s));
            scoreList = new int [s.length];
            for (int i=0;i<s.length;i++){
               scoreList[i]=0;
            }
            validate();
            repaint();
            teamEntered = true;
         }
      }
      catch (Exception ex) {
         JOptionPane.showMessageDialog(null, "Message: " + ex);
      }
      for(int i = 0; i<10; i++) {
         String t = s[i];
         array.insert(t);      
      }
      if(teamEntered == true) {
         adminButtons.add(generate);
         validate();
         repaint();
      }
   }
}
