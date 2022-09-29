import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        try {
            Semaphore pingSemaphore = new Semaphore(1);
            Semaphore pongSemaphore = new Semaphore(1);

            pongSemaphore.acquire();

            Thread pingThread = new Thread(new Ping(pingSemaphore, pongSemaphore));
            Thread pongThread = new Thread(new Pong(pingSemaphore, pongSemaphore));

            pingThread.start();
            pongThread.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        /**
         * sPING      VERDE________________ROJO_________________________________________________VERDE
         * sPONG      ROJO_______________________________________VERDE__________ROJO_______________
         * HILOPING    ___________________sPing.aquire()__PING___sPong.release()__sPing.aquire()_PING
         * HILO PONG   ___sPong.acquire()_______________________________________PONG____________sPing.release()
         */

    }
}