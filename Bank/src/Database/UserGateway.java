package Database;

import Logic.User;

import java.sql.*;
import java.util.Random;

/**
 * Created by Devene on 3/23/2016.
 */
public class UserGateway {
    private Connection con;
    private Statement st;
    private ResultSet rez;
    private PreparedStatement pst;

    public void update(String owner,String adr,String tel,String pass){
        Connect();
        try{
            st = con.createStatement();
            int res = st.executeUpdate("update users set adr=\'"+adr+"\' ,tel=\'"+tel+"\' ,pass=\'"+pass+"\' where nume=\'"+owner+"\'");
        }catch (Exception ex) {

        }
    }
    public void updateData(String owner,String adr,String tel){
        Connect();
        try{
            st = con.createStatement();
            int res = st.executeUpdate("update users set adr=\'"+adr+"\' ,tel=\'"+tel+"\' where nume=\'"+owner+"\'");
        }catch (Exception ex) {

        }
    }
    public String insert(User cont){
        try{
            User ver = find(cont.getNume());
            Connect();
            st = con.createStatement();
            if(ver==null) {
                Random nr = new Random();
                int nrRand = nr.nextInt((30000 - 10000) - 1) + 10000;
                String iden = Integer.toString(nrRand);
                int res = st.executeUpdate("insert into bank.users values (default,\'" + cont.getNume() + "\',\'" + cont.getPass() + "\',\'" + iden + "\',\'" + cont.getAdr() + "\',\'" + cont.getTel() + "\',\'" + cont.getTip() + "\')");
                closeCon();
                return iden;
            }
            closeCon();
            return ver.getIden();
        }catch (Exception ex) {
            closeCon();
            return "";
        }
    }
    private void Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
        }catch (Exception ex) {
            System.out.println("Errot: " + ex);
        }
    }
    public User find(String owner){
        Connect();
        try {
            st = con.createStatement();
            rez = st.executeQuery("select * from bank.users where nume=\'"+owner+"\'");
            if(rez.next()) {
                String nume = rez.getString("nume");
                String pass = rez.getString("pass");
                String iden = rez.getString("iden");
                String adr = rez.getString("adr");
                String tel = rez.getString("tel");
                String tip = rez.getString("tip");
                User cont = new User(nume,pass,adr,tel,tip);
                cont.setIden(iden);
                closeCon();
                return cont;
            }
            closeCon();;
            return null;
        }catch (Exception e) {
            closeCon();
            return null;
        }
    }
    public void closeCon() {
        try {
            if (rez != null) {
                rez.close();
            }

            if (st != null) {
                st.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (Exception e) {

        }
    }
}
