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
public class TinyScanner {
    private String currentInput;
    State state ;
    public TinyScanner() {
       currentInput="";
       state =State.START;
    }
    
    public String takeCharacter(char x){
        switch(state){
                case START:
                    if (x==' ')      state=State.START;
                    else if (x=='{') {currentInput+=x; state=State.INCOMMENT;}
                    else if(x==':')  {currentInput+=x; state=State.INASSIGN;}
                    else if(Character.isAlphabetic(x))     {currentInput+=x; state=State.INID;}
                    else if(Character.isDigit(x))    {currentInput+=x; state=State.INNUM;} 
                    else             {state=State.DONE;}
                    
                 
                case INNUM:
                    if(Character.isDigit(x))     {currentInput+=x; state=State.INNUM;} 
                    else                         state=State.DONE;
                   
                            
                case INID :
                    if(Character.isAlphabetic(x))     {currentInput+=x; state=State.INID;}
                    else                              state=State.DONE;
                   
                
                case INASSIGN:
                    if (x=='=')      state=State.DONE;
                    else             {currentInput+=x; state=State.DONE;} 
                    
                    
                case INCOMMENT:
                    if (x=='}')      {currentInput+=x; state=State.START;}
                    else             {currentInput+=x; state=State.INCOMMENT;}
                    
                case DONE:
                    String temporary =new String (currentInput);
                    state=State.START;
                    currentInput="";
                    return  temporary;
                    
                    
       // currentInput+=x;
      //  System.out.println(currentInput);
        
    }
        return null;
    }
    private enum State {START,INNUM,INID,INASSIGN,INCOMMENT,DONE}

}

    
    
    
    

