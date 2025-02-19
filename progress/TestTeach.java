package progress;

import user.*;

public class TestTeach {
    public static void main(String[] args) {
        User teahcer = new Teacher(
            "Smith",
            "Alice",
            "456 Elm St, CA",
            "9876543210",
            "Mathematics");
        User admin =  new Admin(
            "John",
            "Doe",
            "123 Main St, NY",
            "1234567890",
            "Administrator");
        User tea = new Teacher("smithalice1@tch.kdc.edu", "kdc2025");
        System.out.println(User.listUser.values());
        System.out.println(Teacher.login(tea));
    }
}
