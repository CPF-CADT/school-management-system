package exception;

public class NumberRangeExceptionHandling extends IllegalArgumentException {
    public NumberRangeExceptionHandling(String message) {
        super(message);
    }
    public NumberRangeExceptionHandling(int min,int max,int input) throws NumberRangeExceptionHandling {
        if (input < min || input > max) {
            throw new NumberRangeExceptionHandling("Number must be between "+min+"and " + max + "!");
        }
    }
}
