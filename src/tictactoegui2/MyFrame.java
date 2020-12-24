package tictactoegui2;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Abad
 */
public class MyFrame extends JFrame {
    
    private CenterPanel centerPanel;
    private SouthPanel southPanel;

    public MyFrame() {
        //Panels
        centerPanel = new CenterPanel();
        southPanel = new SouthPanel();
        
        centerPanel.setSouthPanel(southPanel);
        //Main Frame
        this.setTitle("Tic-Tac-Toe @raru");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,700);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
}
