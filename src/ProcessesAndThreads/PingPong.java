package ProcessesAndThreads;
import java.lang.Thread;

public class PingPong extends Thread{
    private String word;
    private int delay;

    public PingPong(String word, Integer delay) {
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
        PingPong ping = new PingPong("ping", 1000);
        PingPong pong = new PingPong("pong", 800);
        PingPong giulia = new PingPong("giulia", 500);
        PingPong lewCross = new PingPong("lew cross", 550);
        ping.start();
        pong.start();
        giulia.start();
        lewCross.start();
    }
}
