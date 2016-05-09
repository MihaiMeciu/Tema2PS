package UIController;

import Logic.Raport;
import Logic.RaportFactory;
import UI.RaportUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class RaportC {
    private RaportUI view;
    RaportFactory fabrica = new RaportFactory();
    public RaportC(){
        this.view = OptiuniC.rap;
        view.addBackListener(new BackListener());
        view.addXMLListener(new XMLListener());
        view.addJSONListener(new JSONListener());
    }

    class BackListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            LoginC.op.show();
            view.hide();
        }
    }
    class XMLListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String nume = view.oper.getText();
            String begin = view.begin.getText();
            String end = view.end.getText();
            if(!nume.equals("")){
                if(begin.contains("-")){
                    if(end.contains("-")){
                        Raport rap = fabrica.getRaport("XML",nume,begin,end);
                        rap.generate("D:\\Proiecte\\Tema2Ps\\rap.xml");
                    }
                }
            }
        }
    }
    class JSONListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String nume = view.oper.getText();
            String begin = view.begin.getText();
            String end = view.end.getText();
            if(!nume.equals("")){
                if(begin.contains("-")){
                    if(end.contains("-")){
                        Raport rap = fabrica.getRaport("JSON",nume,begin,end);
                        rap.generate("D:\\Proiecte\\Tema2Ps\\rap.json");
                    }
                }
            }
        }
    }
}
