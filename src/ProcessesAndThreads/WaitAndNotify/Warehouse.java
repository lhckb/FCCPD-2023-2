package ProcessesAndThreads.WaitAndNotify;

import ProcessesAndThreads.WaitAndNotify.Exceptions.BagAmountNotAvailableException;
import ProcessesAndThreads.WaitAndNotify.Exceptions.MaxCapacityExceededException;

public class Warehouse {
    private final int maxCapacity;
    private int stock;

    public Warehouse(int maxCapacityGiven) {
        stock = 0;
        maxCapacity = maxCapacityGiven;
    }

    public int getStock() {
        return stock;
    }

    public boolean canAddBags(int bagAmount) {
        if ((bagAmount + stock) > maxCapacity) {
            return false;
        }
        return true;
    }

    public boolean canRemoveBags(int bagAmount) {
        if ((stock - bagAmount) < 0) {
            return false;
        }
        return true;
    }

    public void storeInWarehouse(int bagAmount) throws MaxCapacityExceededException {
        if (!canAddBags(bagAmount)) {
            throw new MaxCapacityExceededException();
        }

        stock += bagAmount;
    }

    public void consumeFromWarehouse(int bagAmount) throws BagAmountNotAvailableException {
        if (!canRemoveBags(bagAmount)) {
            throw new BagAmountNotAvailableException();
        }

        stock -= bagAmount;
    }
}
