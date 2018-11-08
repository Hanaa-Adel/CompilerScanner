
package sacnner;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.C;
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
        
       // Scanner input = new Scanner (System.in);
        TinyScanner tinyScanner = new TinyScanner(); 
        Token totalToken=new Token(); // to declare ';' so that the line is finished
        //String in= input.nextLine();
        String inputText;
      inputText = readFile(new File ("‪src\\\\input.txt"));
       // System.out.println(in);
      //ArrayList<String> tokensList = new ArrayList();
      ArrayList<Token>tokensList=new ArrayList();  
           
       for(char x:inputText.toCharArray()){
           //System.out.println(x);
        // String token=tinyScanner.takeCharacter(x);
       Token token=tinyScanner.takeCharacter(x); // declaration of token from scanner
         //System.out.println(token);
           if(token != null)
           {   token. printToken(token);            
               tokensList.add(token);
           }
//           if (x==';')
//           {
//             totalToken=new Token(";");
//             totalToken= totalToken.generateTokenType(";");
//             totalToken.printToken(totalToken);
//             tokensList.add(totalToken);
//           }
          
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
   private static String readFile(File fileName) throws IOException {
      String filename = "input.txt";
        BufferedReader br = new BufferedReader(new FileReader(new File (filename)));
          
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}
