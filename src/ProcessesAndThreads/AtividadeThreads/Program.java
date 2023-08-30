package ProcessesAndThreads.AtividadeThreads;

public class Program {
    public static void main(String[] args) {
        final int maxCapacity = 100_000;

        Warehouse warehouse = new Warehouse(maxCapacity);
        SoyProducer prod1 = new SoyProducer(111, 10, 13, warehouse);
        SoyProducer prod2 = new SoyProducer(222, 21, 10, warehouse);

        Thread threadProd1 = new Thread(prod1);
        Thread threadProd2 = new Thread(prod2);

        try {
            threadProd1.start();
            threadProd2.start();
            threadProd1.join();
            threadProd2.join();

            int totalBagsProduced = prod1.getBagsProduced() + prod2.getBagsProduced();
            System.out.println("Total produced overall: " + totalBagsProduced);
            System.out.println("Final warehouse stock: " + warehouse.getStock());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
