import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

public class FileProducer implements Runnable {

    public final SharedFileReader reader;
    public final LineQueue queue;
    public final AtomicLong seqGen;

    public FileProducer(SharedFileReader reader, LineQueue queue, AtomicLong seqGen) {
        this.reader = reader;
        this.queue = queue;
        this.seqGen = seqGen;
    }

    @Override
    public void run() {
        String me = Thread.currentThread().getName();

        try {
            for(;;){
                String line = reader.nextLine();

                if(line == null) break;

                long seq = seqGen.incrementAndGet();
                System.out.printf("[%s] produjo seq=%d :: %s%n", me, seq, line);
            }
        } catch (Exception e) {
            System.err.printf("[%s] Error productor: %s%n", me, e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
