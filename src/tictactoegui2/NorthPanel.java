package tictactoegui2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ralp
 */
public class NorthPanel extends JPanel {
    
    private JLabel resultLabel;
    private String[] resultString;
    
    NorthPanel(){
        
        resultLabel = new JLabel("TIC-TAC-TOE");
        resultString = new String[3];
        resultString[0] = "Player X";
        resultString[1] = "Player O";
        resultString[2] = "Draw";
        
        
        
        this.setPreferredSize(new Dimension(600,50));
        this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createBevelBorder(2));
        this.setLayout(new GridBagLayout());
    }
}
