package UIController;

import Logic.Account;
import Logic.Transfer;
import Logic.User;
import UI.TransferOutUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Calendar;


/**
 * Created by Devene on 3/20/2016.
 */
public class TransferOutC {
    private TransferOutUI view;
    private User cont;

    public TransferOutC(User session) {
        this.view = OptiuniC.trO;
        view.addTransListener(new TransListener());
        view.addBackListener(new BackListener());
        this.cont = session;
        view.numeC.setText(cont.getNume());
        view.numeC.setEditable(false);
    }

    class TransListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String tipS = (String)view.contS.getSelectedItem();
            String tipD = (String)view.contD.getSelectedItem();
            String detali = view.detTA.getText();
            double suma = Double.parseDouble(view.sumaD.getText());
            String nume = view.numeD.getText();
            Account contS = new Account();
            Account contD = new Account();
            String dateS = contS.find(cont.getNume(),tipS);
            String dateD = contD.find(nume,tipD);
            String[] start = dateS.split(",");
            String[] dest = dateD.split(",");
            double amount = Double.parseDouble(start[2]);
            double comm = Double.parseDouble(start[4]);
            double amountD = Double.parseDouble(dest[2]);
            Calendar cal = Calendar.getInstance();
            Timestamp timp = new Timestamp(cal.getTime().getTime());
            if(amount-suma-comm<0 && tipS.equals("Credit")){
                contS.update(cont.getNume(),amount-suma-comm, tipS);
                contD.update(nume,amountD+suma, tipD);
                Transfer rap = new Transfer(timp,cont.getNume(),start[1],nume,dest[1],suma,detali);
                rap.intsert(rap);
            }else if(amount-suma-comm>=0){
                contS.update(cont.getNume(),amount-suma-comm, tipS);
                contD.update(nume,amountD+suma, tipD);
                Transfer rap = new Transfer(timp,cont.getNume(),start[1],nume,dest[1],suma,detali);
                rap.intsert(rap);
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
