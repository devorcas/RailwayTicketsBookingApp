package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQLConnectionManager extends ConnectionManager {

    private static MySQLConnectionManager instance;

    private Connection connection;

    /**
     * Static method to get single instance (singleton)
     *
     * @return instance of manager
     */
    public static synchronized MySQLConnectionManager getInstance() {
        if (instance == null) {
            instance = new MySQLConnectionManager();
        }
        return instance;
    }

    /**
     * Constructor
     */
    private MySQLConnectionManager() {
        try {
            connection = MySQLConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
