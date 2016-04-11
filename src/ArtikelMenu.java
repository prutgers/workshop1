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
public class ArtikelMenu {
    
    
    ArtikelMenu(){
    

    System.out.println("Create a new Artikel!");
    System.out.println("Maak een keuze:");
    System.out.println("Kies 1 voor aanmaken nieuw artikel, kies 2 voor deleten artikel");
    Scanner input = new Scanner(System.in);
    int keuze = input.nextInt();
    CommandLineReader cmd = new CommandLineReader();
    if(1 == keuze){
        cmd.readCommandLine("artikel");
        }
    }
    
    
    public void updateArtikel(){
        System.out.println("Wat is het artikel ID dat u wilt updaten");
        Scanner input = new Scanner(System.in);        
        int artikel_id = input.next();       
        Artikel artikel = new ArtikelDAO.readArtikel(artikel);
        
        hoeveel liter
        hoeveel kilo
        hoe lang
        
        3         
                

        
        artikel.setArtikel_id(25);
        artikel.setArtikel_naam("koe");
        artikel.getArtikel_voorraad(4);
        
        
    }
}
