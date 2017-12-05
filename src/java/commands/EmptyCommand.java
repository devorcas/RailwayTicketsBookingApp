package commands;

import controller.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;


public class EmptyCommand extends ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        return ConfigurationManager.getIndexPage();
    }
}
