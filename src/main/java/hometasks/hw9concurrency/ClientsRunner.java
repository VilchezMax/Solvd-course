package hometasks.hw9concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

public class ClientsRunner {
    public static final int MAX_CONNECTIONS = 5;


    final static Logger logger = LogManager.getLogger(ClientsRunner.class);

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ExecutorService executor1 = new ThreadPoolExecutor(MAX_CONNECTIONS, MAX_CONNECTIONS, 0, TimeUnit.SECONDS, queue);
        ConnectionPool pool = new ConnectionPool(MAX_CONNECTIONS);
        pool.init();
        //ExecutorService executor1 = Executors.newFixedThreadPool(MAX_CONNECTIONS);

        Runnable task = () -> {
            pool.run();
            logger.info("On thread: " + Thread.currentThread().getName());
            logger.info(Thread.currentThread().getName() + "- Sleeping...");
            Connection.sleep1s();
            logger.info(Thread.currentThread().getName() + "- Woke up.");
            logger.info("On thread: " + Thread.currentThread().getName());
        };

        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            Thread t1 = new Thread(task);
            Future<?> future = executor1.submit(task);

            logger.info("Finished? " + future.isDone());
            while (!future.isDone()) {
                logger.info("Individual thread T1 started");
                t1.start();
                logger.info(Thread.currentThread().getName().replace("pool-2-", "") + " - Waiting...");
                Connection.sleep1s();
                t1.join();
                logger.info("Individual thread T1 finished");
            }
            logger.info(Thread.currentThread().getName() + " is done: " + future.isDone());
        }

        executor1.awaitTermination(36, TimeUnit.SECONDS);
        executor1.shutdown();
    }
}
