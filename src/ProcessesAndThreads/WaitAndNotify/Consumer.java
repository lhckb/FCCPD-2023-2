package ProcessesAndThreads.WaitAndNotify;

public class Consumer implements Runnable {
    private final int code;
    private final int bagsConsumedPerCycle;
    private int totalBagsConsumed;
    private final int delay;
    private final Warehouse warehouse;

    public Consumer(int codeGiven, int bagsPerCycleGiven, int delayGiven, Warehouse warehouseGiven) {
        code = codeGiven;
        bagsConsumedPerCycle = bagsPerCycleGiven;
        delay = delayGiven;
        warehouse = warehouseGiven;
        totalBagsConsumed = 0;
    }

    public void run() {
        synchronized (warehouse) {
            while (true) {
                try {
                    for (int i = 0; i < 10; i++) {
                        if (!warehouse.canRemoveBags(bagsConsumedPerCycle)) {
                            warehouse.wait();
                        }
                        warehouse.consumeFromWarehouse(bagsConsumedPerCycle);
                        totalBagsConsumed += bagsConsumedPerCycle;
                        warehouse.notifyAll();
                    }
                    System.out.println("Consumer code: " + code + " | Bags Consumed: " + totalBagsConsumed);
                    System.out.println("Warehouse stock: " + warehouse.getStock());
                    Thread.sleep(delay);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return;
                }
            }
        }
    }
}
