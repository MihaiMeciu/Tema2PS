package UIController;

import Logic.User;
import UI.TransferGenUI;
import UI.ViewUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class ViewC {
    private ViewUI view;

    public ViewC() {
        this.view = OptiuniC.det;
        view.addSaveListener(new SaveListener());
        view.addBackListener(new BackListener());
        view.addSearchListener(new SearchListner());
    }

    class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nume = view.nume.getText();
            String adr = view.adr.getText();
            String tel = view.tel.getText();
            char[] pasV = view.passV.getPassword();
            char[] pasN1 = view.passN1.getPassword();
            char[] pasN2 = view.passN2.getPassword();
            String passV = String.valueOf(pasV);
            String passN1 = String.valueOf(pasN1);
            String passN2 = String.valueOf(pasN2);
            if(!passV.equals("")) {
                User cont = User.findByNP(nume, passV);
                if(cont!=null) {
                    if (passN1.equals(passN2)) {
                        cont.update(nume,adr,tel,passN1);
                    }
                }
            }else{
                User cont = User.findByN(nume);
                cont.updateData(nume,adr,tel);
            }
        }
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LoginC.op.show();
            view.hide();
        }
    }
    class SearchListner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nume = view.nume.getText();
            User cont = User.findByN(nume);
            if(cont!=null){
                view.adr.setText(cont.getAdr());
                view.tel.setText(cont.getTel());
                view.nume.setText(cont.getNume());
            }
        }
    }
}
