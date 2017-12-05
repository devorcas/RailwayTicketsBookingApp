package dao.mysql;

import dao.InvoiceDAO;
import database.MySQLConnectionManager;
import entity.Invoice;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQLInvoiceDAO extends InvoiceDAO {

    /**
     * Queries
     */
    public static final String INSERT_INVOICE = "INSERT INTO `railway_system`.`invoices` "
            + "(`passengerID`, `trainID`, `placeType`, `price`) VALUES (?,?,?,?);";

    @Override
    public int insertInvoice(Invoice inpInvoice) {
        try {
            connection = MySQLConnectionManager.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_INVOICE);
            preparedStatement.setInt(1, inpInvoice.getUserId());
            preparedStatement.setInt(2, inpInvoice.getTrainId());
            preparedStatement.setString(3, inpInvoice.getPlaceType().getContent());
            preparedStatement.setInt(4, inpInvoice.getPrice());

            return preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLInvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return -1;
    }

}
