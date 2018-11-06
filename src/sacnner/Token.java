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
   private  String tokenType;

    public Token() {}
    
    public Token(String tokenValue ,String tokenType) {
        this.tokenValue=tokenValue;
        this.tokenType=tokenType;
    }

    public Token(String tokenValue) {
        this.tokenValue = tokenValue;
    }
    
    
    public Token generateTokenType(String value ){
        
//        if (value =="if"||value =="then"||value =="else"
//                ||value =="end"||value =="repeat"||value =="until"
//                ||value =="read"||value =="write")
          if (value=="read")
                
        {
            tokenType="Reserved word";
        }
       else if (value =="+"|value =="-"|value =="*"
                |value =="/"|value =="="|value =="<"
                |value =="("|value ==")"|value ==";"|value ==";=")
                
        {
             tokenType="Special symbol";
        }
       else if(isNumeric(value))
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
