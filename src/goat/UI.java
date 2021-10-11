package goat;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class UI extends JFrame implements ActionListener {
    JButton userInput, makeGoat, eat, burp, eatFull;
    JTextField pane;
    JLabel image;
    Goat myGoat;
    public UI(){
        //Start The UI HERE
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        //All Components
        /*
        Buttons: Keywords____Directory, Create Goat, Burp
        Textpane: name, max,
        */
        userInput = new JButton("Choose Folder");
        makeGoat = new JButton("Create");
        eat = new JButton("Eat");
        eatFull = new JButton("Eat till Full");
        burp = new JButton("Burp");

        eatFull.setVisible(false);
        eat.setVisible(false);
        burp.setVisible(false);

        eatFull.addActionListener(this);
        burp.addActionListener(this);
        userInput.addActionListener(this);
        makeGoat.addActionListener(this);
        eat.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();



        image = new JLabel();
        
        pane = new JTextField();
        pane.setColumns(20);
        pane.setEditable(false);

        //image
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(image, c);

        c.gridwidth = 1;
        //Text Field
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        panel.add(pane, c);

        //userInput
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(userInput, c);
        panel.add(eat, c);

        //makeGoat
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(makeGoat, c);
        panel.add(eatFull, c);

        //burp
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        panel.add(burp, c);
        


        this.add(panel);
        pack();
    }
    public static void main(String args[]){
        try {
            String className = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch (Exception e) {
            e.printStackTrace();
        }

        UI gui = new UI();
        gui.setVisible(true);
    }

    JFileChooser fChooser = new JFileChooser();
    String directoryMeal;
    
    String kwFile;
    File dFile;
    File keys;
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        if(e.getSource() == userInput){
            System.out.println("UserInput Works");
            fChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int r = fChooser.showOpenDialog(null);
 
            if (r == JFileChooser.APPROVE_OPTION) {
                // set the label to the path of the selected directory
                directoryMeal = fChooser.getSelectedFile().getAbsolutePath();
                pane.setText(directoryMeal);
                kwFile = directoryMeal + "\\keywords.txt";
                dFile = new File(directoryMeal);
                keys = new File(kwFile);
            }
        }
        if(e.getSource() == makeGoat){
            System.out.println("makeGoat Works");
            if(!keys.exists()){
                JOptionPane.showMessageDialog(this, "WARNING: THIS WILL RANDOMLY DELETE FILES PERMANENTLY");
                myGoat = new Goat(dFile);
                image.setIcon(new ImageIcon("img/goatImage.jpg"));
                pane.setText("Goat Created");
                userInput.setVisible(false);
                makeGoat.setVisible(false);
                eat.setVisible(true);
                eatFull.setVisible(true);
                burp.setVisible(true);
                pack();
            }else{

                myGoat = new Goat(dFile, keys);
                image.setIcon(new ImageIcon("img/goatImage.jpg"));
                pane.setText("Goat Created");
                userInput.setVisible(false);
                makeGoat.setVisible(false);
                eat.setVisible(true);
                eatFull.setVisible(true);
                burp.setVisible(true);
                pack();
            }
        }
        if(e.getSource() == eat){
            System.out.println("burp Works");
            if(myGoat != null){
                myGoat.eat();
            }
        }
        if(e.getSource() == eatFull){
            if(myGoat != null){
                myGoat.eatTillFull();
            }
        }
        if(e.getSource() == burp){
            if(myGoat != null){
                myGoat.burp();
            }
        }
    }
}