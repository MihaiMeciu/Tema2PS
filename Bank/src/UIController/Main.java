package UIController;

import UI.LoginUI;
import UIController.LoginC;

/**
 * Created by Devene on 3/23/2016.
 */
public class Main {
    public static LoginUI view;
    public static void main(String[] args){
        view = new LoginUI();
        LoginC cont = new LoginC();
    }
}
