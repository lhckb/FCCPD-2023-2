package ProcessesAndThreads.Synchronized;

public class Program {
    public static void main(String[] args) {
        int oneHundredThousand = 100_000;

        Warehouse warehouse = new Warehouse(oneHundredThousand);
        SoyProducer prod1 = new SoyProducer(111, 10, 1, warehouse);
        SoyProducer prod2 = new SoyProducer(222, 20, 10, warehouse);

        Thread threadProd1 = new Thread(prod1);
        Thread threadProd2 = new Thread(prod2);

        try {
            threadProd1.setPriority(1);
            threadProd2.setPriority(9);
            threadProd1.start();
            threadProd2.start();
            threadProd1.join();
            threadProd2.join();

            int totalBagsProduced = prod1.getBagsProduced() + prod2.getBagsProduced();
            System.out.println("Total produced overall: " + totalBagsProduced);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
