package commands;


public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    REGISTER {
        {
            this.command = new RegisterCommand();
        }
    },
    FIND_UNCONFIRMED {
        {
            this.command = new FindUnconfirmed();
        }
    },
    UPDATE_USERS {
        {
            this.command = new UpdateUsersCommand();
        }
    },
    FIND_ROUTES {
        {
            this.command = new FindRoutesCommand();
        }
    },
    CREATE_INVOICE {
        {
            this.command = new CreateInvoiceCommand();

        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

}
