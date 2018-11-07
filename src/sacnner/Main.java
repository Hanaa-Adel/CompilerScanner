
package sacnner;

import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hanaa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Scanner input = new Scanner (System.in);
        TinyScanner tinyScanner = new TinyScanner();
        Token totalToken=new Token();
        String in= input.nextLine();
       // System.out.println(in);
      //ArrayList<String> tokensList = new ArrayList();
      ArrayList<Token>tokensList=new ArrayList();  
           
       for(char x:in.toCharArray()){
           //System.out.println(x);
        // String token=tinyScanner.takeCharacter(x);
       Token token=tinyScanner.takeCharacter(x);
         //System.out.println(token);
           if(token != null)
           {   token. printToken(token);            
               tokensList.add(token);
           }
           if (x==';')
           {
             totalToken=new Token(";");
             totalToken= totalToken.generateTokenType(";");
             totalToken.printToken(totalToken);
             tokensList.add(totalToken);
           }
          
//           if (x==';'|x=='*'|x=='+'|x=='<'|x=='-'|x=='/') {token=Character.toString(x);tokensList.add(token);
//           if(x=='='&& token!="="){token=Character.toString(x);tokensList.add(token);}
//               System.out.println(token);}
       }
       //String outputFilePath="Desktop";
        //FileWriter outFile=null;
       PrintWriter out=null;
        FileOutputStream outFile = null;
       try{
           outFile = new FileOutputStream("output.txt");
           //outFile = new FileWriter(outputFilePath);
           out =new PrintWriter(outFile);
           for(Token lexicalToken:tokensList){
               out.println(lexicalToken.getTokenValue()+" is "+lexicalToken.getTokenType());
               //FileWriter outFile=null; for gui
           }
       } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           
           out.close();
          outFile.close();
           
       }
     
    }
   
}
