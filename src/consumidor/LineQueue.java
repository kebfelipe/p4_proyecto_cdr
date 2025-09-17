import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LineQueue {

    private final BlockingQueue<LineItem> q;

    public LineQueue(int capacity){
        this.q = new ArrayBlockingQueue<LineItem>(capacity);
    }

    public void put(LineItem it) throws InterruptedException {
        q.put(it);
    }

    public LineItem take() throws InterruptedException {
        return q.take();
    }
}
