import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class Toolbar extends JPanel implements ActionListener {
    private JLabel difficultyLabel;
    private JButton restart;
    private ButtonListener buttonListener;
    private ComboBoxListener comboBoxListener;


    public Toolbar(String difficultly){
        //flow layout for the tool bar
        setLayout(new FlowLayout(FlowLayout.LEFT));

        //add labels
        difficultyLabel = new JLabel("Difficulty:");

        //add comboBox for difficulty
        String[] difficulties = { "Easy", "Normal", "Hard" };
        JComboBox difficultyComboBox = new JComboBox(difficulties);
        difficultyComboBox.setSelectedItem((Object)difficultly);


        //add smiley face button
        JButton smiley = new JButton(new ImageIcon("./Images/smile.png"));
        smiley.setRolloverEnabled(true);
        smiley.setRolloverIcon(new ImageIcon("./Images/shock.png"));

        //add buttons
        restart = new JButton("Restart");
        add(difficultyLabel);
        add(difficultyComboBox);
        add(smiley);
        add(restart);

        //add listeners to the button
        difficultyComboBox.addItemListener(this::itemStateChanged);
        restart.addActionListener(this);

    }

    //add functions to set listeners
    public void setButtonListener(ButtonListener listener){
        this.buttonListener = listener;
    }

    public void setComboBoxListener(ComboBoxListener listener){
        this.comboBoxListener = listener;
    }

    //button actions listener
    public void actionPerformed(ActionEvent event){
        Object sourceObject = event.getSource();
        JButton button = (JButton)sourceObject;
        Object clickedButton = button.getText();
        if (buttonListener != null){
            buttonListener.buttonClicked(clickedButton.toString());

        }
    }

    //comboBox state changed listener
    public void itemStateChanged(ItemEvent event){
        if(event.getStateChange() == ItemEvent.SELECTED){
            Object sourceObject = event.getSource();
            JComboBox comboBox = (JComboBox)sourceObject;
            Object selected = comboBox.getSelectedItem();
            System.out.println(comboBox.getSelectedItem()+" test");
            comboBoxListener.difficultySelected(selected.toString());
        }
    }
}
