package Database;

import java.sql.*;

/**
 * Created by Devene on 3/22/2016.
 */
public class SQLConnection {
    private static Connection con;
    private Statement st;
    private ResultSet rez;
    private PreparedStatement pst;

    public static void Connect() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest","root","");
        }catch (Exception ex) {
            System.out.println("Errot: " + ex);
        }
    }
}
