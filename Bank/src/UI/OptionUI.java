package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class OptionUI {
    static JFrame frame = new JFrame("-Optiuni-");
    JPanel optiuni = new JPanel(new GridLayout(3,3));
    JButton view = new JButton("Vizualizare date");
    JButton transfIn = new JButton("Transfer intre conturi");
    JButton transfOut = new JButton("Transfern carte alte conturi");
    JButton newClient = new JButton("Client nou");
    JButton transfGen = new JButton("Transfer generic");
    JButton newOperator = new JButton("Operator nou");
    JButton rap = new JButton("Raporturi");
    JButton logout = new JButton("Logout");

    public OptionUI(String tip) {
        frame.setSize(650,600);
        switch (tip.toLowerCase()) {
            case "client": {
                optiuni.add(view);
                optiuni.add(transfIn);
                optiuni.add(transfOut);
                optiuni.add(logout);
                optiuni.add(rap);
                break;
            }
            case "operator":{
                optiuni.add(view);
                optiuni.add(transfGen);
                optiuni.add(newClient);
                optiuni.add(logout);
                optiuni.add(rap);
                break;
            }
            case "admin":{
                optiuni.add(newOperator);
                optiuni.add(logout);
                break;
            }
            default: {
                optiuni.add(logout);
                break;
            }
        }
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(optiuni);
        frame.setVisible(true);
    }
    public void addViewListener(ActionListener viewC){
        view.addActionListener(viewC);
    }
    public void addTrInListener(ActionListener trIn){
        transfIn.addActionListener(trIn);
    }
    public void addTrOutListener(ActionListener trOut){
        transfOut.addActionListener(trOut);
    }
    public void addLogoutListener(ActionListener logOut){
        logout.addActionListener(logOut);
    }
    public void addTrGenListener(ActionListener trGen){
        transfGen.addActionListener(trGen);
    }
    public void addNewCListener(ActionListener newC){
        newClient.addActionListener(newC);
    }
    public void addNewOistener(ActionListener newO){
        newOperator.addActionListener(newO);
    }
    public void addRapListener(ActionListener raport){
        rap.addActionListener(raport);
    }
    public void hide(){
        frame.setVisible(false);
    }
    public void show(){
        frame.setVisible(true);
    }
}
