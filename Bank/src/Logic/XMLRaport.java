package Logic;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Devene on 4/14/2016.
 */
public class XMLRaport implements Raport{

    private String[] nume;
    private String begin;
    private String end;

    public XMLRaport(String nume,String begin, String end){
        this.nume = nume.split(",");
        this.begin = begin;
        this.end = end;
    }

    public void generate(String cale){
        try{
            Transfer rap = new Transfer();
            ArrayList<String> rasp;
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element raport = doc.createElement("raport");
            doc.appendChild(raport);
            for (int i=0; i<nume.length;i++){
                rasp = rap.find(nume[i],begin,end);
                for(int j=0;j<rasp.size();j++){
                    String linie = rasp.get(j);
                    raport.appendChild(getTrans(doc,linie));

                }
            }
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer= transFactory.newTransformer();
            DOMSource sursa = new DOMSource(doc);
            StreamResult rez = new StreamResult(new File(cale));
            transformer.transform(sursa,rez);
        } catch (ParserConfigurationException pce) {

        } catch (TransformerException tfe) {

        }
    }
    private static Node getTrans(Document doc, String elem){
        Element trans = doc.createElement("transaction");
        String[] val = elem.split(",");
        trans.appendChild(getTransElem(doc,trans,"date",val[0]));
        trans.appendChild(getTransElem(doc,trans,"fromAccount",val[1]));
        trans.appendChild(getTransElem(doc,trans,"fromName",val[2]));
        trans.appendChild(getTransElem(doc,trans,"toAcount",val[3]));
        trans.appendChild(getTransElem(doc,trans,"toName",val[4]));
        trans.appendChild(getTransElem(doc,trans,"ammount",val[5]));
        trans.appendChild(getTransElem(doc,trans,"description",val[6]));
        return trans;
    }
    private static  Node getTransElem(Document doc,Element elem, String name, String val){
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(val));
        return node;
    }
}
