package commands;

import controller.ConfigurationManager;
import dao.AbstractDAOFactory;
import dao.UserDAO;
import entity.User;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;


public class UpdateUsersCommand extends ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        Enumeration<String> params = request.getParameterNames();
        Pattern pattern = Pattern.compile(SELECT_ID_REGEX);
        Matcher matcher = null;
        List<User> activateUsers = null;
        List<User> deleteUsers = null;

        while (params.hasMoreElements()) {
            String param = params.nextElement();

            matcher = pattern.matcher(param);

            if (matcher.matches()) {
                int id = Integer.valueOf(matcher.group(2));
                String action = request.getParameter(param);

                if (action.equals(ACTIVATE_ACT)) {
                    if (activateUsers == null) {
                        activateUsers = new ArrayList<>();
                    }
                    User user = new User();
                    user.setId(id);
                    activateUsers.add(user);
                }

                if (action.equals(DELETE_ACT)) {
                    if (deleteUsers == null) {
                        deleteUsers = new ArrayList<>();
                    }
                    User user = new User();
                    user.setId(id);
                    deleteUsers.add(user);
                }
                UserDAO userDAO = DAO_FACTORY.getUserDAO();
                userDAO.activateUsers(activateUsers);
                userDAO.deleteUsers(deleteUsers);

            }

        }
        Iterable<User> users = DAO_FACTORY.getUserDAO().findUnconfirmedUsers();
        request.setAttribute(UNCONFIRMED_USERS, users);
        page = ConfigurationManager.getAdminPage();

        return page;
    }

}
