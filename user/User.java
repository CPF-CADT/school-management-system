package user;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import core.MySQLConnection;
import exception.CastToUserHandleException;

public abstract class User {
    static Scanner input = new Scanner(System.in);
    static int numberOfUser = 0;
    public String lastName;
    public String firstName;

    protected LocalDate dob;
    protected String address;

    private String email;
    private String phoneNumber;
    private String password;
    protected String id;

    public static HashMap<String, User> listUser = new HashMap<String, User>();

    // login
    public User(String firstName, String lastName, String address, String phoneNumber, String email, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        dob = LocalDate.of(2025, 1, 1); // need to input later
        this.email = email;
        this.password = password; // defult password
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // register
    public User(String firstName, String lastName, String address, String phoneNumber, String emailFormat) {
        ++numberOfUser;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        dob = LocalDate.of(2025, 1, 1); // need to input later
        this.email = generateEmail(emailFormat).toLowerCase();
        this.password = "kdc2025"; // defult password
    }

    @Override
    public String toString() {
        String userInfo = "Name        : " + lastName + " " + firstName + "\n"
                + "Address     : " + address + "\n"
                + "DOB         : " + dob.toString() + "\n"
                + "Phone Number: " + phoneNumber + "\n"
                + "Email       : " + email + "\n";

        if (password.equals("kdc2025")) {
            userInfo += "Password (Default): " + password + "\n";
        }
        return userInfo;
    }

    // login
    public static User login(User log) {
        for (User user : User.listUser.values()) {
            if (log.equals(user)) {
                System.out.println("True");
                return user;
            }
        }
        System.out.println("Fail");
        return null;
    }

    @Override
    public boolean equals(Object obj) throws ClassCastException {
        try {
            CastToUserHandleException c = new CastToUserHandleException(obj);
            User log = (User) obj;
            if (this.email.equals(log.getEmail())) {
                if ((log.checkPassword(this.password))) {
                    return true;
                }
            }
        } catch (ClassCastException c) {
            System.out.println(c.getMessage());
        }
        return false;
    }

    public void setPassword(String newPassword, String curPassword) {
        if (curPassword.equals(this.password)) {
            this.password = newPassword;
        } else {
            System.out.println("Password Invalid");
        }
    }

    public boolean checkPassword(String password) {
        if (this.password.equals(password)) {
            return true;
        } else {
            return false;
        }

    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email, String conPassword) {
        if (conPassword.equals(this.password)) {
            this.email = email;
        } else {
            System.out.println("Password Invalid");
        }
    }

    public String getId() {
        return id;
    }

    public void setPhoneNumber(String phoneNumber, String conPassword) {
        if (conPassword.equals(this.password)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Password Invalid");
        }
    }

    private String generateEmail(String format) {
        return firstName + "." + lastName + numberOfUser + format;
    }

    public int registerToMySQL() throws SQLException {
        String userQuery = "INSERT INTO User (id, first_name, last_name, dob, address, email, phone_number, password) "
                + "VALUES ('" + id + "', '" + firstName + "', '" + lastName + "', '" + dob.toString() + "', '"
                + address + "', '" + email + "', '" + phoneNumber + "', '" + password + "');";
        int row = MySQLConnection.executeUpdate(userQuery);
        MySQLConnection.closeConnection();
        return row;
    } 
}
