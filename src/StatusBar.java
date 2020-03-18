import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class StatusBar extends JPanel {
    private JLabel smiley;
    private JLabel mines;
    private JLabel currentScore;
    private int score;

    //TODO fix this
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            System.out.println("found find file: " + path);
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public StatusBar(boolean stopScore,int remainingMines){
        ImageIcon bomb = new ImageIcon("Images/bomb.png", "Bomb placeholder for smile");
        //adding status labels
        Timer timer = new Timer(1000, new ClockListener());
        timer.setInitialDelay(1);
        timer.start();
        if (stopScore == true) {
            timer.stop();
        }

        currentScore = new JLabel("Score " +  timer);
        smiley = new JLabel(bomb);
        mines = new JLabel("Mines: "+ remainingMines);

        //flow layout for the tool bar
        setLayout(new FlowLayout());

        add(currentScore);
        add(smiley);
        add(mines);


    }

    class ClockListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            score = score + 1;
            currentScore.setText("Score " + score);
        }
    }
}
