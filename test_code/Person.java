package test_code;
import java.util.HashSet;
public class Person {
    static int numberOfPerson = 0;
    int id;
    String name;
    String phone;
    static HashSet<Person> listPerson = new HashSet<Person>();
    public Person(String phone){
        this.phone = phone;
    }
    public Person(String name,String phone){
        numberOfPerson++;
        this.id = numberOfPerson;
        this.name = name;
        this.phone = phone;
        listPerson.add(this);
    }
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }
    static Person searchPerson(Person other) {
        for(Person i :Person.listPerson){
            if(i.phone.equals(other.phone)){
                return i;
            }
        }
        return null;
    }
}
