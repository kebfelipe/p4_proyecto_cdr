package ProducerConsumer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SharedFileReader implements AutoCloseable {

    public final BufferedReader br;

    public SharedFileReader(String path) throws IOException {
        this.br = new BufferedReader(new FileReader(path));
    }

    public synchronized String nextLine() throws IOException{
        return br.readLine();
    }

    @Override
    public void close() throws IOException{
        br.close();
    }
}
