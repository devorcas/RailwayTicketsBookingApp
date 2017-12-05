package dao;

import dao.mysql.MySQLDAOFactory;


public abstract class AbstractDAOFactory {

    /**
     * Retrieves DAO for user
     *
     * @return UserDAO
     */
    public abstract UserDAO getUserDAO();

    /**
     * Retrieves DAO for train
     *
     * @return TrainDAO
     */
    public abstract TrainDAO getTrainDAO();

    /**
     * Retrieves DAO for route
     *
     * @return RouteDAO
     */
    public abstract RouteDAO getRouteDAO();

    /**
     * Retrieves DAO for invoice
     *
     * @return RouteDAO
     */
    public abstract InvoiceDAO getInvoiceDAO();

    public static AbstractDAOFactory getDAOFactory(DataBaseTypes type) {
        return type.getFactory();
    }


    public enum DAOType {
        USER, TRAIN, ROUTE, INVOICE
    }


    public enum DataBaseTypes {
        MySQL {
            {
                this.factory = new MySQLDAOFactory();
            }
        };

        /**
         * Factory instance
         */
        AbstractDAOFactory factory;

        /**
         * Factory getter
         *
         * @return Factory
         */
        public AbstractDAOFactory getFactory() {
            return factory;
        }

    }
}
