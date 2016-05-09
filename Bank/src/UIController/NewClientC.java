package UIController;

import Logic.ActiveAccount;
import Logic.CreditAccount;
import Logic.Deposit;
import Logic.User;
import UI.NewClientUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class NewClientC {
    private NewClientUI view;

    public NewClientC() {
        this.view = OptiuniC.newC;
        view.addAddListener(new AddListener());
        view.addBakcListener(new BackListener());
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String owner = view.nume.getText();
            String adr = view.adr.getText();
            String tel = view.tel.getText();
            String tip = (String) view.tipCombo.getSelectedItem();
            double suma = Double.parseDouble(view.suma.getText());
            double com = Double.parseDouble(view.com.getText());
            double inte = Double.parseDouble(view.inte.getText());
            char[] pas = view.pass.getPassword();
            String pass = String.valueOf(pas);
            User user = new User(owner,pass,adr,tel,"client");
            String iden = user.insert(user);
            switch (tip){
                case "Activ":{
                    ActiveAccount cont = new ActiveAccount();
                    boolean nou = cont.Account(owner,tip,iden,suma,com,inte);
                    break;
                }
                case "Credit":{
                    CreditAccount cont = new CreditAccount();
                    boolean nou = cont.Account(owner,tip,iden,suma,com,inte);
                    break;
                }
                case "Depozit":{
                    Deposit cont = new Deposit();
                    boolean nou = cont.Account(owner,tip,iden,suma,com,inte);
                    break;
                }
            }
        }
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LoginC.op.show();
            view.hide();
        }
    }

}
