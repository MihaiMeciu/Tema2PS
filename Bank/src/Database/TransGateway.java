package Database;

import Logic.Transfer;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Devene on 3/24/2016.
 */
public class TransGateway {
    private Connection con;
    private Statement st;
    private ResultSet rez;
    private PreparedStatement pst;

    private void Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
        }catch (Exception ex) {
            System.out.println("Errot: " + ex);
        }
    }
    public void insert(Transfer rap){
        Connect();
        try{
            st = con.createStatement();
            int res = st.executeUpdate("insert into bank.raport values(default,\'"+rap.getTimp()+"\',\'"+rap.getIdS()+"\',\'"+rap.getSursa()+"\',\'"+rap.getIdD()+"\',\'"+rap.getDest()+"\',\'"+String.valueOf(rap.getSuma())+"\',\'"+rap.getDetali()+"\')");
        }catch (Exception ex){

        }
        closeCon();
    }
    public ArrayList<String> find(String oper,String begin, String end){
        Connect();
        try{
            st = con.createStatement();
            rez = st.executeQuery("select * from bank.raport where sursa=\'"+oper+"\'"+" and data between \'"+begin+" 00:00:00"+"\' and \'"+end+" 00:00:00:"+"\'");
            ArrayList<String> rasp = new ArrayList<>();
            while(rez.next()){
                rasp.add(rez.getString("data")+","+rez.getString("idSursa")+","+rez.getString("sursa")+","+rez.getString("idDest")+","+rez.getString("dest")+","+String.valueOf(rez.getDouble("valoare"))+","+rez.getString("detali"));
            }
            closeCon();
            return rasp;
        }catch (Exception ex){
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
