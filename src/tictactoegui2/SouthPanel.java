package tictactoegui2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Abad
 */
public class SouthPanel extends JPanel {

    private JLabel playerX;
    private JLabel playerO;
    private JLabel draw;
    private int xCount;
    private int oCount;
    private int drawCount;
    
    public SouthPanel() {
        
        playerX = new JLabel();
        playerO = new JLabel();
        draw = new JLabel();
        
        xCount = 0;
        oCount = 0;
        drawCount = 0;
        
        playerX.setText("Player X = " + xCount);
        playerX.setForeground(Color.WHITE);
        playerX.setFont(new Font("Calibri",Font.ITALIC,20));
        
        playerO.setText("Player O = " + oCount);
        playerO.setForeground(Color.WHITE);
        playerO.setFont(new Font("Calibri",Font.ITALIC,20));
        
        draw.setText("Draw = " + drawCount);
        draw.setForeground(Color.WHITE);
        draw.setFont(new Font("Calibri",Font.ITALIC,20));
        
        this.setPreferredSize(new Dimension(600,50));
        this.setBackground(Color.BLACK);
        //this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5), BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3)));
        
        this.setLayout(new GridBagLayout());
        groupLayout();
        
    }
    
    public void groupLayout(){
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 20, 0, 20);
        this.add(playerX,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0, 20, 0, 20);
        this.add(playerO,c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(0, 20, 0, 20);
        this.add(draw,c);
    }
    
    public void addXCount(int num){
        xCount += num;
    }
    
    public void addOCount(int num){
        oCount += num;
    }
    
    public void addDrawCount(int num){
        drawCount += num;
    }
    
    public void displayCount(){
        playerX.setText("Player X = " + xCount);
        playerO.setText("Player O = " + oCount);
        draw.setText("Draw = " + drawCount);
    }
    
}
