package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class MySQLConnector {

    public static final String RESOURCES_DATABASE = "resources.database";
    public static final String DB_URL = "db.url";
    public static final String DB_USER = "db.user";
    public static final String DB_PASS = "db.pass";

    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle(RESOURCES_DATABASE);
        String url = resource.getString(DB_URL);
        String user = resource.getString(DB_USER);
        String pass = resource.getString(DB_PASS);
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        return DriverManager.getConnection(url, user, pass);
    }

}
