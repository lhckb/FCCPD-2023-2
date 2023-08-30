package ProcessesAndThreads;

public class PingPongRunnable implements Runnable {
    private String word;
    private int delay;

    public PingPongRunnable(String word, Integer delay) {
        this.word = word;
        this.delay = delay;
    }

    public void run() {
        try {
            for(;;) {
                System.out.println(word);
                Thread.sleep(delay);
            }
        } catch(Exception ex) {
            System.out.println("error");
            return;
        }
    }

    public static void main(String[] args) {
        PingPongRunnable ping = new PingPongRunnable("ping", 1000);
        PingPongRunnable pong = new PingPongRunnable("pong", 800);
        PingPongRunnable giulia = new PingPongRunnable("giulia", 500);
        PingPongRunnable lewCross = new PingPongRunnable("lew cross", 550);
        new Thread(ping).start();
        new Thread(pong).start();
        new Thread(giulia).start();
        new Thread(lewCross).start();
    }
}
