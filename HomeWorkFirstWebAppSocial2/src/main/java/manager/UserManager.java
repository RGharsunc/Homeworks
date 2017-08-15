package manager;

import db.DBConnectionProvider;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vardan on 27.06.2017.
 */
public class UserManager {
    private DBConnectionProvider provider;
    private Connection connection;

    public UserManager() {
        provider = DBConnectionProvider.getInstance();
        connection = provider.getConnection();
    }


    public void addUser(User user) throws SQLException {
        String query = "insert into `user`(`name`,`surname`,`email`," +
                "`age`,`username`,`password`) values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(
                query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setLong(4, user.getAge());
        preparedStatement.setString(5, user.getUsername());
        preparedStatement.setString(6, user.getPassword());

        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            user.setId(generatedKeys.getLong(1));
        }

    }

    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        String query = "select*from `user` where `username`=? and `password`=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        User user = null;
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getLong(1));
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
            user.setAge(resultSet.getLong(5));
            user.setUsername(resultSet.getString(6));
            user.setPassword(resultSet.getString(7));
        }
        return user;

    }

    public List<User> getUsersList() throws SQLException {
        String query = "select*from user";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<User> users = new ArrayList<User>();

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setEmail(rs.getString("email"));
            user.setAge(rs.getLong("age"));
            user.setUsername(rs.getString("username"));
            users.add(user);
        }
        return users;
    }

    public void addUserToFriendsListForCurrentUser(long id, User currentUser) throws SQLException {
        String query = "Insert into `friend_list` (`user_id`,`friend_id`)  values('" + currentUser.getId() + "','" + id + "')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public boolean isUserExistsInFriendsList(long id) throws SQLException {
        String query = "select `friend_id` from `friend_list` where `friend_id`='" + id + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        boolean b = false;
        while (resultSet.next() && resultSet.getLong("friend_id") == id) {

            b = true;
            break;


        }
        return b;

    }


    public List<Long> getUsersFriendIdFromFriendList(long id) throws SQLException {
        String query = "select `friend_id` from `friend_list` where `user_id`='" + id + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Long> friend_idList =new ArrayList<Long>();
        while (resultSet.next()) {
            long friend_id = 0;
            friend_id = resultSet.getLong("friend_id");

            friend_idList.add(friend_id);
        }
        return friend_idList;
    }

    public List<User> getCurrentUsersFriendList(User currentUser) throws SQLException {
        List<Long> friendsIdList = getUsersFriendIdFromFriendList(currentUser.getId());
      List<User> friendsList=new ArrayList<User>();
        for (Long id : friendsIdList) {
           friendsList.add(getUserById(id));
        }
        return friendsList;

    }

    public User getUserById(long userId) throws SQLException {
        String query = "select*from `user` where `id`='" + userId + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        User user = new User();
        if (resultSet.next()) {
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setEmail(resultSet.getString("email"));
            user.setAge(resultSet.getLong("age"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));

        }
        return user;
    }

}
