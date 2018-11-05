/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sacnner;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hanaa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner (System.in);
        TinyScanner tinyScanner = new TinyScanner();
        String in= input.nextLine();
       // System.out.println(in);
      ArrayList<String> tokensList = new ArrayList();
        
           
       for(char x:in.toCharArray()){
           //System.out.println(x);
         String token=tinyScanner.takeCharacter(x);
         //System.out.println(token);
           if(token != null)
           {
               tokensList.add(token);
               System.out.println(token);
           }
           if (x==';'|x=='*'|x=='+'|x=='<'|x=='-'|x=='/') {token=Character.toString(x);tokensList.add(token);
           if(x=='='&& token!="="){token=Character.toString(x);tokensList.add(token);}
               System.out.println(token);}
       }
     
    }
    
}
