package controller;

import java.util.ResourceBundle;


public class MessageManager {

    public static final String SOURCE = "resources.messages";
    public static final String WRONG_ACTION = "message.wrongaction";
    public static final String LOGIN_ERROR = "message.loginerror";
    public static final String REGISTER_ERROR = "message.registererror";

    private MessageManager() {
    }

    public static String getWrongAction() {
        return getProperty(WRONG_ACTION);
    }

    private static final ResourceBundle resourceBundle
            = ResourceBundle.getBundle(SOURCE);

    public static Object getLoginErrorMsg() {
        return getProperty(LOGIN_ERROR);
    }

    public static Object getRegisterErrorMsg() {
        return getProperty(REGISTER_ERROR);
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
