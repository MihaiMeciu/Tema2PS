package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class TransferOutUI {
    JFrame frame = new JFrame("-Transfer exterior-");
    JPanel date = new JPanel(new GridLayout(5,3));
    JPanel butoane = new JPanel(new GridLayout(1,2));
    JLabel din = new JLabel("Cont curent");
    JLabel nume = new JLabel("Nume");
    JLabel sume = new JLabel("Suma");
    JLabel in = new JLabel("Destinatie");
    JLabel det = new JLabel("Detali");

    public JTextField numeC = new JTextField("",JTextField.LEFT);
    public JTextField numeD = new JTextField("",JTextField.LEFT);
    public JTextField sumaD = new JTextField("",JTextField.LEFT);
    public JTextArea detTA = new JTextArea("",3,20);
    String[] tipS = {"Activ","Credit"};
    String[] tipD = {"Activ","Credit","Depozit"};
    public JComboBox contS = new JComboBox(tipS);
    public JComboBox contD = new JComboBox(tipD);
    JButton trans = new JButton("Transfera");
    JButton back = new JButton("Back");

    public TransferOutUI() {
        frame.setSize(700,600);
        date.add(din);
        date.add(nume);
        date.add(numeC);
        date.add(contS);
        date.add(in);
        date.add(nume);
        date.add(numeD);
        date.add(sume);
        date.add(sumaD);
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
    public void show(){ frame.setVisible(true);  }
}
