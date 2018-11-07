
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
    int semiCount=0;
    String semi;
    public TinyScanner() {
       currentInput="";
       state =State.START;
       
    }
    
    public Token takeCharacter(char x){
        
        if (x==' '&& state!=State.START && state!=State.INCOMMENT)   
            state =State.DONE;
        if (x==';'){semiCount=1; semi=";"; state=State.DONE;}
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
                    if(Character.isAlphabetic(x) || Character.isDigit(x))     {currentInput+=x;
                        state=State.INID;break;}
                      
                    else                              state=State.DONE;break;}
                   
                
                case INASSIGN:
                {  if (x=='=')      { state=State.DONE;break;}
                    else             { state=State.DONE;break;}} 
                    
                    
                case INCOMMENT:
                {if (x=='}')      { state=State.START;break;}
                    else             { state=State.INCOMMENT;break;}}

                default: break;
    }

if (state !=State.INCOMMENT &&x=='*'|x=='+'|x=='<'|x=='-'|x=='/'){
        
        currentInput+=x;
        state=State.DONE;
      
    }
if (x=='='& currentInput!=":="){
        currentInput+=x;
        state=State.DONE;
    }
    if(state==State.DONE)
    {          
        temporary=currentInput;
        state=State.START;
        currentInput="";
        tinyToken=new Token(temporary);
        tinyToken=tinyToken.generateTokenType(temporary);
                    
                       
    }
  
        if (temporary!="") return tinyToken;
        else return null;
       
    }
    
    private enum State {START,INNUM,INID,INASSIGN,INCOMMENT,DONE}

}

    
    
    
    

