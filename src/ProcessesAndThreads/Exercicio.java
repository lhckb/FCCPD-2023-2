package ProcessesAndThreads;

public class Exercicio extends Thread {
    private int[][] matrix = {{1, 2, 3, 4}, {2, 4, 6, 8}, {4, 8, 12, 16}, {8, 16, 24, 32}};
    private int threadIndex;

    public Exercicio(int index) {
        threadIndex = index;
    }

    private int sumLine(int[] line) {
        int sum = 0;
        for(int num : line) {
            sum = sum + num;
        }
        
        return sum;
    }

    public void run() {
        try {
            int result = sumLine(matrix[threadIndex]);
            System.out.println("The result of the sum line " + (threadIndex + 1) + " is " + result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Exercicio(0).start();
        new Exercicio(1).start();
        new Exercicio(2).start();
        new Exercicio(3).start();
    }
}
