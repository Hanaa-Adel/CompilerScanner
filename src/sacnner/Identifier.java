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
public class Identifier {
    private String currentInput;
    State state ;
    String temporary ;

    public Identifier() {
        currentInput=" ";
        state=State.START;
    }

    public Identifier(String currentInput) {
        this.currentInput = currentInput;
    }
    
    public Identifier characterIden(char x){
        
        switch(state){
                case START:
                    if(Character.isAlphabetic(x))
                    {
                      currentInput+=x;
                      state=State.IN_ID;
                      break;
                    }
                    else break;
       
                case IN_ID:
                    if(Character.isAlphabetic(x)|Character.isDigit(x))
                    {
                      currentInput+=x;
                      state=State.IN_ID;
                      break;
                    }
                    else state=State.DONE;
    }
        if(state==State.DONE)
        {
            Identifier Id=new Identifier(currentInput);
            //temporary=currentInput;
            state=State.START;
            currentInput="";
            return Id;
        }
        
   return null;
    
    }
//public static boolean is_Identifier(String value)
//{
//    Identifier tokenId;
//    for(char x:value.toCharArray()){
//       tokenId=Identifier.characterIden(x);
//        
//    }
//    
//}
    
    private enum State {START,IN_ID,DONE}
}
