package dao.mysql;

import dao.AbstractDAOFactory;
import dao.DAO;
import dao.InvoiceDAO;
import dao.RouteDAO;
import dao.TrainDAO;
import dao.UserDAO;
import java.util.HashMap;
import java.util.Map;


public class MySQLDAOFactory extends AbstractDAOFactory {

    private Map<DAOType, DAO> poolMySQLDAO;

    public MySQLDAOFactory() {
        poolMySQLDAO = new HashMap<>();
        poolMySQLDAO.put(DAOType.USER, new MySQLUserDAO());
        poolMySQLDAO.put(DAOType.TRAIN, new MySQLTrainDAO());
        poolMySQLDAO.put(DAOType.ROUTE, new MySQLRouteDAO());
        poolMySQLDAO.put(DAOType.INVOICE, new MySQLInvoiceDAO());
    }

    @Override
    public UserDAO getUserDAO() {
        return (UserDAO) poolMySQLDAO.get(DAOType.USER);
    }

    @Override
    public TrainDAO getTrainDAO() {
        return (TrainDAO) poolMySQLDAO.get(DAOType.TRAIN);
    }

    @Override
    public RouteDAO getRouteDAO() {
        return (RouteDAO) poolMySQLDAO.get(DAOType.ROUTE);
    }

    @Override
    public InvoiceDAO getInvoiceDAO() {
        return (InvoiceDAO) poolMySQLDAO.get(DAOType.INVOICE);
    }

}
