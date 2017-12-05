package dao.mysql;

import dao.AbstractDAO;
import dao.RouteDAO;
import database.MySQLConnectionManager;
import entity.Entity;
import entity.Route;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLRouteDAO extends RouteDAO {

    /**
     * Queries
     */
    private static final String getRouteStr = "SELECT * FROM routes WHERE "
            + "departureStation = ? AND destinationStation = ? AND departureTime > ?";

    @Override
    public Iterable<Route> findRoutes(Route initRoute) {
        try {
            connection = MySQLConnectionManager.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(getRouteStr);
            preparedStatement.setString(1, initRoute.getDepartureStation());
            preparedStatement.setString(2, initRoute.getDestinationStation());
            preparedStatement.setTime(3, initRoute.getDepartureTime());

            resultSet = preparedStatement.executeQuery();
            List<Route> routeList = new ArrayList();
            while (resultSet.next()) {
                Route resultRoute = new Route();

                resultRoute.setBerthPlaces(resultSet.getInt(DBColNames.BERTH_PLACES.getContent()));
                resultRoute.setCoupePlaces(resultSet.getInt(DBColNames.COUPE_PLACES.getContent()));
                resultRoute.setSuitPlaces(resultSet.getInt(DBColNames.SUITE_PLACES.getContent()));
                resultRoute.setDepartureStation(resultSet.getString(DBColNames.DEPARTURE_STATION.getContent()));
                resultRoute.setDestinationStation(resultSet.getString(DBColNames.DESTINATON_STATION.getContent()));
                resultRoute.setId(resultSet.getString(DBColNames.ID.getContent()));
                resultRoute.setDepartureTime(Time.valueOf(resultSet.getString(DBColNames.DEPARTURE_TIME.getContent())));
                resultRoute.setDestinationTime(Time.valueOf(resultSet.getString(DBColNames.DESTINATION_TIME.getContent())));

                routeList.add(resultRoute);
            }

            return routeList;

        } catch (SQLException ex) {
            Logger.getLogger(MySQLRouteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(resultSet);
            close(resultSet);
            close(connection);
        }
        return null;
    }
}
