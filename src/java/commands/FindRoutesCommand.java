package commands;

import controller.ConfigurationManager;
import entity.Route;

import java.sql.Time;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


public class FindRoutesCommand extends ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        Route route = new Route();
        route.setDepartureStation(request.getParameter(DEPATURE_ST_PAR_NAME));
        route.setDestinationStation(request.getParameter(DESTINATION_ST_PAR_NAME));
        route.setDepartureTime(Time.valueOf(request.getParameter(TIME_PAR_NAME)));

        Date depatureDate = Date.valueOf(request.getParameter(DEPATURE_DATE));
        request.getSession().removeAttribute(DEPATURE_DATE);

        List<Route> foundRoutes = (List<Route>) DAO_FACTORY.getRouteDAO().findRoutes(route);
        request.getSession().removeAttribute(FOUND_ROUTES_PAR_NAME);
        request.getSession().setAttribute(FOUND_ROUTES_PAR_NAME, foundRoutes);
        request.getSession().setAttribute(DEPATURE_DATE, depatureDate);

        return ConfigurationManager.getMainPage();
    }
}
