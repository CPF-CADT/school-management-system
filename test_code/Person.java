package test_code;
import java.util.HashSet;
public class Person {
    static int numberOfPerson = 0;
    int id;
    String name;
    String phone;
    String address;
    static HashSet<Person> listPerson = new HashSet<Person>();
    public Person(String phone,String name){
        this.phone = phone;
        this.name = name;
    }
    public Person(String name,String phone,String address){
        numberOfPerson++;
        this.id = numberOfPerson;
        this.name = name;
        this.phone = phone;
        this.address = address;
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
    @Override
    public int hashCode() {
        return phone.hashCode()+name.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (phone == null) {
            if (other.phone != null)
                return false;
        } else if (!phone.equals(other.phone))
            return false;
        return true;
    }
}
