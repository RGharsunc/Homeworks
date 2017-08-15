package manager;

import db.DBConnectionProvider;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserManager {


    private DBConnectionProvider provider;
    private Connection connection;

    public UserManager() {
        provider = DBConnectionProvider.getInstance();
        connection = provider.getConnection();
    }

    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO user(`name`," +
                "`surename`,`age`,`email`, `password`)" +
                " VALUES('" + user.getName() + "','"
                + user.getSurname() + "'," + user.getAge() + ",'"
                + user.getEmail() + "','" +
                user.getPassword() + "')";

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);

    }


    public List<User> selectUser() throws SQLException {
        List<User> alUs = new ArrayList<>();

        String query = "select * from `user` ";
        Statement statment = connection.createStatement();
        ResultSet rs = statment.executeQuery(query);
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surename"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setAge(rs.getInt("age"));
            alUs.add(user);
        }
        return alUs;
    }

    public void removeUserById(User user) throws SQLException {


        String query = "DELETE FROM `user` WHERE id>10";
        Statement st = connection.createStatement();
        st.executeUpdate(query);


        query = "select * from `user` where id<15";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);


    }

    public void updateUserData(String name, String surename, String password, String email, int age, int id) throws SQLException {

        String query = "update `user` set `name`='" + name + "',`surename`='" + surename + "',`password`='" + password + "',`email`='" + email + "',`age`=" + age + " where id=" + id;
        Statement st = connection.createStatement();
        st.executeUpdate(query);


    }
}



