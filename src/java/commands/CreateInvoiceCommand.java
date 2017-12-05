package commands;

import static commands.ActionCommand.DEPATURE_DATE;
import controller.ConfigurationManager;
import entity.BerthType;
import entity.Invoice;
import entity.Route;
import entity.Train;
import entity.User;
import java.sql.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;


public class CreateInvoiceCommand extends ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        Matcher matcher = null;

        String wagonType = "";
        String buttonPressed = request.getParameterNames().nextElement();
        Pattern patternSuite = Pattern.compile(SUITE_REGEX);

        // Determine the wagon type and route id
        matcher = patternSuite.matcher(buttonPressed);
        if (matcher.matches()) {
            wagonType = matcher.group(1);
            String routeId = matcher.group(2);

            //preparing and adding orderedTrain to session
            Train train = new Train();
            train.setRouteId(routeId);

            train.setDate((Date) request.getAttribute(DEPATURE_DATE));
            Train orderedTrain = DAO_FACTORY.getTrainDAO().findTrain(train);
            orderedTrain = DAO_FACTORY.getTrainDAO().getPrices(orderedTrain);
            request.getSession().setAttribute(ORDERED_TRAIN_ATT_NAME, orderedTrain);

            //preparing and adding orderedRoute to session            
            List<Route> foundRoutes = (List<Route>) request.getSession().getAttribute(FOUND_ROUTES_PAR_NAME);
            //request.getSession().removeAttribute(FOUND_ROUTES_PAR_NAME);
            for (Route foundRoute : foundRoutes) {
                if (foundRoute.getId().equals(routeId)) {
                    Route orderedRoute = foundRoute;
                    request.getSession().setAttribute(ORDERED_ROUTE_ATT_NAME, orderedRoute);
                }
            }

            //preparing and adding invoice to session
            Invoice invoice = new Invoice();
            invoice.setTrainId(orderedTrain.getId());
            User user = (User) request.getSession().getAttribute(USER_PAR_NAME);
            invoice.setUserId(user.getId());
            invoice.setPlaceType(BerthType.valueOf(wagonType.toUpperCase()));

            invoice.setPrice(orderedTrain.getPrice(wagonType));
            request.getSession().setAttribute(PREPARED_INVOICE, invoice);

            return ConfigurationManager.getInvoicePage();
        } else {
            return ConfigurationManager.getMainPage();
        }
    }
}
