/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.XML;

import POJO.Artikel;
import java.io.File;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.*;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Peter
 */
public class testDAOXML {
    
    public static void main (String argv []){
        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File("C:\\data\\xml\\test.xml"));

            // normalize text representation
            doc.getDocumentElement ().normalize ();
            System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());


            NodeList listOfArtikelen = doc.getElementsByTagName("artikel");
            int totalArtikelen = listOfArtikelen.getLength();
            System.out.println("tel de artieklen " + totalArtikelen);
            ArrayList<Artikel> artikelLijst = new ArrayList();


            for(int s=0; s<listOfArtikelen.getLength() ; s++){
                Node firstArtikelNode = listOfArtikelen.item(s);
                if(firstArtikelNode.getNodeType() == Node.ELEMENT_NODE){
                    Artikel artikel = new Artikel();
                    Element firstArtikelElement = (Element)firstArtikelNode; 

                    //-------
                    NodeList artikelNameList = firstArtikelElement.getElementsByTagName("artikel_naam");
                    Element artikelNaamElement = (Element)artikelNameList.item(0);

                    NodeList artikelIDList = firstArtikelElement.getElementsByTagName("artikel_id");
                    Element artikelIDElement = (Element)artikelIDList.item(0);

                    NodeList textFNList = artikelNaamElement.getChildNodes();
                   // System.out.println("Artikel Naam : " + ((Node)textFNList.item(0)).getNodeValue().trim());

                    artikel.setArtikel_naam(  ((Node)textFNList.item(0)).getNodeValue().trim().toString()   );

                   // System.out.println("artikel naam afasdf safsaf " + artikel.getArtikel_naam());

                    System.out.println("Artikel Naam " + artikel.getArtikel_naam());

                    textFNList = artikelIDElement.getChildNodes();
                    
                    
                    artikel.setArtikel_id(  Integer.parseInt( ((Node)textFNList.item(0)).getNodeValue().trim().toString())   );

                    System.out.println("artikel ID " + artikel.getArtikel_id());




                    //------
                }
            }
        }catch (SAXParseException err) {
            System.out.println ("** Parsing error" + ", line " + err.getLineNumber () + ", uri " + err.getSystemId ());
            System.out.println(" " + err.getMessage ());
        }catch (SAXException e) {
            Exception x = e.getException ();
            ((x == null) ? e : x).printStackTrace ();
        }catch (Throwable t) {
            t.printStackTrace ();
        }
        //System.exit (0);

    }
}

