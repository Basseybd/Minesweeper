import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private Toolbar toolbar;
    private Gamebar gamebar;
    private TextPanel textPanel;

    public MainFrame (){
        super("Minesweeper");

        setLayout(new BorderLayout());
        toolbar = new Toolbar();
        textPanel = new TextPanel();
        gamebar = new Gamebar();
        Board Minesweeper = new Board();
        Minesweeper.visualizeComponents();

        toolbar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        //adding components to layout
        add(toolbar, BorderLayout.NORTH);
        add(Minesweeper, BorderLayout.CENTER);
        add(gamebar, BorderLayout.SOUTH);


        //stop the program on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setVisible(true);
    }
}
