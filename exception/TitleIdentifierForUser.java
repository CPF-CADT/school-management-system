package exception;

public class TitleIdentifierForUser extends IllegalArgumentException{
    public TitleIdentifierForUser(String message){
        super(message);
    }
    public void titleValidate(String title) {
        if(!title.matches("^[a-zA-Z&\\- ]*$")){
            throw new TitleIdentifierForUser(super.getMessage());
        }
    }
}
