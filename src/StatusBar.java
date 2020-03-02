import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusBar extends JPanel {
    private JLabel score;
    private JLabel smiley;
    private JLabel mines;

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

    public StatusBar(){

        ImageIcon bomb = new ImageIcon("Images/bomb.png", "Bomb placeholder for smile");
        //Button text
        score = new JLabel("score");
        smiley = new JLabel(bomb);
        mines = new JLabel("mines");

        //flow layout for the tool bar
        setLayout(new FlowLayout());

        add(score);
        add(smiley);
        add(mines);

    }
}
