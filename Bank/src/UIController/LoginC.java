package UIController;

import Logic.User;
import UI.LoginUI;
import UI.OptionUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class LoginC {

    private LoginUI view;
    public static OptionUI op;

    public LoginC() {
        this.view = Main.view;
        view.addSubmitListener(new LoginListener());
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nume = view.user.getText();
            char[] pas = view.pass.getPassword();
            String pass = String.valueOf(pas);
            User access = User.findByNP(nume,pass);
            if(access!=null){
                view.hide();
                if(op==null) {
                    op = new OptionUI(access.getTip());
                }else{
                    op.show();
                }
                OptiuniC opC = new OptiuniC(access);
            }
        }
    }
}
