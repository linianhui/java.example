package network.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BIOThreadPoolEchoServer extends BIOEchoServer {

    public BIOThreadPoolEchoServer(int port) {
        super(port);
    }

    @Override
    public void runCore(final ServerSocket serverSocket) throws IOException {
        ExecutorService executor = new ThreadPoolExecutor(
            2,
            8,
            10, TimeUnit.MINUTES,
            new ArrayBlockingQueue<Runnable>(16),
            new ThreadPoolExecutor.AbortPolicy()
        );

        while (true) {
            Socket socket = serverSocket.accept();
            executor.submit(new BIOEchoRunnable(socket));
        }
    }
}