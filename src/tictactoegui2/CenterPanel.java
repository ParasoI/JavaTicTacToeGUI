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
                
                //winnerCheck();
            }
        }
    }

    
}
