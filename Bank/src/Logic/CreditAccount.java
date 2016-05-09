package Logic;

/**
 * Created by Devene on 3/20/2016.
 */
public class CreditAccount extends Account {

    public boolean Account(String owner,String tip,String iden,double suma,double com,double inte) {
        try {
            String values = owner+","+tip+","+iden+","+String.valueOf(suma)+","+String.valueOf(com)+","+String.valueOf(inte);
            if(Insert(values)){
                closeCon();
                return true;
            } else{
                closeCon();
                return false;
            }
        } catch (Exception ex){
            return false;
        }
    }
}
