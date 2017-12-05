package access;

import commands.ActionFactory;
import commands.LoginCommand;
import javax.servlet.http.HttpServletRequest;


public class AccessCkecker {

    /**
     * If un coincidence of command and user role occurs method removes from
     * request command name for future execution.
     *
     * @param request
     */
    public void checkAccess(HttpServletRequest request) {

        String accessTypeValue = (String) request.getSession().getAttribute(LoginCommand.USER_TYPE_PAR_NAME);
        AccessType accessType = AccessType.valueOf(accessTypeValue.toUpperCase());
        String command = request.getParameter(ActionFactory.COMMAND_PAR_NAME);
        if (accessType == null) {
            accessType = AccessType.GUEST;
        }
        switch (accessType) {
            case ADMIN:
                if (AdminRoleEnum.valueOf(command.toUpperCase()) != null) {
                    break;
                }
            case USER:
                if (UserRoleEnum.valueOf(command.toUpperCase()) != null) {
                    break;
                }
            case GUEST:
                if (GuestRoleEnum.valueOf(command.toUpperCase()) != null) {
                    break;
                }
            default:
                request.removeAttribute(command);
                break;
        }
    }
}
