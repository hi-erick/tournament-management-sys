import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class scheduleManagement extends JFrame implements ActionListener {
    
    //JButton enter = new JButton("Enter");
    //JButton done = new JButton("Done");
    //JTextField input = new JTextField(20);
    JButton teamNames = new JButton("Enter Team Names");
    //String[] options = {"Enter", "Done"};
    public static void main(String[] args) {
        Teams array = new Teams();
        scheduleManagement frame = new scheduleManagement();
        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public scheduleManagement() {
        super();
        setLayout(new FlowLayout() );
        add(teamNames);
        teamNames.addActionListener(this);        
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getScource();

        if(source == teamNames) {
            while(true) {
                String input = JOptionPane.showInputDialog("Enter team names: (click cancel once complete)");
                array.insert(input);
            }
        }
    }
}
