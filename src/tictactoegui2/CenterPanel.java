package tictactoegui2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Abad
 */
public class CenterPanel extends JPanel implements ActionListener {

    private JButton[] button;
    private int turn = 0;
    private NorthPanel northPanel;
    private SouthPanel southPanel;
    private SidePanel sidePanelWest;
    private SidePanel sidePanelEast;
    private ImageIcon X = new ImageIcon(getClass().getClassLoader().getResource("X.png"));
    private ImageIcon O = new ImageIcon(getClass().getClassLoader().getResource("O.png"));
    private ImageIcon BG = new ImageIcon(getClass().getClassLoader().getResource("bg.png"));
//    private ImageIcon X = new ImageIcon(("src/res/X.png"));
//    private ImageIcon O = new ImageIcon(("src/res/O.png"));
//    private ImageIcon BG = new ImageIcon(("src/res/bg.png"));
    
    public CenterPanel() {
        
        //Assigning  Buttons
        button = new JButton[9];
        for(int i = 0;i < 9;i++){
            button[i] = new JButton();
            button[i].setPreferredSize(new Dimension(200,200));
            button[i].setFocusable(false);
            button[i].setBackground(Color.BLACK);
            button[i].setIcon(BG);
            //button Action
            button[i].addActionListener(this);
        }
        
        //CenterPanel
        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(3,3));
        for(int i = 0;i < 9;i++){
            this.add(button[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //button Action when clicked
        for(int i = 0;i < 9;i++){
            if(e.getSource() == button[i]){
                if(button[i].getIcon().equals(BG)){
                    turn++;
                    if(turn % 2 == 0){
                        button[i].setIcon(O);
                        button[i].setBackground(Color.decode("#ffb833"));
                    }else{
                        button[i].setIcon(X);
                        button[i].setBackground(Color.decode("#02d5ff"));
                    }
                }
                
                winnerCheck();
            }
        }
    }

    public void winnerCheck(){
        //check winning patterns
        if(hor(O) || ver(O) || dia(O)){
            addCount(2);
            displayResult(2);
            setSidePanelBackground(2);
            reset();
        }else if(hor(X) || ver(X) || dia(X)){
            addCount(1);
            displayResult(1);
            setSidePanelBackground(1);
            reset();
        }else if (draw()){
            addCount(3);
            displayResult(3);
            setSidePanelBackground(3);
            reset();
        }
        
    }
    
    public boolean hor(ImageIcon shape){
        //check horizontal pattern
        int i = 0;
        for(int j = 0; j < 3;j++){
            if(button[i].getIcon().equals(button[i+1].getIcon()) && button[i+1].getIcon().equals(button[i+2].getIcon()) && button[i].getIcon().equals(shape)){
                return true;
            }
            i += 3;
        }
        return false;
    }
    
    public boolean ver(ImageIcon shape){
        //check vertical pattern
        int i = 0;
        for(int j = 0; j < 3;j++){
            if(button[i].getIcon().equals(button[i+3].getIcon()) && button[i+3].getIcon().equals(button[i+6].getIcon()) && button[i].getIcon().equals(shape)){
                return true;
            }
            i += 1;
        }
        return false;
    }
    
    public boolean dia(ImageIcon shape){
        //check diagonal pattern
            int i = 0;
            if(button[i].getIcon().equals(button[i+4].getIcon()) && button[i+4].getIcon().equals(button[i+8].getIcon()) && button[i].getIcon().equals(shape)){
                return true;
            }
            if(button[i+2].getIcon().equals(button[i+4].getIcon()) && button[i+4].getIcon().equals(button[i+6].getIcon()) && button[i+2].getIcon().equals(shape)){
                return true;
            }
        return false;
    }
    
    public boolean draw(){
        boolean drawCheck;
        int freeSpace = 0;
        
        for(int i = 0;i < 9;i++){
            if(button[i].getIcon().equals(BG)){
                freeSpace++;
            }
        }
        if(freeSpace >= 1){
            return false;
        }else{
            return true;
        }
    }
    
    public void reset(){
        for(int i = 0;i < 9;i++){
            button[i].setBackground(Color.BLACK);
            button[i].setIcon(BG);
        }
        turn = 0;
    }
    
    public void setNorthPanel(NorthPanel northPanel){
        this.northPanel = northPanel;
    }
    
    public void setSouthPanel(SouthPanel southPanel){
        this.southPanel = southPanel;
    }
    
    public void setSidePanel(SidePanel sidePanelWest, SidePanel sidePanelEast){
        this.sidePanelWest = sidePanelWest;
        this.sidePanelEast = sidePanelEast;
    }
    
    public void addCount(int count){
        switch(count){
            case 1:
                southPanel.addXCount(1);
                break;
            case 2:
                southPanel.addOCount(1);
                break;
            case 3:
                southPanel.addDrawCount(1);
                break;
        }
        southPanel.displayCount();
    }
    
    public void displayResult(int num){
        northPanel.setText(num);
    }
    
    public void setSidePanelBackground(int num){
        switch(num){
            case 1:
                sidePanelWest.setBackground(Color.decode("#56d5e8"));
                sidePanelEast.setBackground(Color.decode("#56d5e8"));
                break;
            case 2:
                sidePanelWest.setBackground(Color.decode("#e6b65c"));
                sidePanelEast.setBackground(Color.decode("#e6b65c"));
                break;
            case 3:
                sidePanelWest.setBackground(Color.DARK_GRAY);
                sidePanelEast.setBackground(Color.DARK_GRAY);
                break;
        }
    }
    
}