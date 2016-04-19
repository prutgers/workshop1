/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import workshop1.*;

/**
 *
 * @author lucas
 */
public class KlantMenu {
    public static void startMenu() {
        Scanner input = new Scanner(System.in);
        while(true){
                    
            System.out.println("Kies 1 voor createKlant; \n"
                + "kies 2 voor getKlantByKlant_id, \n"
                + "kies 3 voor getAllKlants, \n"
                + "kies 4 voor getAllKlantsByPartialKlant, \n"
                + "kies 5 voor deleteByKlant_id, \n"
                + "kies 6 voor updateKlant, \n"
                + "kies 0 ga naar hoofdmenu");
            int select = input.nextInt();
            try{
                switch (select) {
                    case 1:
                        createMenu();
                        startMenu();
                        break;
                    case 2:
                        getByKlant_idMenu();
                        break;
                    case 3:
                        getAllMenu();
                        break;
                    case 4:
                        getAllKlantsByPartialKlant();
                        break;
                    case 5:
                        deleteByIdMenu();
                        break;
                    case 6:
                        UpdateByIdMenu();
                        break;
                    case 0:
                        HoofdMenu.startMenu();
                        break;
                    default:
                        System.out.println("kies 1, 2, 3, 4, 5, 6 of 0");
                        break;
                }
            }
            catch(SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }
    
    public static void createMenu()throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        Klant inputKlant = new Klant();   
        
        //verkrijg data uit de commandline en zet in de inputklant
        System.out.println("Create a new Klant!");
        System.out.print("Your first name :");
        inputKlant.setVoornaam( input.next() );
        System.out.print("Your last name :");
        inputKlant.setAchternaam( input.next() );
        System.out.print("Additieves :");
        inputKlant.setTussenvoegsel( input.next() );
        System.out.print("Your email adress :");
        inputKlant.setEmail( input.next() );
        
        //Verstuur de bestelling naar de database
        try {
            KlantDAO.createKlant(inputKlant);
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex){
            System.out.println("\nUw staat al in ons register!\n" );
        }
        catch(Exception ex){
            ex.printStackTrace();         
        }
    }
    
    public static void getAllMenu(){
        ArrayList<Klant> list = KlantDAO.readAllKlantByKlant(new Klant());
        System.out.println("\nLIJST MET ALLE KLANTEN \n"
                + "====");
        System.out.printf("%12s| %31s| %32s| %13s| %31s|\n", "Klant_id", "Voornaam", "Achternaam", "Tussenvoegsel", "Email");
        for(Klant e : list){
            System.out.printf("%12s| %31s| %32s| %13s| %31s|\n", e.getKlant_id(), e.getVoornaam(), e.getAchternaam(), e.getTussenvoegsel(), e.getEmail());
        }
    }
    
    public static void getByKlant_idMenu()throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter klant_id :");
        Klant e = KlantDAO.readKlant( input.nextInt() );
        System.out.printf("%12s| %31s| %32s| %13s| %31s|\n", "Klant_id", "Voornaam", "Achternaam", "Tussenvoegsel", "Email");
        System.out.printf("%12s| %31s| %32s| %13s| %31s|\n", e.getKlant_id(), e.getVoornaam(), e.getAchternaam(), e.getTussenvoegsel(), e.getEmail());
        
    }
    
    
    
    public static void deleteByIdMenu(){
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter Klant ID :");
        int klantId = input.nextInt();

        try {
            KlantDAO.deleteKlant(klantId);
            System.out.println("Klant deleted: "+ klantId +".");
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex){
            System.out.println("Klant kan niet worden verwijdered;\n"
                    + " het klantId \""+ klantId +"\" is nog in gebruik in"
                    + " de KoppelKlantAdres tabel of de bestellings tabel." );
        }
        catch(Exception ex){
            ex.printStackTrace();         
        }
    }
    
    public static void getAllKlantsByPartialKlant(){
        Scanner input = new Scanner(System.in);
        Klant inputKlant = new Klant();   
        
        //verkrijg data uit de commandline en zet in de inputklant
        System.out.println("Wat weet je over de persoon die je zoekt?"
                + " If you don't know a certain field just leave it blank.");
        System.out.print("Voornaam :");
        inputKlant.setVoornaam( input.nextLine() );
        System.out.print("Achternaam :");
        inputKlant.setAchternaam( input.nextLine() );
        System.out.print("Toevoegingen :");
        inputKlant.setTussenvoegsel( input.nextLine() );
        System.out.print("Email adress :");
        inputKlant.setEmail( input.nextLine() );
        
        //incomplete inputKlant nu naar KlantDao voor lijst met alle mogelijke klanten
        ArrayList<Klant> list = KlantDAO.readAllKlantByKlant(inputKlant);
        System.out.println("LIJST MET ALLE KLANTEN \n"
                + "====");
        System.out.printf("%12s| %31s| %32s| %13s| %31s|\n", "Klant_id", "Voornaam", "Achternaam", "Tussenvoegsel", "Email");
        for(Klant e : list){
            System.out.printf("%12s| %31s| %32s| %13s| %31s|\n", e.getKlant_id(), e.getVoornaam(), e.getAchternaam(), e.getTussenvoegsel(), e.getEmail());
        }
    }
    
    public static void UpdateByIdMenu(){
        Scanner input = new Scanner(System.in);
        
        //select a Klant
        System.out.println("\nUpdate een Klant! \nWat is je Klant_id?");
        Klant outputKlant = KlantDAO.readKlant( Integer.parseInt(input.nextLine() ) );
        
        System.out.println("Welkom terug " + outputKlant.getVoornaam() );
        
        //verkrijg de nieuwe data uit de commandline en zet in de Outputklant
        System.out.println("Please fill in your new infromation:"
                + " (If you don't want to update a field just leave it blank.)");
        System.out.print("Je nieuwe Voornaam :");
        String nieuweVoornaam = input.nextLine();
        if ( !nieuweVoornaam.equals("") ) {
            outputKlant.setVoornaam( nieuweVoornaam );
                }
        System.out.print("Je nieuwe Achternaam:");
        String nieuweAchternaam = input.nextLine();
        if ( !nieuweAchternaam.equals("") ) {
            outputKlant.setAchternaam( nieuweAchternaam );
                }
        System.out.print("Je nieuwe Toevoegingen:");
        String nieuweTussenvoegsel = input.nextLine();
        if ( !nieuweTussenvoegsel.equals("") ) {
            outputKlant.setTussenvoegsel( nieuweTussenvoegsel );
                }
        System.out.print("Je nieuwe Email adres:");
        String nieuwEmail = input.nextLine();
        if ( !nieuwEmail.equals("") ) {
            outputKlant.setEmail( nieuwEmail );
                }
        
        //Nieuwe versie van klant word nu verstuurd naar DB
        KlantDAO.updateKlant(outputKlant);
    }
    
    /*public static void getByAdres_idMenu()throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter adres ID :");
        int adres_id = input.nextInt();

        ArrayList<Klant> list = KlantDAO.readAllKlantByAdres_id(adres_id);
        System.out.println("LIJST MET BEWONERS VAN " + adres_id + "\n"
                + "(aka " + AdresDAO.readAdresByID(adres_id) + ")\n"
                + "====");
        System.out.println("Klant_id  Voornaam  Achternaam   Tussenvoegsel  Email  Adres_id");
        for(Klant e : list){
            System.out.println( e.toString() );
        }
    }*/
}
