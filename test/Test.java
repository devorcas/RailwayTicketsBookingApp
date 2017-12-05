
import commands.ActionCommand;
import commands.EmptyCommand;
import dao.AbstractDAOFactory;
import dao.AbstractDAOFactory.DataBaseTypes;
import dao.mysql.MySQLDAOFactory;
import java.util.ResourceBundle;


public class Test {

    public static void main(String[] args) {
        AbstractDAOFactory DAO_FACTORY;

        ResourceBundle resource = ResourceBundle.getBundle("resources.database");
        System.out.println(resource.getString("db.type"));
        String type = resource.getString("db.type");

        DataBaseTypes dbtype = DataBaseTypes.valueOf("MySQL");
        System.out.println(dbtype);
        DAO_FACTORY = AbstractDAOFactory.getDAOFactory(dbtype);
    }
}
