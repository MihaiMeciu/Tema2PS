package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class LoginUI {
    static JFrame frame = new JFrame("-Internet Banking-");
    JPanel butoane = new JPanel(new GridLayout(1,2));
    JPanel login = new JPanel(new GridLayout(2,2));
    JButton submit = new JButton("Login");
    JLabel userLabel = new JLabel("Username");
    JLabel passLabel = new JLabel("Password");
    public JTextField user = new JTextField("",JTextField.LEFT);
    public JPasswordField pass = new JPasswordField(15);

    public LoginUI() {
        frame.setSize(650,600);
        login.add(userLabel);
        login.add(user);
        login.add(passLabel);
        login.add(pass);
        butoane.add(submit);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(login);
        frame.getContentPane().add(butoane);
        frame.setVisible(true);
    }
    public void addSubmitListener(ActionListener login) {
        submit.addActionListener(login);
    }
    public void hide(){
        frame.setVisible(false);
    }
    public void show(){
        frame.setVisible(true);
    }
}
