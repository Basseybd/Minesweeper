import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gamebar extends JPanel {
    private JLabel score;
    private JLabel smiley;
    private JLabel mines;
    private StringListener textListener;

    //TODO FIX THE ICONS
    // Returns an ImageIcon, or null if the path was invalid.
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    ImageIcon smileyicon = new ImageIcon("Images/blank.png", "Placeholder 'blank' smiley");

    public Gamebar(){

        //Button text
        score = new JLabel("score");
        smiley = new JLabel("----Placeholder 'blank' smiley----",smileyicon,JLabel.CENTER);
        mines = new JLabel("mines");

        //flow layout for the tool bar
        setLayout(new FlowLayout());

        add(score);
        add(smiley);
        add(mines);

    }
}
