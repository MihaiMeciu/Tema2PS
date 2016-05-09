package Logic;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by Devene on 4/14/2016.
 */
public class JSONRaport implements Raport {

    private String[] nume;
    private String begin;
    private String end;

    public JSONRaport(String nume,String begin, String end){
        this.nume = nume.split(",");
        this.begin = begin;
        this.end = end;
    }

    public void generate(String cale){
        try{
            Transfer rap = new Transfer();
            ArrayList<String> rasp;
            JSONArray arr = new JSONArray();
            JSONObject fis = new JSONObject();
            for (int i=0;i<nume.length;i++){
                rasp = rap.find(nume[i],begin,end);
                for(int j=0;j<rasp.size();j++){
                    String linie = rasp.get(j);
                    String[] elem = linie.split(",");
                    JSONObject trans = new JSONObject();
                    JSONObject col = new JSONObject();
                    trans.put("date",elem[0]);
                    trans.put("fromAccount",elem[1]);
                    trans.put("fromName",elem[2]);
                    trans.put("toAccount",elem[3]);
                    trans.put("toName",elem[4]);
                    trans.put("ammount",elem[5]);
                    trans.put("description",elem[6]);
                    col.put("transaction",trans);
                    arr.add(col);
                }
            }
            fis.put("raport",arr);
            FileWriter file = new FileWriter(cale);
            file.write(fis.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
