import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
class Frames implements ActionListener{
    static JButton teamA = new JButton("Team A");
    static JButton teamB = new JButton("Team B");
    static JButton teamC = new JButton("Team C");
    static JButton teamD = new JButton("Team D");
    static JButton teamE = new JButton("Team E");
    static JButton teamF = new JButton("Team F");
    static JButton teamG = new JButton("Team G");
    static JButton teamH = new JButton("Team H");
    static JButton teamI = new JButton("Team I");
    static JButton teamJ = new JButton("Team J");
    public static void main(String [] args) {
        JRadioButton win = new JRadioButton("Won");
        JRadioButton loss = new JRadioButton("Loss");
        JRadioButton draw = new JRadioButton("Draw");
        JFrame frame = new JFrame("Wins/Loses");
        JFrame frame1 = new JFrame("Team A");
        JFrame frame2 = new JFrame("Team B");
        JFrame frame3 = new JFrame("Team C");
        JFrame frame4 = new JFrame("Team D");
        JFrame frame5 = new JFrame("Team E");
        JFrame frame6 = new JFrame("Team F");
        JFrame frame7 = new JFrame("Team G");
        JFrame frame8 = new JFrame("Team H");
        JFrame frame9 = new JFrame("Team I");
        JFrame frame10 = new JFrame("Team J");

        frame.add(win);
        frame.add(loss);
        frame.add(draw);
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        teamA.addActionListener(this);
        teamB.addActionListener(this);
        teamC.addActionListener(this);
        teamD.addActionListener(this);
        teamE.addActionListener(this);
        teamF.addActionListener(this);
        teamG.addActionListener(this);
        teamH.addActionListener(this);
        teamI.addActionListener(this);
        teamJ.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == teamA) {
            
        }
    }
}