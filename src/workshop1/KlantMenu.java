/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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
                + "kies 3 voor getKlantByAdres_id, \n"
                + "kies 4 voor getAllKlants, \n"
                + "kies 5 voor getAllKlantsByPartialKlant, \n"
                + "kies 6 voor deleteByKlant_id, \n"
                + "kies 7 voor updateKlant, \n"
                + "kies 8 ga naar hoofdmenu");
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
                        getByAdres_idMenu();
                        break;
                    case 4:
                        getAllMenu();
                        break;
                    case 5:
                        getAllKlantsByPartialKlant();
                        break;
                    case 6:
                        deleteByIdMenu();
                        break;
                    case 7:
                        UpdateByIdMenu();
                        break;
                    case 8:
                        HoofdMenu.startMenu();
                        break;
                    default:
                        System.out.println("kies 1, 2, 3, 4, 5, 6, 7 of 8");
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
        KlantDAO.createKlant(inputKlant);
    }
    
    public static void getAllMenu(){
        ArrayList<Klant> list = KlantDAO.readAllKlantByKlant(new Klant());
        System.out.println("LIJST MET ALLE KLANTEN \n"
                + "====");
        System.out.println("Klant_id  Voornaam  Achternaam   Tussenvoegsel  Email  Adres_id");
        for(Klant e : list){
            System.out.println( e.toString() );
        }
    }
    
    public static void getByKlant_idMenu()throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter klant_id :");
        Klant klantOuput = KlantDAO.readKlant( input.nextInt() );
        System.out.println( klantOuput.toString() );
        
    }
    
    public static void getByAdres_idMenu()throws SQLException, ClassNotFoundException{
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter adres ID :");
        int adres_id = input.nextInt();

        ArrayList<Klant> list = KlantDAO.readAllKlantByAdres_id(adres_id);
        System.out.println("LIJST MET BEWONERS VAN " + adres_id + "\n"
                + "(aka " + AdresDAO.readAdres(adres_id) + ")"
                + "====");
        System.out.println("Klant_id  Voornaam  Achternaam   Tussenvoegsel  Email  Adres_id");
        for(Klant e : list){
            System.out.println( e.toString() );
        }
    }
    
    public static void deleteByIdMenu(){
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Enter Klant ID :");
        int klantId = input.nextInt();

        KlantDAO.deleteKlant(klantId);
        System.out.println("Klant deleted: klant_id.");
    }
    
    public static void getAllKlantsByPartialKlant(){
        Scanner input = new Scanner(System.in);
        Klant inputKlant = new Klant();   
        
        //verkrijg data uit de commandline en zet in de inputklant
        System.out.println("Create a new Klant!"
                + " If you don't know a certain field just leave it blank.");
        System.out.print("Your first name :");
        inputKlant.setVoornaam( input.nextLine() );
        System.out.print("Your last name :");
        inputKlant.setAchternaam( input.nextLine() );
        System.out.print("Additieves :");
        inputKlant.setTussenvoegsel( input.nextLine() );
        System.out.print("Your email adress :");
        inputKlant.setEmail( input.nextLine() );
        
        //incomplete inputKlant nu naar KlantDao voor lijst met alle mogelijke klanten
        ArrayList<Klant> list = KlantDAO.readAllKlantByKlant(inputKlant);
        System.out.println("LIJST MET ALLE KLANTEN \n"
                + "====");
        System.out.println("Klant_id  Voornaam  Achternaam   Tussenvoegsel  Email  Adres_id");
        for(Klant e : list){
            System.out.println( e.toString() );
        }
    }
    
    public static void UpdateByIdMenu(){
        Scanner input = new Scanner(System.in);
        
        //select a Klant
        System.out.println("Update a Klant! \nWhat is your Klant_id?");
        Klant outputKlant = KlantDAO.readKlant( input.nextInt() );
        
        System.out.println("Welcome back " + outputKlant.getVoornaam() );
        
        //verkrijg de nieuwe data uit de commandline en zet in de Outputklant
        System.out.println("Please fill in your new infromation:"
                + " (If you don't want to update a field just leave it blank.)");
        System.out.print("Your new first name :");
        String nieuweVoornaam = input.nextLine();
        if ( !nieuweVoornaam.equals("") ) {
            outputKlant.setVoornaam( nieuweVoornaam );
                }
        System.out.print("Your new last name :");
        String nieuweAchternaam = input.nextLine();
        if ( !nieuweAchternaam.equals("") ) {
            outputKlant.setVoornaam( nieuweAchternaam );
                }
        System.out.print("new Additieves :");
        String nieuweTussenvoegsel = input.nextLine();
        if ( !nieuweTussenvoegsel.equals("") ) {
            outputKlant.setVoornaam( nieuweTussenvoegsel );
                }
        System.out.print("Your new email adress :");
        String nieuwEmail = input.nextLine();
        if ( !nieuwEmail.equals("") ) {
            outputKlant.setVoornaam( nieuwEmail );
                }
        
        //Nieuwe versie van klant word nu verstuurd naar DB
        KlantDAO.updateKlant(outputKlant);
    }
}
