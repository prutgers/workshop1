package Menu;

import formatMessage.VerifyInputScanner;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import formatMessage.PrintFormat;
import java.util.ArrayList;
import java.util.Scanner;
import POJO.Adres;
import DAO.MySQL.AdresDAO;
import POJO.Klant;
import DAO.MySQL.KlantDAO;
import POJO.KlantAdres;
import DAO.MySQL.KlantAdresDAO;

/**
 *
 * @author Sonja
 */
public class KlantAdresMenu {
    public static void startMenu() {
        Scanner input = new Scanner(System.in);
        while(true){
            PrintFormat.printHeader("KLANT-ADRESMENU");          
            System.out.println("1: Voer een nieuwe klant in \n"
                    + "\n"
                + "2: Pas de gegevens van een bestaande klant aan (met klant ID) \n"
                + "3: Voer een nieuw adres voor een bestaande klant in (met klant ID) \n"
                + "4: Koppel een adres aan een bestaande klant \n"
                    + "\n"
                + "5: Haal alle klanten op \n"
                + "6: Haal een specifieke klant op (met klant ID) \n"
                + "7: Verwijder een klant, zijn/haar adresgegevens, en gekoppelde bestellingen "
                    + "(met klant ID)\n"
                    + "\n"
                + "0: Keer terug naar het Hoofdmenu");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    createNieuweKlantMenu();
                    break;
                case 2:
                    UpdateKlantMenu();
                    break;
                case 3:
                    createNieuwAdresVoorKlant();
                    break;
                case 4:
                    createKoppelKlantAdresMenu();
                    break;
                case 5:
                    readAllKlantenMenu();
                    break;
                case 6:
                    readKlantByIDMenu();
                    break;
                case 7:
                    deleteKlantByIdMenu();
                    break;
                case 0:
                    HoofdMenu.startMenu();
                    break;
                default:
                    System.out.println("Maak een keuze: 1, 2, 3, 4, 5, 6, 7 of 0");
                    break;
            }
        }
    }
    
    /*
    1. createNieuweKlantMenu maakt een nieuwe klant aan en verstuurt deze naar de DB
    */
    public static void createNieuweKlantMenu(){
        Scanner input = new Scanner(System.in);
        Klant klant = new Klant();   
        
        System.out.println("Maak een nieuwe klant aan."); //nieuwe klant info wordt ingevoerd
        System.out.print("Voornaam: ");
        klant.setVoornaam( input.next());
        System.out.print("Achternaam: ");
        klant.setAchternaam( input.next());
        System.out.print("Tussenvoegsel: ");
        klant.setTussenvoegsel( input.next());
        System.out.print("Emailadres: ");
        klant.setEmail( input.next());
        
        try {
            //Verstuur de klant naar de database
            Klant nieuweKlant = KlantDAO.createKlant(klant);
            //maak een klantadreskoppel
            //deze functioneert nog niet helemaal, maakt geen klantadreskoppel
            createKoppelKlantAdresMenu(nieuweKlant.getKlant_id());
      
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex){
            System.out.println(ex + "\nDeze klant staat al in het register." );
        }  
        catch(Exception ex){
            ex.printStackTrace();         
        }
    }
    
    /*
    2. UpdateKlantMenu past een bestaande klant aan
    
       >> Functioneert
    */
    public static void UpdateKlantMenu(){
        Scanner input = new Scanner(System.in);
        
        //selecteer een Klant
        System.out.println("Pas een klant aan. \n"
                + "Voer het Klant ID in: ");
        Klant outputKlant = KlantDAO.readKlant(VerifyInputScanner.verifyInt());
        
        //verkrijg de nieuwe data uit de commandline en zet in de outputKlant
        System.out.println("Voer de nieuwe gegevens in "
                + " (laat het veld leeg als er geen verandering nodig is): ");
        System.out.print("Voornaam: ");
        String nieuweVoornaam = input.nextLine();
        if ( !nieuweVoornaam.equals("") ) {
            outputKlant.setVoornaam( nieuweVoornaam );
                }
        System.out.print("Achternaam: ");
        String nieuweAchternaam = input.nextLine();
        if ( !nieuweAchternaam.equals("") ) {
            outputKlant.setAchternaam( nieuweAchternaam );
                }
        System.out.print("Tussenvoegsel: ");
        String nieuweTussenvoegsel = input.nextLine();
        if ( !nieuweTussenvoegsel.equals("") ) {
            outputKlant.setTussenvoegsel( nieuweTussenvoegsel );
                }
        System.out.print("Emailadres: ");
        String nieuwEmail = input.nextLine();
        if ( !nieuwEmail.equals("") ) {
            outputKlant.setEmail( nieuwEmail );
                }
        //Nieuwe versie van klant wordt nu verstuurd naar DB
        KlantDAO.updateKlant(outputKlant);
    }
    
    /*
    3. createNieuwAdresVoorKlant maakt een adres voor een bestaande klant aan
       op basis van het klant ID
    */
    private static void createNieuwAdresVoorKlant() {
        Scanner input = new Scanner(System.in);
        KlantAdres klantAdres = new KlantAdres();
        Adres inputAdres = new Adres();
        
        //invoeren van klant_id van de klant voor wie een adres toegevoegd moet worden
        System.out.println("Voer het klant ID van de klant voor wie een adres " +
                "toegevoegd moet worden in: ");
        klantAdres.setKlant_id(input.nextInt());
        
        //nieuw adres aanmaken
        System.out.print("Voer het adres in."
                + "\n\n"
                + "Straatnaam: ");
        inputAdres.setStraatnaam(input.next());
        System.out.print("Huisnummer: ");
        inputAdres.setHuisnummer(input.nextInt());
        System.out.print("Toevoeging: ");
        inputAdres.setToevoeging(input.next());
        System.out.print("Postcode: ");
        inputAdres.setPostcode(input.next());
        System.out.print("Woonplaats: ");
        inputAdres.setWoonplaats(input.next());
        System.out.print("Adres ID: ");
        klantAdres.setAdres_id(input.nextInt());
        
        AdresDAO aDAO = new AdresDAO(); 
        AdresDAO.createAdres(inputAdres);
        
        //adres koppelen aan een al bestaand klant_id
        try{ 
            KlantAdresDAO.createKlantAdresKoppel(klantAdres);
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex){
            System.out.println("Dit klant_idadres_idKoppel bestaat al; Geen actie ondernomen.");         
        }
            
    }
    
    
    /*
    4. createKoppelKlantAdresMenu koppelt een klant aan een adres op basis van
       adres ID en klant ID
    */
    private static void createKoppelKlantAdresMenu() {
        Scanner input = new Scanner(System.in);
        KlantAdres klantAdresKoppel = new KlantAdres();
        
        System.out.print("Voer het klant ID in: ");
        klantAdresKoppel.setKlant_id(input.nextInt());
        System.out.print("Voer het adres ID in: ");
        klantAdresKoppel.setAdres_id(input.nextInt());
        try{
            KlantAdresDAO.createKlantAdresKoppel(klantAdresKoppel);
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex){
            System.out.println("Dit klant-adreskoppel bestaat al.\n "
                    + "Er is geen actie ondernomen.");         
        }
    }
    
    /*
    5. readAllKlantenMenu geeft een ArrayList van alle bestaande klanten
    */
    public static void readAllKlantenMenu() {
        ArrayList<Klant> list = KlantDAO.readAllKlantByKlant(new Klant());
        System.out.println("KLANTGEGEVENS \n"
            + "---------------------");
        System.out.printf("%15s %15s %15s %15s %15s \n",
                "Klant ID", "Voornaam", "Achternaam", "Tussenvoegsel", "Email");
        for(Klant e : list){
            System.out.printf("%15d %15s %15s %15s %15s \n", 
                    e.getKlant_id(), e.getVoornaam(), e.getAchternaam(), 
                    e.getTussenvoegsel(), e.getEmail());
        
        }
    }
    
    /*
    6. readKlantByIDMenu geeft de gegevens van een specifieke klant 
       op basis van het klant ID
    */
    public static void readKlantByIDMenu() {
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        /*System.out.println("Voer het klant ID in: ");
        Klant e = KlantDAO.readKlant(input.nextInt());
        System.out.println("KLANTGEGEVENS\n "
                + "---------------------");
        System.out.printf("%15s %15s %15s %15s %15s %15s", 
                "Klant ID", "Voornaam", "Achternaam", "Tussenvoegsel", "Email");
        System.out.printf("%15d %15s %15d %15s %15s %15s\n", 
                e.getKlant_id(), e.getVoornaam(), e.getAchternaam(), 
                e.getTussenvoegsel(), e.getEmail());
        */
        
     
            System.out.println("Voer het klant ID in: ");
            int klantId = input.nextInt();
            
            Klant klant = KlantDAO.readKlant(klantId);
            System.out.println("KLANTGEGEVENS \n"
            + "---------------------");
            System.out.printf("%15s %15s %15s %15s %15s \n",
                "Klant ID", "Voornaam", "Achternaam", "Tussenvoegsel", "Email");
        
            System.out.printf("%15d %15s %15s %15s %15s \n", 
                    klant.getKlant_id(), klant.getVoornaam(), klant.getAchternaam(), 
                    klant.getTussenvoegsel(), klant.getEmail());
            
            System.out.printf("%15s %15s %15s %15s %15s %15s \n", 
                "Adres ID", "Straatnaam", "Huisnummer", "Toevoeging",
                "Postcode", "Woonplaats");
            ArrayList<Adres> adresLijst = KlantAdresDAO.readAdresID(klantId);
            for (Adres a : adresLijst) {
            System.out.printf("%15d %15s %15s %15s %15s %15s\n",
                    a.getAdres_id(), a.getStraatnaam(), a.getHuisnummer(), 
                    a.getToevoeging(), a.getPostcode(), a.getWoonplaats());
        }
    }

    /*
    7. deleteKlantByIdMenu verwijdert een specifieke klant
    */
    public static void deleteKlantByIdMenu(){
        Scanner input = new Scanner(System.in);
        
        //verkrijg data uit de commandline
        System.out.println("Voer het klant ID van de te verwijderen klant in: ");
        int klantId = input.nextInt();

        try {
            KlantDAO.deleteKlant(klantId);
            System.out.println("De volgende klant is verwijderd: " + klantId);
        }
        catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex){
            System.out.println("De klant kan niet worden verwijderd.\n"
                    + "Het klant ID " + klantId + " is nog in gebruik in "
                    + "de klant-adres tabel of de bestellingentabel." );
        }
        catch(Exception ex){
            ex.printStackTrace();         
        }
    }
    
    /*
    Automatische koppeling van klant en adres, zoals in BestellingenMenu
    */
    public static void createKoppelKlantAdresMenu(int klantID) throws MySQLIntegrityConstraintViolationException {
        Scanner input = new Scanner(System.in);
        
        KlantAdres koppel = new KlantAdres();
        koppel.setKlant_id(klantID);

        System.out.println("Voer de straatnaam in:");
        String straatnaam = input.next();
        System.out.println("Voer het huisnummer in:");
        int huisnummer = input.nextInt();
        System.out.println("Voer de toevoeging in:");
        String toevoeging = input.next();
        System.out.println("Voer de postcode in:");
        String postcode = input.next();
        System.out.println("Voer de woonplaats in:");
        String woonplaats = input.next();
        
        Adres adres = new Adres();
        adres.setStraatnaam(straatnaam);
        adres.setHuisnummer(huisnummer);
        adres.setToevoeging(toevoeging);
        adres.setPostcode(postcode);
        adres.setWoonplaats(woonplaats);
        
        adres = AdresDAO.createAdres(adres);
        
        koppel.setAdres_id(adres.getAdres_id());
        
        KlantAdresDAO.createKlantAdresKoppel(koppel);
        
    }
}
