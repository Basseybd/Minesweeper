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
        
        //stop the program on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Minesweeper.getsize()*40,700);
        ImageIcon i = new ImageIcon("./Images/unclicked.png");
        
        System.out.print(i.getIconWidth());
        setVisible(true);
        setResizable(false);
    }
}
