import utils.DOB;

public class Test {
    public static void main(String[] args) {
        DOB dob = new DOB("11-03-2006");
        System.out.println(dob.getDay());
        System.out.println(dob.getMonth());
        System.out.println(dob.getYear());
    }
}
