package dao.mysql;

import dao.TrainDAO;
import database.MySQLConnectionManager;
import entity.Train;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQLTrainDAO extends TrainDAO {

    private static final String GET_TRAIN_STR = "SELECT * FROM trains WHERE routeID = ?";
    private static final String GET_PRICES_STR = "SELECT * FROM prices WHERE routeID = ?";

    @Override
    public Train findTrain(Train inputTrain) {
        try {
            connection = MySQLConnectionManager.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_TRAIN_STR);

            preparedStatement.setString(1, inputTrain.getRouteId());
            //preparedStatement.setDate(2, inputTrain.getDate());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.first()) {
                Train resultTrain = new Train();
                resultTrain.setId(resultSet.getInt(DBColNames.ID.getContent()));
                resultTrain.setBerthReserved(resultSet.getInt(DBColNames.BERTH_RESERVED.getContent()));
                resultTrain.setCoupeReserved(resultSet.getInt(DBColNames.COUPE_RESERVED.getContent()));
                resultTrain.setSuitReserved(resultSet.getInt(DBColNames.SUITE_RESERVED.getContent()));
                resultTrain.setDate(resultSet.getDate(DBColNames.DATE.getContent()));
                resultTrain.setRouteId(resultSet.getString(DBColNames.ROUTE_ID.getContent()));

                return resultTrain;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLTrainDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return null;
    }

    @Override
    public Train getPrices(Train inputTrain) {
        try {
            connection = MySQLConnectionManager.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(GET_PRICES_STR);

            preparedStatement.setString(1, inputTrain.getRouteId());
            //preparedStatement.setDate(2, inputTrain.getDate());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.first()) {

                inputTrain.setBerthPrice(resultSet.getInt(DBColNames.BERTH_PRICE.getContent()));
                inputTrain.setCoupePrice(resultSet.getInt(DBColNames.COUPE_PRICE.getContent()));
                inputTrain.setSuitPrice(resultSet.getInt(DBColNames.SUITE_PRICE.getContent()));

                return inputTrain;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLTrainDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return null;
    }
}
