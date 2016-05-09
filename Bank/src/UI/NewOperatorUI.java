package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class NewOperatorUI {
    JFrame frame = new JFrame("-New Operator-");
    JPanel date = new JPanel(new GridLayout(4,2));
    JPanel butoane = new JPanel(new GridLayout(1,2));
    JButton add = new JButton("Adauga");
    JButton back = new JButton("Back");
    JLabel numeL = new JLabel("Nume");
    JLabel passL = new JLabel("Parola");
    JLabel adrL = new JLabel("Adresa");
    JLabel telL = new JLabel("Telefon");
    public JTextField nume = new JTextField("",JTextField.LEFT);
    public JPasswordField pass = new JPasswordField(15);
    public JTextField adr = new JTextField("",JTextField.LEFT);
    public JTextField tel = new JTextField("",JTextField.LEFT);

    public NewOperatorUI() {
        frame.setSize(650,600);
        date.add(numeL);
        date.add(nume);
        date.add(passL);
        date.add(pass);
        date.add(adrL);
        date.add(adr);
        date.add(telL);
        date.add(tel);
        butoane.add(back);
        butoane.add(add);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(date);
        frame.getContentPane().add(butoane);
        frame.setVisible(true);
    }

    public void addBakcListener(ActionListener inapoi) {
        back.addActionListener(inapoi);
    }
    public void addAddListener(ActionListener adauga) {
        add.addActionListener(adauga);
    }
    public void hide(){
        frame.setVisible(false);
    }
    public void show(){
        frame.setVisible(true);
    }
}
