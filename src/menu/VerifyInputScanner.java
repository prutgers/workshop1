/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Peter
 */
public class VerifyInputScanner {
    
    
/**
 * De verifyString methode is echt heel moeilijk want eignelijk is alles een string misschien moeten we hier anders op testen 
 * door bijvoorbeeld te stellen dat er geen cijfers inmogen? 
 * @return 
 */    
    public static String verifyString(){
        while(true){
            Scanner input = new Scanner(System.in);
            try{
                String verified = input.nextLine();
                return verified;
            }
            catch(InputMismatchException e){
                System.out.println("geen juiste lijn");

            }
        }
    }
    
    public static int verifyInt(){
        while(true){
            Scanner input = new Scanner(System.in);
            try{
                int verified = input.nextInt();
                return verified;
            }
            catch(InputMismatchException e){
                System.out.println("geen juist nummer, probeer nogmaals");

            }
        }
    }
    
    
    // het is onduidelijk of een double een , of een . is 
    // ik moet hem namelijk invoeren met een , maar hij geeft een . terug :D
    public static double verifyDouble(){
        while(true){
            Scanner input = new Scanner(System.in);
            try{
                Double verified = input.nextDouble();
                return verified;
            }
            catch(InputMismatchException e){
                System.out.println("geen juist nummer, probeer nogmaals");

            }
        }
    }
    
    
    //incompleet moet nog geschreven worden
    
    public static String verifyEmail(){
        String email = "aap@noot.mies";
        return email;
    }
    
    
    
    
    
    
    
}
