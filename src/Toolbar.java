import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {
    private JLabel difficulty;
    private JButton restart;
    private StringListener textListener;

    public Toolbar(){
        //flow layout for the tool bar
        setLayout(new FlowLayout(FlowLayout.LEFT));
       //setLayout(new FlowLayout());

        difficulty = new JLabel("Difficulty:");
        //Difficulty combo box
        String[] difficulties = { "Easy", "Normal", "Hard" };
        JComboBox difficultyComboBox = new JComboBox(difficulties);
        difficultyComboBox.setSelectedIndex(2);
        difficultyComboBox.addActionListener(this);


        //add smiley face button
        JButton smiley = new JButton(new ImageIcon("./Images/smile.png"));
        smiley.setRolloverEnabled(true);
        //smiley.addActionListener();
        smiley.setRolloverIcon(new ImageIcon("./Images/shock.png"));

        //restart button
        restart = new JButton("Restart");


        add(difficulty);
        add(difficultyComboBox);
        add(smiley);
        add(restart);

        //add listeners to the button
        difficultyComboBox.addActionListener(this);
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
           if(clicked == restart)
           {
               textListener.textEmitted("Restart game");
           }
        }
    }
}
