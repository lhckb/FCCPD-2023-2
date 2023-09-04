package ProcessesAndThreads.WaitAndNotify.Exceptions;

public class BagAmountNotAvailableException extends Exception {
    public BagAmountNotAvailableException() {
        super("The amount of bags requested to subtract is not available");
    }
}
