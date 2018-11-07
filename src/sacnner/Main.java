/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sacnner;

import java.io.File;
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
        Token totalToken=new Token();
        String in= input.nextLine();
       // System.out.println(in);
      ArrayList<String> tokensList = new ArrayList();
        
           
       for(char x:in.toCharArray()){
           //System.out.println(x);
        // String token=tinyScanner.takeCharacter(x);
       Token token=tinyScanner.takeCharacter(x);
         //System.out.println(token);
           if(token != null)
           {
//               try{
//               PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
//               writer.println();
//               
//               writer.println();
//               writer.close();}
//               catch(IOException e1) {
//                    System.out.println("Error during reading/writing");}
               //tokensList.add(token);
              // System.out.println(token);
//               try
//                {
//                    PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
//                    System.setOut(out);
//
//                }
//                catch(IOException e1) {
//                     System.out.println("Error during reading/writing");
//                }
             token. printToken(token);
             
           }
           if (x==';')
           {
             totalToken=new Token(";");
             totalToken= totalToken.generateTokenType(";");
             totalToken.printToken(totalToken);
           }
          
//           if (x==';'|x=='*'|x=='+'|x=='<'|x=='-'|x=='/') {token=Character.toString(x);tokensList.add(token);
//           if(x=='='&& token!="="){token=Character.toString(x);tokensList.add(token);}
//               System.out.println(token);}
       }
     
    }
   
}
