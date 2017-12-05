package controller;

import java.util.ResourceBundle;


public class ConfigurationManager {

    public static final String RESOURCES_CONFIG = "resources.config";
    public static final String PATH_PAGE_ADMIN = "path.page.admin";
    public static final String PATH_PAGE_MAIN = "path.page.main";
    public static final String PATH_PAGE_UNCONFIRMED = "path.page.unconfirmed";
    public static final String PATH_PAGE_INDEX = "path.page.index";
    public static final String PATH_PAGE_ERROR = "path.page.error";
    public static final String PATH_PAGE_INVOICE = "path.page.invoice";
    private final static ResourceBundle resourceBundle
            = ResourceBundle.getBundle(RESOURCES_CONFIG);

    public static String getAdminPage() {
        return getProperty(PATH_PAGE_ADMIN);
    }

    public static String getMainPage() {
        return getProperty(PATH_PAGE_MAIN);
    }

    public static String getUnconfirmedPage() {
        return getProperty(PATH_PAGE_UNCONFIRMED);
    }

    public static String getInvoicePage() {
        return getProperty(PATH_PAGE_INVOICE);
    }

    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

    public static String getIndexPage() {
        return getProperty(PATH_PAGE_INDEX);
    }

    public static String getErrorPage() {
        return getProperty(PATH_PAGE_ERROR);
    }
}
