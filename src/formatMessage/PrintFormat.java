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
    public static void printHeader2(String header){
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
    public static void printHeader(String header){
        int width = header.length() + 10;
        
        for(int i = 0;i<width;i++){
            System.out.print("-");
        }
        
        System.out.print("\n|    ");
        System.out.print(header);
        System.out.print("    |\n");
        
        for(int i = 0;i<width;i++){
            System.out.print("-");
        }
        System.out.println("");
    }
    
    public static void PrintClown(){
        System.out.println( "       ,            _..._            ,\n" +
                            "      {'.         .'     '.         .'}\n" +
                            "     { ~ '.      _|=    __|_      .'  ~}\n" +
                            "    { ~  ~ '-._ (___________) _.-'~  ~  }\n" +
                            "   {~  ~  ~   ~.'           '. ~    ~    }\n" +
                            "  {  ~   ~  ~ /   /\\     /\\   \\   ~    ~  }\n" +
                            "  {   ~   ~  /    __     __    \\ ~   ~    }\n" +
                            "   {   ~  /\\/  -<( o)   ( o)>-  \\/\\ ~   ~}\n" +
                            "    { ~   ;(      \\/ .-. \\/      );   ~ }\n" +
                            "     { ~ ~\\_  ()  ^ (   ) ^  ()  _/ ~  }\n" +
                            "      '-._~ \\   (`-._'-'_.-')   / ~_.-'\n" +
                            "          '--\\   `'._'\"'_.'`   /--'\n" +
                            "              \\     \\`-'/     /\n" +
                            "               `\\    '-'    /'\n" +
                            "                 `\\       /'\n" +
                            "                   '-...-'");
    }
    
}
