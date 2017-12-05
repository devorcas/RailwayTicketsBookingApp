package commands;

import access.AccessType;
import controller.ConfigurationManager;
import controller.MessageManager;
import dao.AbstractDAOFactory;
import entity.User;
import javax.servlet.http.HttpServletRequest;


public class RegisterCommand extends ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        User newUser = new User();
        String email = request.getParameter(PARAM_EMAIL);
        newUser.setEmail(email);
        newUser.setPassword(request.getParameter(PARAM_PASSWORD));
        newUser.setName(request.getParameter(PARAM_NAME));
        newUser.setSurname(request.getParameter(PARAM_SURNAME));
        newUser.setPhone(request.getParameter(PARAM_PHONE));

        int result = DAO_FACTORY.getUserDAO().insertUser(newUser);
        if (result == 1) {
            request.getSession().setAttribute(USER_PAR_NAME, newUser);
            request.getSession().removeAttribute(USER_TYPE_PAR_NAME);
            request.getSession().setAttribute(USER_TYPE_PAR_NAME, AccessType.USER.getContent());
        } else {
            request.setAttribute(ERROR_REGISTER_MESSAGE_ATT_NAME, MessageManager.getRegisterErrorMsg());
        }
        return ConfigurationManager.getMainPage();
    }

}
