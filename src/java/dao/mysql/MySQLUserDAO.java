package dao.mysql;

import dao.AbstractDAO;
import dao.UserDAO;
import database.MySQLConnectionManager;
import entity.Entity;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQLUserDAO extends UserDAO {

    /**
     * Queries
     */
    private static final String insertUserStr = "INSERT INTO users (email, password, firstName, surname, phone) values (?, ?, ?, ?, ?)";
    private static final String findUserStr = "SELECT * FROM users WHERE email =? ";
    private static final String findUnconfirmedUserStr = "SELECT * FROM users WHERE isActivated = 0";
    private static final String activateUsersStr = "UPDATE users SET isActivated = 1 WHERE id = ?";
    private static final String deleteUsersSrt = "DELETE FROM users WHERE id = ?";

    @Override
    public int deleteUsers(Iterable<User> userInputList) {
        if (userInputList != null) {
            try {
                connection = MySQLConnectionManager.getInstance().getConnection();
                preparedStatement = connection.prepareStatement(deleteUsersSrt);

                for (User user : userInputList) {
                    preparedStatement.setInt(1, user.getId());
                    preparedStatement.addBatch();
                }

                int[] resultBatchArr = preparedStatement.executeBatch();
                int countSuxessBatch = 0;
                for (int i = 0; i < resultBatchArr.length; i++) {
                    if (resultBatchArr[i] == 0) {
                        System.out.println("log to Delete command #" + i + "failed: ");
                    }
                    countSuxessBatch += resultBatchArr[i];
                }
                return countSuxessBatch;

            } catch (SQLException ex) {
                Logger.getLogger(MySQLUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                close(resultSet);
                close(preparedStatement);
                close(connection);
            }
        }
        return -1;
    }

    @Override
    public int activateUsers(Iterable<User> userInputList) {
        if (userInputList != null) {
            try {
                connection = MySQLConnectionManager.getInstance().getConnection();
                preparedStatement = connection.prepareStatement(activateUsersStr);

                for (User user : userInputList) {
                    preparedStatement.setInt(1, user.getId());
                    preparedStatement.addBatch();
                }

                int[] resultBatchArr = preparedStatement.executeBatch();
                int countSuxessBatch = 0;

                for (int i = 0; i < resultBatchArr.length; i++) {
                    if (resultBatchArr[i] == 0) {
                        System.out.println("log to Activate command #" + i + "failed: ");
                    }
                    countSuxessBatch += resultBatchArr[i];
                }

                return countSuxessBatch;

            } catch (SQLException ex) {
                Logger.getLogger(MySQLUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                close(resultSet);
                close(preparedStatement);
                close(connection);
            }
        }
        return -1;
    }

    @Override
    public Iterable<User> findUnconfirmedUsers() {
        try {
            connection = MySQLConnectionManager.getInstance().getConnection();
            preparedStatement = connection.prepareCall(findUnconfirmedUserStr);
            resultSet = preparedStatement.executeQuery();
            List<User> userList = null;
            User resUser = null;
            while (resultSet.next()) {
                if (userList == null) {
                    userList = new ArrayList<>();

                }
                resUser = new User();
                resUser.setEmail(resultSet.getString(DBColNames.EMAIL.getContent()));
                resUser.setId(resultSet.getInt(DBColNames.ID.getContent()));
                resUser.setName(resultSet.getString(DBColNames.FIRST_NAME.getContent()));
                resUser.setPassword(resultSet.getString(DBColNames.PASSWORD.getContent()));
                resUser.setPhone(resultSet.getString(DBColNames.PHONE.getContent()));
                resUser.setSurname(resultSet.getString(DBColNames.SURNAME.getContent()));

                userList.add(resUser);
            }
            return userList;

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return null;
    }

    @Override
    public int insertUser(User inpUser) {
        try {
            connection = MySQLConnectionManager.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(insertUserStr);

            preparedStatement.setString(1, inpUser.getEmail());
            preparedStatement.setString(2, inpUser.getPassword());
            preparedStatement.setString(3, inpUser.getName());
            preparedStatement.setString(4, inpUser.getSurname());
            preparedStatement.setString(5, inpUser.getPhone());

            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return -1;
    }

    @Override
    public User findUser(User inpUser) {
        if (inpUser != null) {
            try {
                connection = MySQLConnectionManager.getInstance().getConnection();
                preparedStatement = connection.prepareStatement(findUserStr);

                preparedStatement.setString(1, inpUser.getEmail());
                System.out.println(preparedStatement);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.first()) {
                    User resUser = inpUser;

                    resUser.setEmail(resultSet.getString(DBColNames.EMAIL.getContent()));
                    resUser.setId(resultSet.getInt(DBColNames.ID.getContent()));
                    resUser.setName(resultSet.getString(DBColNames.FIRST_NAME.getContent()));
                    resUser.setPassword(resultSet.getString(DBColNames.PASSWORD.getContent()));
                    resUser.setPhone(resultSet.getString(DBColNames.PHONE.getContent()));
                    resUser.setSurname(resultSet.getString(DBColNames.SURNAME.getContent()));
                    int isActivated = resultSet.getInt(DBColNames.IS_ACTIVATED.getContent());
                    resUser.setIsActivated((isActivated != 0));

                    return resUser;
                }

            } catch (SQLException ex) {
                Logger.getLogger(MySQLUserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                close(resultSet);
                close(preparedStatement);
                close(connection);
            }
        }
        return null;
    }
}
