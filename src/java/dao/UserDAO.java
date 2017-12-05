package dao;

import entity.Entity;
import entity.User;


public abstract class UserDAO extends AbstractDAO<Object, Entity>{

    /**
     * Delete list of users from database
     *
     * @param userInputList users to delete
     * @return quantity of deleted users
     */
    public abstract int deleteUsers(Iterable<User> userInputList);

    /**
     * Activates list of user in database
     *
     * @param userInputList users to activate
     * @return quantity of activated users
     */
    public abstract int activateUsers(Iterable<User> userInputList);

    /**
     * Find list of users that are waiting for confirmation
     *
     * @return list of unconfirmed users
     */
    public abstract Iterable<User> findUnconfirmedUsers();

    /**
     * Adds user into database
     *
     * @param inpUser user to insert
     * @return 1 if success, -1 if error was occurred
     */
    public abstract int insertUser(User inpUser);

    /**
     * Finds user into database by email and password
     *
     * @param inpUser user object with email and password
     * @return user obj with all additional information added
     */
    public abstract User findUser(User inpUser);
}
