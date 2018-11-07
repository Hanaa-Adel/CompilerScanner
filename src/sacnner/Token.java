
package sacnner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Hanaa
 */
public class Token {
   private String tokenValue;
   private  String tokenType;

    public Token() {}
    
    public Token(String tokenValue ,String tokenType) {
        this.tokenValue=tokenValue;
        this.tokenType=tokenType;
    }
    public Token(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public String getTokenType() {
        return tokenType;
    }
    

    
    
    
    public Token generateTokenType(String value ){
        
        if (value .equals("if")||value .equals("then")||value .equals("else")
                ||value .equals("end")||value .equals("repeat")||value .equals("until")
                ||value .equals("read")|value .equals("write"))
        {     
            tokenType="Reserved word";
        }
       else if (value .equals("+")|value .equals("-")|value .equals("*")
                |value .equals("/")|value .equals("=")|value .equals("<")
                |value.equals("(")|value.equals(")")|value .equals(";")|value.equals(":="))
                
        {
             tokenType="Special symbol";
        }
       else if(isNumeric(value))
        {
            tokenType="Number";
            
        }
        
       else tokenType="Identifier";
          
        Token totalToken=new Token(tokenValue,tokenType);
        return totalToken;
    }

    public static boolean isNumeric(String strNum) {
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException | NullPointerException nfe) {
        return false;
    }
    return true;
}
    public void printToken(Token t){
        
        System.out.println(t.tokenValue + " is a " +"'" + t.tokenType +"'");
         
    }
}
