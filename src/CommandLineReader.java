/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import java.util.Scanner;

/**
 *
 * @author Peter
 */



public class CommandLineReader {
    
    
    public void readCommandLine(String classtoread){
        Scanner input = new Scanner(System.in);
        
        if("artikel".equals(classtoread)){
        Artikel artikel = new Artikel();
        System.out.println("Create a new Artikel!");
        System.out.print("Artikel naam :");
       // artikel.setArtikelNaam(input.next());
        System.out.print("Hoeveel artikelen zijn er op voorraad :");
     //   artikel.setAantalOpVoorraad(input.nextInt()); //is het niet gevaarglijk omdat die nu met input.next() niet weer de int value pakt?
        
        
        //ArtikelDAO artikelDAO = new ArtikelDAO;
        //artikelDAO.createNewArtikel(artikel);
        
        }
        
        if("bestelling".equals(classtoread)){
        //    Bestelling bestelling = New Bestelling();
        }
        
 
    }
    
    
}
