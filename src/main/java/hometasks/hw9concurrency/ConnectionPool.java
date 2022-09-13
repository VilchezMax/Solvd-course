package hometasks.hw9concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ConcurrentSkipListSet;


public class ConnectionPool implements Runnable {
    private ConcurrentSkipListSet<Connection> usedConnections;
    private ConcurrentSkipListSet<Connection> idleConnections;
    private int currentConnections;
    private final int maxConnections;
    private final int MAX_TRIES = 5;
    private boolean running = false;

    final Logger logger = LogManager.getLogger(ConnectionPool.class);

    public ConnectionPool(int maxSize) {
        this.maxConnections = maxSize;
        this.usedConnections = new ConcurrentSkipListSet<>();
        this.idleConnections = new ConcurrentSkipListSet<>();
    }


    public Connection connect() {
        Connection connection;
        if (!idleConnections.isEmpty()) {
            connection = idleConnections.pollFirst();
            usedConnections.add(connection);
            logger.info("Using connection N°" + connection.getConnectionID());
        } else if (usedConnections.isEmpty() || currentConnections < maxConnections) {
            connection = createConnection();
            usedConnections.add(connection);
            logger.info("Created connection N°" + connection.getConnectionID());
        } else {
            connection = null;
            logger.info("No connections created");
            throw new RuntimeException("All connections are being used");
        }
        return connection;
    }

    public void init() {
        for (int i = 0; i < this.maxConnections; i++) {
            this.idleConnections.add(connect());
        }
    }

    public synchronized void disconnect(Connection connection) {
        if (usedConnections.contains(connection)) {
            usedConnections.remove(connection);
            idleConnections.add(connection);
        } else if (idleConnections.contains(connection)) {
            throw new RuntimeException("Connection " + connection.getConnectionID() + "was already idle.");
        } else {
            throw new RuntimeException("Connection " + connection.getConnectionID() + "was not in the pool.");
        }

    }

    public synchronized Connection createConnection() {
        if (currentConnections++ < maxConnections) {
            return new Connection(currentConnections);
        } else {
            throw new IllegalStateException("Current connections can't be more than " + maxConnections);
        }
    }

    @Override
    public void run() {
        Connection connection = connect();
        Connection.sleep1s();
        disconnect(connection);
    }
}
