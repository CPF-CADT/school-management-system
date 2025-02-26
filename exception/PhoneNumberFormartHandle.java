package exception;

public class PhoneNumberFormartHandle extends IllegalArgumentException {

    public PhoneNumberFormartHandle() {
        super();
    }

    PhoneNumberFormartHandle(String message) {
        super(message);
    }

    public void IsPhoneNumberValid(String phone) {

        if(phone.length() < 9 ||phone.length() >18){
            throw new PhoneNumberFormartHandle("Digit of phone number must be between from 9 to 15");
        }

        if (phone.charAt(0) != '+' && phone.charAt(0) != '0') {
            throw new PhoneNumberFormartHandle("Phone number must start with '+' or '0'.");
        }
        if(phone.charAt(1) == '0' && phone.charAt(0) == '0' ){
            throw new PhoneNumberFormartHandle("Invalid Phone Number ");
        }
        if(phone.charAt(0) == '+'){
            if(phone.charAt(4) =='0'  ){
                throw new PhoneNumberFormartHandle("Invalid Phone Number ");
            }
        }

        for (int i = 1; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                throw new PhoneNumberFormartHandle("Phone number can only contain digits after the first character.");
            }
        }
    }
}
