import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class scheduleManagement extends JFrame implements ActionListener {
    
    Teams array = new Teams();
    
    JButton displayTeams = new JButton("Show Teams");
    JButton teamNames = new JButton("Enter Team Names");
    String input;
    
    public static void main(String[] args) {
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
        add(displayTeams);
        teamNames.addActionListener(this);
        displayTeams.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == teamNames) {
            for(int i = 0; i<10; i++) {
                input = JOptionPane.showInputDialog("Enter team names: (click cancel once complete)");
                array.insert(input);
            }
        }
        if(source == displayTeams) 
            array.display();
    }
}
