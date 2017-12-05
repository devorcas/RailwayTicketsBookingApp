package commands;

import access.AccessType;
import controller.ConfigurationManager;
import controller.MessageManager;
import entity.User;
import javax.servlet.http.HttpServletRequest;


public class LoginCommand extends ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        // getting values from the reqiest
        String email = request.getParameter(EMAIL_PAR_NAME);
        String pass = request.getParameter(PASSWORD_PAR_NAME);

        User inpUser = new User();

        inpUser.setEmail(email);
        inpUser.setPassword(pass);

        User user = DAO_FACTORY.getUserDAO().findUser(inpUser);

        //login and pass check
        if (user.getPassword() != null && user.getPassword().equals(pass) && user.getName().equals(ADMIN_LOGIN)) {
            request.getSession().setAttribute(USER_PAR_NAME, user);
            request.getSession().setAttribute(USER_TYPE_PAR_NAME, AccessType.ADMIN.getContent());

            new FindUnconfirmed().execute(request);
            page = ConfigurationManager.getAdminPage();
        } else if (user.getPassword() != null && user.getPassword().equals(pass)) {
            request.getSession().setAttribute(USER_PAR_NAME, user);
            request.getSession().setAttribute(USER_TYPE_PAR_NAME, AccessType.USER.getContent());
            page = ConfigurationManager.getMainPage();
        } else {
            request.setAttribute(ERROR_LOGINPASS_MSG_ATT_NAME, MessageManager.getLoginErrorMsg());
            page = ConfigurationManager.getIndexPage();
        }
        return page;
    }

}
