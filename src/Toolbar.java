import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {
    private JButton difficulty;
    private JButton highscores;
    private JButton restart;
    private StringListener textListener;

    public Toolbar(){
        //Button text
        difficulty = new JButton("Set difficulty");
        restart = new JButton("Restart");

        //flow layout for the tool bar
        //setLayout(new FlowLayout(FlowLayout.LEFT));
        setLayout(new FlowLayout());

        add(difficulty);

        //add smiley face button
        JButton smiley = new JButton(new ImageIcon("./Images/smile.png"));
        smiley.setRolloverEnabled(true);
        //smiley.addActionListener();
        smiley.setRolloverIcon(new ImageIcon("./Images/shock.png"));
        add(smiley);

        add(restart);

        //add listeners to the button
        difficulty.addActionListener(this);
        restart.addActionListener(this);

    }

    //
    public void setStringListener(StringListener listener){
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if(textListener != null){

           if(clicked == difficulty)
           {
               textListener.textEmitted("Difficulty menu");
           }
           if(clicked == highscores)
           {
               textListener.textEmitted("High scores");
           }
           if(clicked == restart)
           {
               textListener.textEmitted("Restart game");
           }
        }
    }
}
