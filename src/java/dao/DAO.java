package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public interface DAO {

    /**
     * Closes ResultSet
     *
     * @param res resultSet to close
     */
    public void close(ResultSet res);

    /**
     * Statement close method
     *
     * @param st statement to close
     */
    public void close(Statement st);

    /**
     * Closes the connection
     *
     * @param connection connection to close
     */
    public void close(Connection connection);
}
