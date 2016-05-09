package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class RaportUI {
    static JFrame frame = new JFrame("-Raport-");
    JPanel butoane = new JPanel(new GridLayout(1,4));
    JPanel date = new JPanel(new GridLayout(1,1));
    JButton XML = new JButton("Fisier XML");
    JButton JSON = new JButton("Fisier JSON");
    JButton inapoi = new JButton("Back");
    JLabel operL = new JLabel("Utilizator");
    JLabel dataS = new JLabel("Data Inceput");
    JLabel dataF = new JLabel("Data Sfarsit");
    public JTextField oper = new JTextField("",JTextField.LEFT);
    public JTextField begin = new JTextField("",JTextField.LEFT);
    public JTextField end = new JTextField("",JTextField.LEFT);

    public RaportUI(String tip,String nume){
        frame.setSize(650,600);
        date.add(operL);
        date.add(oper);
        date.add(dataS);
        date.add(begin);
        date.add(dataF);
        date.add(end);
        butoane.add(XML);
        butoane.add(JSON);
        butoane.add(inapoi);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(butoane);
        frame.getContentPane().add(date);
        frame.setVisible(true);
        if(tip.equals("client")){
            oper.setText(nume);
            oper.setEditable(false);
        }
    }
    public void addBackListener(ActionListener back){ inapoi.addActionListener(back);}
    public void addXMLListener(ActionListener search){ XML.addActionListener(search);}
    public void addJSONListener(ActionListener search){ JSON.addActionListener(search);}
    public void hide(){ frame.setVisible(false); }
    public void show(){
        frame.setVisible(true);
    }
}
