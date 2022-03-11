import java.awt.*;
import java.awt.event.*;

public class GetListener extends clientUI implements ActionListener {

    TextField tf;

    public GetListener(TextField tf) {
        this.tf = tf;
    }

    //this method will be called when the user presses the button
    public void actionPerformed(ActionEvent e) {
        System.out.println("The text field says " + tf.getText());
    }
}