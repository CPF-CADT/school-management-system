package core;

import java.util.Scanner;

public class Feature {
    Scanner input = new Scanner(System.in);
    String[] adminList = {
        "Create Teacher Account",
        "Create Student Account",
        "Create Staff Account",
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
        System.out.print("Choose Option : ");
        return input.nextInt();
    }
    public int teacher(){
        for(int i=1;i<=teacherList.length;i++){
            System.out.println(i+". "+teacherList[i-1]);
        }
        System.out.println("0. Exit");
        System.out.print("Choose Option : ");
        return input.nextInt();
    }
    public int student(){
        for(int i=1;i<=studentList.length;i++){
            System.out.println(i+". "+studentList[i-1]);
        }
        System.out.println("0. Exit");
        System.out.print("Choose Option : ");
        return input.nextInt();
    }
    public void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
