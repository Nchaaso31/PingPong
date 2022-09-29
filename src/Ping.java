import java.util.concurrent.Semaphore;

public class Ping implements Runnable{
    private Semaphore pingSemaphore;
    private Semaphore pongSemaphore;

    public Ping(Semaphore pingSemaphore, Semaphore pongSemaphore) {
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                // Aquí el pingSemaphore estará en ROJO
                pingSemaphore.acquire(); // Espero a que esté en VERDE
                // Aquí el pingSemaphore estará en ROJO
                System.out.println("PING");
                //Aquí el pongSemaphore estará en ROJO
                pongSemaphore.release(); // Lo pone en verde
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}