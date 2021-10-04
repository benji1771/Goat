import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI extends JFrame implements ActionListener {
    JButton userInput, makeGoat, burp;
    public UI(){
        //Start The UI HERE
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        

        //All Components
        /*
        Buttons: Keywords____Directory, Create Goat, Burp
        Textpane: name, max,
        */
        userInput = new JButton("Submit");
        makeGoat = new JButton("Create");
        burp = new JButton("Burp");
        
        userInput.addActionListener(this);
        makeGoat.addActionListener(this);
        burp.addActionListener(this);

        JPanel panel = new JPanel();

        panel.add(userInput);
        panel.add(burp);
        panel.add(makeGoat);
        this.add(panel);
        pack();
    }
    public static void main(String args[]){
        UI gui = new UI();
        gui.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == userInput){

        }
        if(e.getSource() == makeGoat){

        }
        if(e.getSource() == burp){
            
        }
        
    }
}