package UI;

import Logic.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class ViewUI {
    JFrame frame = new JFrame("-Date-");
    JPanel date = new JPanel(new GridLayout(6,2));
    JPanel butoane = new JPanel(new GridLayout(3,1));
    JButton back = new JButton("Back");
    JButton save = new JButton("Salveaza");
    JButton cauta  =new JButton("Search");
    JLabel numeL = new JLabel("Nume");
    JLabel adrL = new JLabel("Adresa");
    JLabel telL = new JLabel("Telefon");
    JLabel passVL = new JLabel("Parola veche");
    JLabel passNL = new JLabel("Parola noua");
    public JTextField nume = new JTextField("",JTextField.LEFT);
    public JTextField adr = new JTextField("",JTextField.LEFT);
    public JTextField tel = new JTextField("",JTextField.LEFT);
    public JPasswordField passV = new JPasswordField(15);
    public JPasswordField passN1 = new JPasswordField(15);
    public  JPasswordField passN2 = new JPasswordField(15);

    public ViewUI(User cont) {
        frame.setSize(650,600);
        nume.setEditable(false);
        if(cont.getTip().equals("operator")) {
            butoane.add(cauta);
            nume.setEditable(true);
        }
        date.add(numeL);
        date.add(nume);
        date.add(adrL);
        date.add(adr);
        date.add(telL);
        date.add(tel);
        date.add(passVL);
        date.add(passV);
        date.add(passNL);
        date.add(passN1);
        date.add(passNL);
        date.add(passN2);
        butoane.add(back);
        butoane.add(save);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(date);
        frame.getContentPane().add(butoane);
        frame.setVisible(true);
        adr.setText(cont.getAdr());
        tel.setText(cont.getTel());
        nume.setText(cont.getNume());

    }
    public void addBackListener(ActionListener inapoi) {
        back.addActionListener(inapoi);
    }
    public void addSaveListener(ActionListener salveaza) {
        save.addActionListener(salveaza);
    }
    public void addSearchListener(ActionListener search) { cauta.addActionListener(search);}
    public void hide(){
        frame.setVisible(false);
    }
    public void show(){
        frame.setVisible(true);
    }
}
