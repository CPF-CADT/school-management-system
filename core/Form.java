package core;

import java.util.Scanner;

import user.Admin;
import user.Student;
import user.Teacher;

public class Form {
    Scanner input = new Scanner(System.in);
    public Object login(Student students,Teacher teachers){
        System.out.print("Email address : ");
        String email = input.next();
        System.out.print("Password      : ");
        String passsword = input.next();
        if (isValidEmailFormat(email)) {
            System.out.println(email + " is a valid email address.");
            System.out.println("Type Of Email ");
            switch (typeOfEmail(email)) {
                case 1:
                    Admin adm = new Admin(email, passsword);
                    adm = Admin.FindAdmins(adm);
                    if(adm!=null){
                        return adm;
                    }
                break;
                case 2:
                    Teacher teach = new Teacher(email, passsword);
                    teach = Teacher.FindTeacher(teach);
                        if(teach!=null){
                            return teach;
                        }
                    break;
                case 3:
                    System.out.println("This Student Account");
                    break;
                default:
                    break;
            }
        } 
        input.close();
        return null;
    }
    public void register(Object newUser,Student students,Admin admins,Teacher teachers){
        String lastName, firstName, address, email, phoneNumber, password, major;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        lastName = scanner.nextLine();
        System.out.print("Enter Address: ");
        address = scanner.nextLine();
        System.out.print("Enter Email: ");
        email = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        phoneNumber = scanner.nextLine();
        System.out.print("Enter Password: ");
        password = scanner.nextLine();
        System.out.print("Enter Major: ");
        major = scanner.nextLine();
    }
    public int typeOfEmail(String input) {
        if (input.contains("@adm"))
            return 1;
        if (input.contains("@tch"))
            return 2;
        if (input.contains("@stu"))
            return 3;
        return -1;
    }

    public boolean isValidEmailFormat(String input) {
        return input.endsWith("@adm.kdc.edu") ||
                input.endsWith("@tch.kdc.edu") ||
                input.endsWith("@stu.kdc.edu");
    }

    public boolean isValidPhoneFormat(String input) {
        for(int i=0;i<input.length();i++){
                if(input.charAt(i) > '9' || input.charAt(i)<'0'){
                    return false;
                }
        }
        return true;
    }
}
