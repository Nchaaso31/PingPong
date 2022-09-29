import java.util.concurrent.Semaphore;

public class Pong implements Runnable {
    private Semaphore pingSemaphore;
    private Semaphore pongSemaphore;

    public Pong(Semaphore pingSemaphore, Semaphore pongSemaphore) {
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                // Aquí pongSemaphore estará en ROJO
                pongSemaphore.acquire(); // Espera hasta que esté en verde
                // Aquí pongSemaphore está en ROJO
                System.out.println("PONG!!!!!!!!!!!!!!!!!");
                // Aquí el pingSemaphore está en ROJO
                pingSemaphore.release(); // Pone el pingSempahore en VERDE
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



