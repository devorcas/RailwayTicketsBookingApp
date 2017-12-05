package commands;

import controller.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;


public class LogoutCommand extends ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        request.getSession().invalidate();

        return ConfigurationManager.getIndexPage();
    }
}
