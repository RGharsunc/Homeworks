package manager;

import db.DBConnectionProvider;
import model.User;

import java.sql.*;


public class UserManager {

    private DBConnectionProvider provider;
    private Connection connection;

    public UserManager() {
        provider = DBConnectionProvider.getInstance();
        connection = provider.getConnection();
    }

    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO `user`(`name`,`surname`,`age`,`username`,`password`) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement =
                connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setInt(3, user.getAge());
        preparedStatement.setString(4, user.getUsername());
        preparedStatement.setString(5, user.getPassword());

        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            user.setId(generatedKeys.getLong(1));
        }
    }

    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        User user = null;
        String query = "Select * from `user` where `username` = ? and `password` = ?";
        PreparedStatement preparedStatement =
                connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getLong(1));
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString(3));
            user.setAge(resultSet.getInt(4));
            user.setUsername(resultSet.getString(5));
            user.setPassword(resultSet.getString(6));
        }
        return user;
    }

}
