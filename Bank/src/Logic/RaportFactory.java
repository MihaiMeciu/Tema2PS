package Logic;

/**
 * Created by Devene on 4/14/2016.
 */
public class RaportFactory {

    public Raport getRaport(String ext,String nume, String begin, String end){
        if(ext.equals("XML")){
            return new XMLRaport(nume, begin, end);
        } else if (ext.equals("JSON")){
            return new JSONRaport(nume, begin, end);
        }
        return null;
    }
}
