package exception;

public class NumberRangeExceptionHandling extends IllegalArgumentException{
    protected int max;
    public NumberRangeExceptionHandling(String message){
        super(message);
    }
    public NumberRangeExceptionHandling(int max) {
        super("Number must be between 0 and " + max + "!");
        this.max = max;
    }
    public void checkNumberInRange(int input){
        if(input < 0 || input > max){
            throw new NumberRangeExceptionHandling(max);
        }
    }
}
