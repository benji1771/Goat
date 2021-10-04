import Goat;
public class UI extends JFrame{

    public UI(){
        //Start The UI HERE
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);

        //All Components
        /*
        Buttons: Keywords____Directory, Create Goat, Burp
        Textpane: name, max,
        */
        JButton userInput = new JButton("Submit");
        JButton makeGoat = new JButton("Create");
        JButton burp = new JButton("Burp");


        pack();
    }
    public static void main(String args[]){

    }
}