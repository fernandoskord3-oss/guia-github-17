package hilos;

public class Tiempos {
    static void tarea(String nombre) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long inicio = System.currentTimeMillis();
        tarea("A");
        tarea("B");
        tarea("C");
        tarea("D");
        tarea("E");
        long sec = System.currentTimeMillis() - inicio;
        System.out.println("Secuencial: " + (sec / 100 * 100) + " ms aprox.");

        inicio = System.currentTimeMillis();
        Thread[] hilos = new Thread[5];
        for (int i = 0; i < 5; i++) {
            String n = "T" + i;
            hilos[i] = new Thread(() -> tarea(n));
            hilos[i].start();
        }
        for (Thread h : hilos) h.join();
        long par = System.currentTimeMillis() - inicio;
        System.out.println("Con hilos: " + (par / 100 * 100) + " ms aprox.");
    }
}