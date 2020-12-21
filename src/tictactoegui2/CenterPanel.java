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
//    private ImageIcon X = new ImageIcon(getClass().getClassLoader().getResource("X.png"));
//    private ImageIcon O = new ImageIcon(getClass().getClassLoader().getResource("O.png"));
    private ImageIcon X = new ImageIcon(("src/res/X.png"));
    private ImageIcon O = new ImageIcon(("src/res/O.png"));
    
    public CenterPanel() {
        //Assigning  Buttons
        button = new JButton[9];
        for(int i = 0;i < 9;i++){
            button[i] = new JButton();
            button[i].setPreferredSize(new Dimension(200,200));
            button[i].setFocusable(false);
            button[i].setBackground(Color.BLACK);
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
                turn++;
                    
                if(turn % 2 == 0){
                    button[i].setIcon(O);
                    button[i].setBackground(Color.decode("#FFAF26"));
                }else{
                    button[i].setIcon(X);
                    button[i].setBackground(Color.decode("#2676FF"));
                }
                
                winnerCheck();
            }
        }
    }

    public void winnerCheck(){
        //check winning patterns
        if(hor(O) || ver(O) || dia(O)){
            System.out.println("do something");
        }else if(hor(X) || ver(X) || dia(X)){
            System.out.println("do something");
        }else if (draw(X,O)){
            for(int i = 0;i < 9;i++){
                button[i].setIcon(null);
            }
        }
    }
    
    public boolean hor(ImageIcon shape){
        //check horizontal pattern
        int i = 0;
        for(int j = 0; j < 3;j++){
            if(button[i].getIcon().equals(button[i+1].getIcon()) && button[i+1].getIcon().equals(button[i+2].getIcon()) && button[i] != null){
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
            if(button[i].getIcon().equals(button[i+3].getIcon()) && button[i+3].getIcon().equals(button[i+6].getIcon()) && button[i] != null){
                return true;
            }
            i += 1;
        }
        return false;
    }
    
    public boolean dia(ImageIcon shape){
        //check vertical pattern
        for(int j = 0; j < 3;j++){
            int i = 0;
            if(button[i].getIcon().equals(button[i+4].getIcon()) && button[i+4].getIcon().equals(button[i+8].getIcon()) && button[i].equals(shape)){
                return true;
            }
            if(button[i+2].getIcon().equals(button[i+4].getIcon()) && button[i+4].getIcon().equals(button[i+6].getIcon()) && button[i].equals(shape)){
                return true;
            }
        }
        return false;
    }
    
    public boolean draw(ImageIcon shapeX, ImageIcon shapeO){
        int spotCount = 0;
        boolean draw = true;
        for(int i = 0;i < 9;i++){
            if(!button[i].equals(shapeX) || !button[i].equals(shapeO)){
                spotCount++;
            }
        }
        if(spotCount > 0){
            draw = false;
        }
        return draw;
    }
    
}
