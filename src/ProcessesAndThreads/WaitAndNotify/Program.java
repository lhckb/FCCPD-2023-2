package ProcessesAndThreads.WaitAndNotify;

public class Program {
    public static void main(String[] args) {
        final int maxCapacity = 1200;

        Warehouse warehouse = new Warehouse(maxCapacity);
        SoyProducer prod1 = new SoyProducer(111, 10, 1300, warehouse);
        SoyProducer prod2 = new SoyProducer(222, 21, 1000, warehouse);
        Consumer cons1 = new Consumer(333, 7, 500, warehouse);

        Thread threadProd1 = new Thread(prod1);
        Thread threadProd2 = new Thread(prod2);
        Thread threadCons1 = new Thread(cons1);

        try {
            threadProd1.start();
            threadProd2.start();
            threadCons1.start();
            threadProd1.join();
            threadProd2.join();
            threadCons1.join();

            int totalBagsProduced = prod1.getBagsProduced() + prod2.getBagsProduced();
            System.out.println("Total produced overall: " + totalBagsProduced);
            System.out.println("Final warehouse stock: " + warehouse.getStock());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
