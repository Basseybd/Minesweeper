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
       //setLayout(new FlowLayout());

        difficultyLabel = new JLabel("Difficulty:");
        //Difficulty combo box
        String[] difficulties = { "Easy", "Normal", "Hard" };
        JComboBox difficultyComboBox = new JComboBox(difficulties);
        difficultyComboBox.setSelectedItem((Object)difficultly);
        difficultyComboBox.addItemListener(this::itemStateChanged);


        //add smiley face button
        JButton smiley = new JButton(new ImageIcon("./Images/smile.png"));
        smiley.setRolloverEnabled(true);
        //smiley.addActionListener();
        smiley.setRolloverIcon(new ImageIcon("./Images/shock.png"));

        //restart button
        restart = new JButton("Restart");


        add(difficultyLabel);
        add(difficultyComboBox);
        add(smiley);
        add(restart);

        //add listeners to the button
        difficultyComboBox.addActionListener(this);
        restart.addActionListener(this);

    }

    //
    public void setButtonListener(ButtonListener listener){
        this.buttonListener = listener;
    }

    public void setComboBoxListener(ComboBoxListener listener){
        this.comboBoxListener = listener;
    }


    public void actionPerformed(ActionEvent event){
        Object sourceObject = event.getSource();
        JButton button = (JButton)sourceObject;
        Object clickedButton = button.getText();
        if (buttonListener != null){
            buttonListener.buttonClicked(clickedButton.toString());

        }
    }

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
