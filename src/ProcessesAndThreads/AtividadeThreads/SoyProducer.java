package ProcessesAndThreads.AtividadeThreads;

public class SoyProducer implements Runnable {
    private final int code;
    private int bagsProduced;
    private final int bagsPerCycle;
    private final int delay;
    private final Warehouse warehouse;

    public SoyProducer(int codeGiven, int bagsPerCycleGiven, int delayGiven, Warehouse warehouseGiven) {
        code = codeGiven;
        bagsProduced = 0;
        bagsPerCycle = bagsPerCycleGiven;
        delay = delayGiven;
        warehouse = warehouseGiven;
    }

    public int getBagsProduced() {
        return bagsProduced;
    }

    public void run() {
        try {
            while(true) {
                for (int i = 0; i < 10; i++) {
                    synchronized (warehouse) {
                        warehouse.storeInWarehouse(bagsPerCycle);
                    }
                    bagsProduced += bagsPerCycle;
                }
                System.out.println("Producer code: " + code + " | Bags Produced: " + bagsProduced);
                System.out.println("Warehouse stock: " + warehouse.getStock());
                Thread.sleep(delay);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }
}
