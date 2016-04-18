/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formatMessage;

/**
 *
 * @author Herman
 */
public class PrintFormat {
    public static void printHeader(String header){
        int spaces = (36/2) - (header.length()/2);
        System.out.println("--------------------------------------");
        System.out.print("|");
        //print leading spaces
        for(int i = 0;i<spaces;i++){
            System.out.print(" ");
        }
        System.out.print(header);
        
        //print tracing spaces
        for(int i = 0;i<spaces;i++){
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println("\n--------------------------------------");
    }
    
}
