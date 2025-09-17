package consumidor;

public class WorkerConsumer implements Runnable {

    private final LineQueue queue;

    public WorkerConsumer(LineQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String me = Thread.currentThread().getName();

        try {

            for (; ; ) {
                LineItem it = queue.take();

                if (it.poison) {
                    System.out.printf("[%s] termino%n", me);
                    break;
                }
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
