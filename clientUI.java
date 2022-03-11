import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clientUI extends Client implements ActionListener{
    Frame f; //a frame to hold our components
    TextField tf; //a text field to display messages and allow for user input
    Button gd; //a button to generate events
    Button gt; //a button to generate events

    public clientUI() {
        f = new Frame(); //create a new frame
        f.setLayout(new FlowLayout()); //make the layout of the frame a flowlayout
        tf = new TextField(50); //create a textfield with 50 columns
        gd = new Button("Get Date"); //create a button with text to Get Date
        gd.addActionListener(this);
        gt = new Button("Get Time"); //create a button with text to Get Time
        gt.addActionListener(this);
        //add an actionlistener that will take action when the button is pushed
        //pass it the text field so that the listener can get the text out of the textfield
        //and take appropriate action
        f.add(tf); //add the text field to the frame
        f.add(gd); //add the button to the frame
        f.add(gt); //add the button to the frame
        f.setSize(450, 300); //set the size of the frame

        //add the windowlistener that will exit the program when the user closes the window
        f.addWindowListener(new WindowAdapter() {
            // This method is called after a window is closed
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });

        f.show(); //show the frame with the components
    }

    //all programs must have a main
    //this main simply creates a new UIExample object
    public static void main(String[] args) {
        new clientUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (e.getSource() == gd) {
            tf.setText(getDate());
        }
        if (e.getSource() == gt) {
            tf.setText(getTime());
        }

    }

}
