package exception;

import user.Admin;
import user.Student;
import user.Teacher;
import user.User;

public class CastToUserHandleException extends ClassCastException{
    public CastToUserHandleException(String message){
        super(message);
    }
    public CastToUserHandleException(Object source, Object dest){
        if(!(source instanceof User)){
            throw new CastToUserHandleException("Cannot Cast the object isn't type of User");
        }else{
            if(!(source.getClass().equals(dest.getClass()))){
                throw new CastToUserHandleException("Cannot Cast the object isn't the same type");
            }else{
                if(source instanceof Teacher){
                    dest = (Teacher) source;
                }else if(source instanceof Student){
                    dest = (Student) source; 
                }else{
                    dest = (Admin) source; 
                }
            }
        }
    }
}
