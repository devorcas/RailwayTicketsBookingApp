package dao;

import entity.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;


public abstract class AbstractDAO<K, T extends Entity> implements DAO {

    protected Connection connection = null;
    protected ResultSet resultSet = null;
    protected PreparedStatement preparedStatement = null;
    public static final String LOG4JXML = "log4j.xml";

    static {
        DOMConfigurator configurator = new DOMConfigurator();
        configurator.doConfigure(LOG4JXML, LogManager.getLoggerRepository());
    }

    @Override
    public void close(ResultSet res) {
        if (res != null) {
            try {
                res.close();
            } catch (SQLException ex) {
                Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void close(Statement st) {

        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
