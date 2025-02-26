package progress;

import java.util.Scanner;

import exception.TitleIdentifierForUser;

public class TestCode {
    public static void main(String[] args) throws IllegalArgumentException{
        Scanner input = new Scanner(System.in);
        try{
            String num =  input.nextLine();
            TitleIdentifierForUser t =  new TitleIdentifierForUser("Major cannot be contain spcial charactor");
            t.titleValidate(num);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
