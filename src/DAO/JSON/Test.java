/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.JSON;

import POJO.Bestelling;

/**
 *
 * @author Gebruiker
 */
public class Test {
    public static void main(String[]args){
        //Bestelling b = new Bestelling();
        //b.setBestellingID(22);
        //b.setKlantID(888);
        //BestellingDAOJSON.createBestelling(b);
        
        //BestellingDAOJSON.updateBestelling(b);
        //BestellingDAOJSON.deleteBestelling(22);
        
        Bestelling b = BestellingDAOJSON.getBestellingById(25);
        System.out.println(b.getBestellingID() + " " + b.getKlantID());
        
    }
}
