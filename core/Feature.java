package core;

import java.util.InputMismatchException;
import java.util.Scanner;

import exception.*;
import user.User;
public class Feature {
    Scanner input = new Scanner(System.in);
    String[] adminList = {
        "Create User Account",
        "Create Course",
        "Create Course Instance",
        "Assign Teacher"
    };
    String[] studentList = {
        "View Course",
        "Update Information",
        "Detail Information",
    };
    String[] teacherList = {
        "View Course",
        "Update Information",
        "Detail Information"
    };

    public int admin(){
        for(int i=1;i<=adminList.length;i++){
            System.out.println(i+". "+adminList[i-1]);
        }
        System.out.println("0. Exit");
        
        int option = 0;
        while (true) {
            try{
                System.out.print("Choose Option : ");
                option = Form.inputInteger();
                NumberRangeExceptionHandling stuOption = new NumberRangeExceptionHandling(0,adminList.length,option);
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            input.nextLine();
        }
        return option;
    }
    public int teacher(){
        for(int i=1;i<=teacherList.length;i++){
            System.out.println(i+". "+teacherList[i-1]);
        }
        System.out.println("0. Exit");
        int option = 0;
        while (true) {
            try{
                System.out.print("Choose Option : ");
                option = Form.inputInteger();
                NumberRangeExceptionHandling stuOption = new NumberRangeExceptionHandling(0,teacherList.length,option);
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            input.nextLine();
        }
        return option;
    }
    public int student(){
        for(int i=1;i<=studentList.length;i++){
            System.out.println(i+". "+studentList[i-1]);
        }
        System.out.println("0. Exit");
        int option = 0 ;
        while (true) {
            try{
                System.out.print("Choose Option : ");
                option = Form.inputInteger();
                NumberRangeExceptionHandling stuOption = new NumberRangeExceptionHandling(0,studentList.length,option);
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            input.nextLine();
        }
        return option;
    }
    public void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
