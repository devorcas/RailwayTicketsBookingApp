package commands;

import controller.ConfigurationManager;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class FindUnconfirmed extends ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        List<User> unconfirmedUsers = (List<User>) DAO_FACTORY.getUserDAO().findUnconfirmedUsers();
        request.setAttribute(UNCONFIRMED_USERS, unconfirmedUsers);
        return ConfigurationManager.getUnconfirmedPage();
    }
}
