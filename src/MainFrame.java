import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private Board Minesweeper;
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


        setLayout(new BorderLayout());
        toolBar = new Toolbar(difficulty);
        Minesweeper = new Board(difficulty);
        Minesweeper.visualizeComponents();

        boolean stopScore = Minesweeper.gameover;
        int RemainingMines = Minesweeper.mines;

        statusBar = new StatusBar(stopScore,RemainingMines);

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


        Minesweeper.setMouseClickedListener(new MouseClickedListener() {
            @Override
            public void remainingMines(boolean stopScore,int RemainingMines,boolean iswin) {
                System.out.print("\n Stop please in mainframe \n" + stopScore + RemainingMines);
                statusBar.update(stopScore,RemainingMines);
            }
        });


        //adding components to layout
        add(toolBar, BorderLayout.NORTH);
        add(Minesweeper, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
        
        //stop the program on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Minesweeper.getcols()*40,60+Minesweeper.getrows()*40);
        ImageIcon i = new ImageIcon("./Images/unclicked.png");
        
        System.out.print(i.getIconWidth());
        setVisible(true);
        setResizable(false);
    }
}
