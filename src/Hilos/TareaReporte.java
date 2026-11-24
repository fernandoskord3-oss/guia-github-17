package Hilos;

public class TareaReporte implements Runnable {
    private String nombre;

    public TareaReporte(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        String hilo = Thread.currentThread().getName();
        System.out.println(nombre + " en el hilo " + hilo);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TareaReporte("Reporte diario"), "hilo-reportes");
        Thread t2 = new Thread(
                () -> System.out.println("Respaldo en el hilo " + Thread.currentThread().getName()),
                "hilo-respaldo"
        );
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida");
        }
        t2.start();
    }
}