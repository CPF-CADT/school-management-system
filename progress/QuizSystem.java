package progress;
class TimerThread extends Thread {
    private int timeLimit;  // Time limit in seconds
    private int remainingTime;  // To store the remaining time
    private boolean timeUp = false;

    public TimerThread(int timeLimit) {
        this.timeLimit = timeLimit;
        this.remainingTime = timeLimit;

    }

    public void run() {
        try {
            for (int i = timeLimit; i > 0; i--) {
                remainingTime = i;  // Update remaining time
                System.out.print("\rRemaining Time: " + remainingTime+" "); // Print on same line (no refresh)
                Thread.sleep(1000);  // Sleep for 1 second
            }
            timeUp = true;
            System.out.println("\nTime's up!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public boolean isTimeUp() {
        return timeUp;
    }

    public int getTimeRemain() {
        return remainingTime;
    }
}

public class QuizSystem {
    public static void main(String[] args) {
        TimerThread timer = new TimerThread(5);  // 10-second timer for each question
        timer.start();  // Start the timer thread
        
        // Simulate quiz question and user interaction
        System.out.println("Question 1: What is 2 + 2?");
        
        // Continuously display the remaining time without refreshing
        while (!timer.isTimeUp()) {
            try {
                Thread.sleep(500);  // Sleep for half a second to avoid excessive CPU usage
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("\nProceed to next question...");
    }
}
