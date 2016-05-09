package Logic;

import Database.TransGateway;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by Devene on 3/20/2016.
 */
public class Transfer {

    private Timestamp timp;
    private String sursa;
    private String idS;
    private String dest;
    private String idD;
    private double suma;
    private String detali;

    public Transfer(){}
    public Transfer(Timestamp timp, String sursa, String idS, String dest, String idD, double suma, String detali){
        this.timp = timp;
        this.sursa = sursa;
        this.idS = idS;
        this.dest = dest;
        this.idD = idD;
        this.suma = suma;
        this.detali = detali;
    }

    public void intsert(Transfer rap){
        TransGateway gate = new TransGateway();
        gate.insert(rap);
    }
    public ArrayList<String> find(String oper,String begin, String end){
        TransGateway gate = new TransGateway();
        ArrayList<String> rez = gate.find(oper,begin,end);
        return rez;
    }
    public String getSursa(){
        return sursa;
    }
    public String getDest(){
        return dest;
    }
    public double getSuma(){
        return suma;
    }
    public String getDetali(){
        return detali;
    }
    public String getIdD(){
        return idD;
    }
    public String getIdS(){
        return idS;
    }
    public Timestamp getTimp() { return timp;}
    public String toString(){
        return "Din:"+sursa+" in:"+dest+" suma de:"+String.valueOf(suma)+" detali :"+detali+".";
    }
}
