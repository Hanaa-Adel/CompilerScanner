/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sacnner;

/**
 *
 * @author Hanaa
 */
public class Token {
   private String tokenValue;
     String tokenType;

    public Token() {}
    
    public Token(String tokenValue ,String tokenType) {
        this.tokenValue=tokenValue;
        this.tokenType=tokenType;
    }
    
    public Token generateTokenType(String value ){
        
        if (tokenValue =="if"|tokenValue =="then"|tokenValue =="else"
                |tokenValue =="end"|tokenValue =="repeat"|tokenValue =="until"
                |tokenValue =="read"|tokenValue =="write")
                
        {
            tokenType="Reserved word";
        }
        if (tokenValue =="+"|tokenValue =="-"|tokenValue =="*"
                |tokenValue =="/"|tokenValue =="="|tokenValue =="<"
                |tokenValue =="("|tokenValue ==")"|tokenValue ==";"|tokenValue ==";=")
                
        {
             tokenType="Special symbol";
        }
        if(isNumeric(tokenValue))
        {
            tokenType="Number";
            
        }
        Token totalToken=new Token(tokenValue,tokenType);
        return totalToken;
    }
//    if(tokenValue==Identifier)
//    {
//        
//    }
    public static boolean isNumeric(String strNum) {
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException | NullPointerException nfe) {
        return false;
    }
    return true;
}
    public void printToken(Token t){
        
        System.out.println(t.tokenValue + " is " + t.tokenType);
        //System.out.println(t.tokenType);
         
    }
}
