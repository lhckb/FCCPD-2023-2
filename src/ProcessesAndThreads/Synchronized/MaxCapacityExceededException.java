package ProcessesAndThreads.Synchronized;

public class MaxCapacityExceededException extends Exception{
    public MaxCapacityExceededException() {
        super("The warehouse capacity has exceeded its limit");
    }
}
