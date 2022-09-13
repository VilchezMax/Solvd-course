package hometasks.hw9concurrency;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Connection implements Comparable {
    private final int connectionID;
    private boolean connected;

    final Logger logger = LogManager.getLogger(Connection.class);

    public Connection(int id) {
        this.connectionID = id;
        this.connected = false;
    }

    public int getConnectionID() {
        return connectionID;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public void connect() {
        if (!this.isConnected()) {
            setConnected(true);
        } else {
            logger.warn("This connection is not being turned on");
            throw new RuntimeException();
        }
    }

    public void disconnect() {
        if (this.isConnected()) {
            setConnected(false);
        } else {
            logger.warn("This connection was disconnected already");
            throw new RuntimeException();
        }
    }

    public static void sleep1s() {
        final Logger logger = LogManager.getLogger(Connection.class);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            logger.info(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return connectionID == that.connectionID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionID);
    }

    @Override
    public int compareTo(Object o) {
        Connection that = (Connection) o;
        return Integer.compare(that.getConnectionID(), this.getConnectionID());

    }
}
