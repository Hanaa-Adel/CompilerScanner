
package sacnner;

/**
 *
 * @author Hanaa
 */
public class TinyScanner {
    private String currentInput;
    State state ;
    Token token=new Token();
    String temporary ;
    public TinyScanner() {
       currentInput="";
       state =State.START;
       
    }
    
    public String takeCharacter(char x){
        if (x==' '&& state!=State.START)   
            state =State.DONE;
        temporary="";
        switch(state){
                case START:
                    if (x==' ')      {state=State.START; temporary=""; break;}
                    else if (x=='{') {currentInput+=x; state=State.INCOMMENT;break;}
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
                {if (x=='}')      {currentInput+=x; state=State.START;break;}
                    else             {currentInput+=x; state=State.INCOMMENT;break;}}
                    
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
       // currentInput+=x;
      //  System.out.println(currentInput);
    }
//        if(temporary==" ") return null;
//        
//        else 
//        return  temporary;
    if(state==State.DONE)
                  //  String temporary =new String (currentInput);
                     
    {          
                 temporary=currentInput;
                    state=State.START;
                    currentInput="";
                    
//                    if (x==';'){
//                        currentInput+=x;
//                        takeCharacter(x);
//                        x=' ';
//                    }
    }
        if (temporary!="") return temporary;
        else return null;
    }
    
    private enum State {START,INNUM,INID,INASSIGN,INCOMMENT,DONE}

}

    
    
    
    

