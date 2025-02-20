package user;

// import java.util.HashMap;

public class Admin extends User {
    final static String EMAIL_FORMAT = "@adm.kdc.edu";
    static int numberOfAdmin = 0;
    public String role;
    public String id = "A";

    public Admin(String firstName, String lastName, String address, String phoneNumber, String role) {
        super(firstName, lastName, address, phoneNumber, EMAIL_FORMAT);
        this.role = role;
        id +=(String.valueOf(++numberOfAdmin));
        User.listUser.put(this.id, this);
    }

    public Admin(String email, String password) {
        super(email, password);
    }

    @Override
    public String toString() {
        return super.toString() +"ID : " + id +  "  Role : " + this.role +"\n";
    }


    public void displayUserInfo() {
        super.displayUserInfo();
        System.out.println("ID           : " + id);
        System.out.println("Role         : " + role);
        System.out.println("====================================\n");
    }
    // public static Admin selectAdmin() {
    // if (!User.listUser.isEmpty()) {
    // System.out.println("List Admin ");
    // for (User ad : User.listUser.values()) {
    // System.out.println(ad);
    // }
    // System.out.print("Enter ID : ");
    // int select = input.nextInt();
    // User findAdmin=  User.listUser.get(select);
    // if(findAdmin instanceof Student){
    //     return (Admin) findAdmin;
    // }else {
    //     return null;
    // }
    // } else {
    // System.out.println("No Admin in list");
    // return null;
    // }

    // }

    // // }


}
