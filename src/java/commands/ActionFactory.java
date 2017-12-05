package commands;

import controller.ConfigurationManager;
import controller.MessageManager;
import javax.servlet.http.HttpServletRequest;


public class ActionFactory {

    public static final String WRONG_ACTION_ATT_NAME = "wrongAction";
    public static final String COMMAND_PAR_NAME = "command";

    /**
     * Method identifies what hidden parameter is passed in HttpServletRequest
     * and returns the concrete action command to execute
     *
     * @param request 
     * @return ActionCommand
     */
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter(COMMAND_PAR_NAME);
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute(WRONG_ACTION_ATT_NAME, action + MessageManager.getWrongAction());
        }
        return current;
    }

}
