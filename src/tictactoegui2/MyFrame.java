package tictactoegui2;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Abad
 */
public class MyFrame extends JFrame {
    
    private NorthPanel northPanel;
    private CenterPanel centerPanel;
    private SouthPanel southPanel;
    private SidePanel sidePanelWest;
    private SidePanel sidePanelEast;

    public MyFrame() {
        //Panels
        northPanel = new NorthPanel();
        centerPanel = new CenterPanel();
        southPanel = new SouthPanel();
        sidePanelWest = new SidePanel();
        sidePanelEast = new SidePanel();
        
        //action setters getters
        centerPanel.setNorthPanel(northPanel);
        centerPanel.setSouthPanel(southPanel);
        centerPanel.setSidePanel(sidePanelWest, sidePanelEast);
        
        //Main Frame
        this.setTitle("Tic-Tac-Toe @raru");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(sidePanelWest, BorderLayout.WEST);
        this.add(sidePanelEast, BorderLayout.EAST);
        
        this.setVisible(true);
    }
    
}
