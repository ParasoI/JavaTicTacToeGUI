package tictactoegui2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        resultLabel.setFont(new Font("Calibri",Font.BOLD, 20));
        resultLabel.setForeground(Color.WHITE);
        
        this.setPreferredSize(new Dimension(600,50));
        this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createBevelBorder(2));
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        
        this.add(resultLabel,c);
    }
    
    public void setText(int num){
        switch(num){
            case 1:
                resultLabel.setForeground(Color.CYAN);
                resultLabel.setText("Player X wins!");
                break;
            case 2:
                resultLabel.setForeground(Color.ORANGE);
                resultLabel.setText("Player O wins!");
                break;
            case 3:
                resultLabel.setForeground(Color.lightGray);
                resultLabel.setText("It's a DRAW!");
                break;
        }
    }
}
