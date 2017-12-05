package database;

import java.sql.Connection;


public abstract class ConnectionManager {

    /**
     * Getting available connection
     *
     * @return connection instance
     */
    public abstract Connection getConnection();
}
