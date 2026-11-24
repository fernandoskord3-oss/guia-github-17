package hilos;

public class HiloCajero extends Thread {
    private String caja;

    public HiloCajero(String caja) {
        this.caja = caja;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(caja + " atiende cliente " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(caja + " interrumpida");
            }
        }
    }

    public static void main(String[] args) {
        HiloCajero a = new HiloCajero("Caja A");
        HiloCajero b = new HiloCajero("Caja B");
        a.start();
        b.start();
        System.out.println("main sigue trabajando");
    }
}