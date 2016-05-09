package UIController;

import Logic.User;
import UI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class OptiuniC {

    private OptionUI view;
    private User cont;
    public static NewClientUI newC;
    public static NewOperatorUI newO;
    public static RaportUI rap;
    public static TransferGenUI trG;
    public static TransferInUI trI;
    public static TransferOutUI trO;
    public static ViewUI det;

    public OptiuniC(User cont) {
        this.view = LoginC.op;
        view.addLogoutListener(new LogoutListener());
        view.addNewCListener(new NewCliListener());
        view.addNewOistener(new NewOpListener());
        view.addRapListener(new RapListener());
        view.addTrGenListener(new TrGenListener());
        view.addTrInListener(new TrInListener());
        view.addTrOutListener(new TrOutListener());
        view.addViewListener(new ViewListener());
        this.cont = cont;
    }

    class LogoutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.hide();
            Main.view.show();
            LoginC.op=null;
            //view=null;
            newC=null;
            newO=null;
            rap=null;
            trG=null;
            trI=null;
            trO=null;
            det=null;
        }
    }

    class NewCliListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.hide();
            if(newC==null){
                newC = new NewClientUI();
                NewClientC newCC = new NewClientC();
            }else{
                newC.show();
            }
        }
    }
    class NewOpListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.hide();
            if(newO==null){
                newO = new NewOperatorUI();
                NewOperatorC newOC = new NewOperatorC();
            }else{
                newO.show();
            }
        }
    }
    class RapListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.hide();
            if(rap==null){
                rap = new RaportUI(cont.getTip(),cont.getNume());
                RaportC rapC = new RaportC();
            }else{
                rap.show();
            }
        }
    }
    class TrGenListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.hide();
            if(trG==null){
                trG = new TransferGenUI();
                TransferGenC trGC = new TransferGenC(cont);
            }else{
                trG.show();
            }
        }
    }
    class TrInListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.hide();
            if(trI==null){
                trI = new TransferInUI();
                TransferInC trIC = new TransferInC(cont);
            }else{
                trI.show();
            }
        }
    }
    class TrOutListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.hide();
            if(trO==null){
                trO = new TransferOutUI();
                TransferOutC trOC = new TransferOutC(cont);
            }else{
                trO.show();
            }
        }
    }
    class ViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.hide();
            if(det==null){
                det = new ViewUI(cont);
                ViewC detC = new ViewC();
            }else{
                det.show();
            }
        }
    }
}
