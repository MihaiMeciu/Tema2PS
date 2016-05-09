package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class TransferGenUI {
    JFrame frame = new JFrame("-Transfer generic-");
    JPanel date = new JPanel(new GridLayout(6,2));
    JPanel butoane = new JPanel(new GridLayout(1,2));
    JLabel din = new JLabel("Cont curent");
    JLabel nume = new JLabel("Nume");
    JLabel sume = new JLabel("Suma");
    JLabel in = new JLabel("Destinatie");
    JLabel det = new JLabel("Detalii");

    JButton trans = new JButton("Transfera");
    JButton back = new JButton("Back");
    String[] tipS = {"Activ","Credit"};
    String[] tipD = {"Activ","Credit","Depozit"};
    public JComboBox contS = new JComboBox(tipS);
    public JComboBox contD = new JComboBox(tipD);
    public JTextField numeC = new JTextField("",JTextField.LEFT);
    public JTextField numeD = new JTextField("",JTextField.LEFT);
    public JTextField sumaC = new JTextField("",JTextField.LEFT);
    public JTextArea detTA = new JTextArea("",3,30);

    public TransferGenUI() {
        frame.setSize(650,600);
        date.add(din);
        date.add(nume);
        date.add(numeC);
        date.add(contS);
        date.add(sume);
        date.add(sumaC);
        date.add(in);
        date.add(nume);
        date.add(numeD);
        date.add(contD);
        date.add(det);
        date.add(detTA);
        butoane.add(trans);
        butoane.add(back);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(date);
        frame.getContentPane().add(butoane);
        frame.setVisible(true);
    }

    public void addTransListener(ActionListener tra) {
        trans.addActionListener(tra);
    }
    public void addBackListener(ActionListener inapoi) {
        back.addActionListener(inapoi);
    }
    public void hide(){
        frame.setVisible(false);
    }
    public void show(){ frame.setVisible(true); }
}
