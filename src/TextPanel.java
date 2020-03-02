import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private JTextArea textArea;
    public TextPanel(){
        textArea = new JTextArea();
        setLayout(new BorderLayout());
        add(textArea, BorderLayout.CENTER);

        //Add scroll bars at the bottom and right not needed tho
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    //action to append text
    public void appendText(String text){
        textArea.append(text);
    }
}
