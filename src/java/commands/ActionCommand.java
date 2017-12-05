package commands;

import dao.AbstractDAOFactory;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class ActionCommand {

    static final String PARAM_EMAIL = "email";
    static final String PARAM_PASSWORD = "password";
    static final String PARAM_NAME = "name";
    static final String PARAM_SURNAME = "surname";
    static final String PARAM_PHONE = "phone";
            /**
             * DAO factory instance
             */
    protected static final AbstractDAOFactory DAO_FACTORY;
    public static final String USER_PAR_NAME = "user";
    public static final String UNCONFIRMED_USERS = "unconfirmedUsers";
    public static final String DEPATURE_DATE = "depatureDate";
    public static final String FOUND_ROUTES_PAR_NAME = "foundRoutes";
    public static final String DATE_PATTERN = "yyyy.MM.dd";
    public static final String USER_TYPE_PAR_NAME = "userType";
    protected static final String ACTIVATE_ACT = "activate";
    protected static final String DELETE_ACT = "delete";
    protected static final String SELECT_ID_REGEX = "(select_id)([0-9]+)";
    public static final String ERROR_REGISTER_MESSAGE_ATT_NAME = "errorRegisterMessage";
    static final String ADMIN_LOGIN = "admin";
    static final String EMAIL_PAR_NAME = "email";
    static final String ERROR_LOGINPASS_MSG_ATT_NAME = "errorLoginPassMessage";
    static final String PASSWORD_PAR_NAME = "password";
    public static final String DEPATURE_ST_PAR_NAME = "depatureSt";
    public static final String DESTINATION_ST_PAR_NAME = "destinationSt";
    public static final String TIME_PAR_NAME = "time";
    public static final String ORDERED_ROUTE_ATT_NAME = "orderedRoute";
    public static final String ORDERED_TRAIN_ATT_NAME = "orderedTrain";
    public static final String PREPARED_INVOICE = "preparedInvoice";
    public static final String SUITE_REGEX = "(suit|coupe|berth)(.*)";

    static {
        ResourceBundle resource = ResourceBundle.getBundle("resources.database");
        DAO_FACTORY = AbstractDAOFactory.getDAOFactory(
                AbstractDAOFactory.DataBaseTypes.valueOf(resource.getString("db.type")));
    }

    /**
     * Method to perform action
     *
     * @param request Http servlet request
     * @param response Http servlet response
     */
    public abstract String execute(HttpServletRequest request);
}
