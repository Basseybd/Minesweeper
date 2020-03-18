import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private Toolbar toolBar;
    private StatusBar statusBar;
    private String difficulty;

    public MainFrame (String text){
        super("Minesweeper");

        if (text == "None"){
            difficulty = "Normal";
        }
        else
        {
            difficulty = text;
        }


        //TODO change fake values
        boolean stopscore = false;
        int RemainingMines = 4;

        setLayout(new BorderLayout());
        toolBar = new Toolbar(difficulty);
        statusBar = new StatusBar(stopscore,RemainingMines);
        Board Minesweeper = new Board(difficulty);
        Minesweeper.visualizeComponents();

        toolBar.setComboBoxListener(new ComboBoxListener() {
            @Override
            public void difficultySelected(String text) {
                setVisible(false);
                dispose();
                new MainFrame(text);
            }
        });

        //Todo add a confirmation pop-up
        toolBar.setButtonListener(new ButtonListener() {
            @Override
            public void buttonClicked(String text) {
                setVisible(false);
                dispose();
                new MainFrame(difficulty);
            }
        });

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
