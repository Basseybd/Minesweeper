import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private Toolbar toolBar;
    private StatusBar statusBar;

    public MainFrame (){
        super("Minesweeper");

        setLayout(new BorderLayout());
        toolBar = new Toolbar();
        statusBar = new StatusBar();
        Board Minesweeper = new Board();
        Minesweeper.visualizeComponents();

        //adding components to layout
        add(toolBar, BorderLayout.NORTH);
        add(Minesweeper, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        //add smiley face button
        JButton smiley = new JButton(new ImageIcon("./Images/smile.png"));
        smiley.setRolloverEnabled(true);
        //smiley.addActionListener();
        smiley.setRolloverIcon(new ImageIcon("./Images/shock.png"));
        toolBar.add(smiley);//,BorderLayout.NORTH);
        
        
        //stop the program on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Minesweeper.getsize()*40,700);
        ImageIcon i = new ImageIcon("./Images/unclicked.png");
        
        System.out.print(i.getIconWidth());
        setVisible(true);
    }
}
