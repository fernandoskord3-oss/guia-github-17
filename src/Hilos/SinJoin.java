package hilos;

public class SinJoin {
    static long total = 0;

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                return;
            }
            total = 500500;
        });
        t.start();
        System.out.println("Total sin esperar: " + total);
    }
}