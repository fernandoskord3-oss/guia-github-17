package hilos;

public class SumaParalela {
    static long parte1, parte2;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 500; i++) parte1 += i;
        });
        Thread t2 = new Thread(() -> {
            for (int i = 501; i <= 1000; i++) parte2 += i;
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Parte 1: " + parte1);
        System.out.println("Parte 2: " + parte2);
        System.out.println("Total: " + (parte1 + parte2));
    }
}