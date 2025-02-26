package exception;

public class OnlyAlphabetInString extends IllegalArgumentException{
    public OnlyAlphabetInString(){
        super("Input allowed Only Alphabet");
    }
    public OnlyAlphabetInString(String message){
        super(message);
    }
    public void isStringConatainNonAlphabet(String text){
        if(findNonAlphabet(text)){
            throw new OnlyAlphabetInString(super.getMessage());
        }
    }
    private boolean findNonAlphabet(String text){
        for(int i=0; i<text.length();i++){
            if(!Character.isAlphabetic(text.charAt(i))){
                return true;
            }
        }
        return false;
    }
}   
