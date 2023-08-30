package ProcessesAndThreads.Synchronized;

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

    public void storeInWarehouse(int bagAmount) throws Exception {
        if ((bagAmount + stock) > maxCapacity) {
            throw new MaxCapacityExceededException();
        }

        stock += bagAmount;
    }
}
