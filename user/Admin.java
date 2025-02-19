package user;

import java.util.HashMap;

public class Admin extends User{
    final static String EMAIL_FORMAT = "@adm.kdc.edu";
    public String role;

    public Admin(String firstName, String lastName, String address , String phoneNumber, String role) {
        super(firstName,lastName, address, phoneNumber,EMAIL_FORMAT);
        this.role = role;
        User.listUser.put(super.getID(), this);
    }
    public Admin(String email,String password) {
        super(email,password);
    }
    @Override
    public String toString() {
        return super.toString() + "  Role : " + this.role;
    }
    public static Admin login(User t){
        for(User adm :User.listUser.values()){
            if(t.equals(adm)){
                return (Admin) adm;
            }
        }
        return null;
    }

    public void displayUserInfo(){
        super.displayUserInfo();
        System.out.println("Role        : " + role);
        System.out.println("====================================\n");
    }
//     public static Admin selectAdmin() {
//         if (Admin.listOfAdmins.isEmpty()) {
//             System.out.println("List Admin ");
//             for (Admin ad : listOfAdmins.values()) {
//                 System.out.println(ad);
//             }
//             System.out.print("Enter ID : ");
//             int select = input.nextInt();
//             return listOfAdmins.get(select);
//         } else {
//             System.out.println("No Admin in list");
//             return null;
//         }
    
// }
// public    void remove() {
//     if (Admin.listOfAdmins.isEmpty()) {
//         System.out.println("List Admin ");
//         for (Admin std : listOfAdmins.values()) {
//             System.out.println(std);
//         }
//         System.out.print("Enter ID : ");
//         int select = input.nextInt();
//          listOfAdmins.get(select).remove();
//         System.out.println("Remove successfully");
//     } else {
//         System.out.println("No Admin in list");
        
//     }

// }

    
}
