package Logic;

import Database.UserGateway;

/**
 * Created by Devene on 3/20/2016.
 */
public class User {

    private String nume;
    private String pass;
    private String iden;
    private String adr;
    private String tel;
    private String tip;

    public User(String nume, String pass,String adr,String tel,String tip){
        this.nume = nume;
        this.pass = pass;
        this.adr = adr;
        this.tel = tel;
        this.tip = tip;
    }
    public String getNume(){
        return nume;
    }
    public String getPass(){
        return pass;
    }
    public String getAdr(){
        return adr;
    }
    public String getTel(){
        return tel;
    }
    public String getTip(){
        return tip;
    }
    public String getIden(){
        return iden;
    }
    public void setIden(String iden) { this.iden = iden;}
    public String insert(User cont){
        UserGateway gate = new UserGateway();
        String iden = gate.insert(cont);
        return iden;
    }
    public void update(String owner,String adr,String tel,String pass){
        UserGateway gate = new UserGateway();
        gate.update(owner,adr,tel,pass);
    }
    public void updateData(String owner,String adr,String tel){
        UserGateway gate = new UserGateway();
        gate.updateData(owner,adr,tel);
    }
    public static User findByNP(String nume,String pass){
        UserGateway gate = new UserGateway();
        User cont = gate.find(nume);
        if(cont!=null){
            if(cont.getPass().equals(pass)){
                return cont;
            }
            return null;
        }
        return null;
    }
    public static User findByN(String nume){
        UserGateway gate = new UserGateway();
        User cont = gate.find(nume);
        if(cont!=null){
            return cont;
        }
        return null;
    }

}
