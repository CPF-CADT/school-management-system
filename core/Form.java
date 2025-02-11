package core;

import java.util.Scanner;

import user.Admin;
// import user.Student;
import user.Teacher;

public class Form implements Authentication{
    Scanner input = new Scanner(System.in);

    @Override
    public Object login() {
        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.print("Email address : ");
        String email = input.next();
        System.out.print("Password      : ");
        String passsword = input.next();
        if (isValidEmailFormat(email)) {
            switch (typeOfEmail(email)) {
                case 1:
                    Admin adm = new Admin(email, passsword);
                    adm = Admin.login(adm);
                    if (adm != null) {
                        return adm;
                    }
                    break;
                case 2:
                    Teacher teach = new Teacher(email, passsword);
                    teach = Teacher.login(teach);
                    if (teach != null) {
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
        return null;
    }

    @Override
    public boolean register(int type) {
        String lastName, firstName, address, email, phoneNumber, password, role_major;
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Name   : ");
        firstName = scanner.next();
        System.out.print("Last Name    : ");
        lastName = scanner.next();
        System.out.print("Address      : ");
        address = scanner.next();
        System.out.print("Phone Number : ");
        phoneNumber = scanner.next();
        password = scanner.next();
        switch (type) {
            case 1:
                // admin
                System.out.print("Role  : ");
                role_major = input.next();
                Admin adm = new Admin(firstName, lastName, address, phoneNumber, role_major);
                if(adm!=null) return true;
                break;
            case 2:
                // teacher
                System.out.print("Major : ");
                role_major = input.next();
                Teacher teach = new Teacher(lastName, firstName, address, phoneNumber, role_major);
                if(teach!=null) return true;
                break;
            case 3:
                // student
                break;
        }
        return false;
    }

    private int typeOfEmail(String input) {
        if (input.contains("@adm"))
            return 1;
        if (input.contains("@tch"))
            return 2;
        if (input.contains("@stu"))
            return 3;
        return -1;
    }

    private boolean isValidEmailFormat(String input) {
        return input.endsWith("@adm.kdc.edu") ||
                input.endsWith("@tch.kdc.edu") ||
                input.endsWith("@stu.kdc.edu");
    }

    private boolean isValidPhoneFormat(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) > '9' || input.charAt(i) < '0') {
                return false;
            }
        }
        return true;
    }
}
