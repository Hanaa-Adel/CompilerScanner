
package sacnner;

/**
 *
 * @author Hanaa
 */
public class TinyScanner {
    private String currentInput;
    State state ;
    Token tinyToken=new Token();
    String temporary ;
    
    public TinyScanner() {
       currentInput="";
       state =State.START;
       
    }
    
    public Token takeCharacter(char x){
        if (x==' '&& state!=State.START && state!=State.INCOMMENT)   
            state =State.DONE;
        temporary="";
        switch(state){
                case START:
                    if (x==' ')      {state=State.START; temporary=""; break;}
                    else if (x=='{') { state=State.INCOMMENT;break;}
                    
                    else if(x==':')  {currentInput+=x; state=State.INASSIGN;break;}
                    else if(Character.isAlphabetic(x))     {currentInput+=x; 
                        state=State.INID;break;}
                    else if(Character.isDigit(x))          {currentInput+=x; state=State.INNUM;break;} 
                    else                                   {state=State.DONE;break;}
                    
                 
                case INNUM:
                    if(Character.isDigit(x))     {currentInput+=x; state=State.INNUM;break;} 
                    else                         {state=State.DONE;break;}
                   
                            
                case INID :
                { 
                    if(Character.isAlphabetic(x))     {currentInput+=x;
                        state=State.INID;break;}
                      
                    else                              state=State.DONE;break;}
                   
                
                case INASSIGN:
                {  if (x=='=')      {currentInput+=x; state=State.DONE;break;}
                    else             { state=State.DONE;break;}} 
                    
                    
                case INCOMMENT:
                {if (x=='}')      { state=State.START;break;}
                    else             { state=State.INCOMMENT;break;}}
                    
//                case DONE:
//                  //  String temporary =new String (currentInput);
//                     
//                     
//                 temporary=currentInput;
//                    state=State.START;
//                    currentInput="";
//                    break;
                   // return  temporary;
                default: break;
    }
//        if(temporary==" ") return null;
//        
//        else 
//        return  temporary;
if (x==';'|x=='*'|x=='+'|x=='<'|x=='-'|x=='/' &&state !=State.INCOMMENT ){ currentInput+=x;}
    if(state==State.DONE)
    {          
                 temporary=currentInput;
                 
                    state=State.START;
                    currentInput="";
                    tinyToken=tinyToken.generateTokenType(temporary);
//                    if (x==';'){
//                        currentInput+=x;
//                        takeCharacter(x);
//                        x=' ';
//                    }
    }
        if (temporary!="") return tinyToken;
        else return null;
       
    }
    
    private enum State {START,INNUM,INID,INASSIGN,INCOMMENT,DONE}

}

    
    
    
    

