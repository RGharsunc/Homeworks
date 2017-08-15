package main;

import manager.UserManager;
import model.User;

import java.sql.SQLException;

public class FirstExample {


    public static void main(String[] args) throws SQLException {
        UserManager userManager = new UserManager();
        User user = new User();
        user.setName("valod");
        user.setSurname("valod");
        user.setAge(12);
        user.setEmail("valod");
        user.setPassword("valod");

        userManager.addUser(user);

        userManager.removeUserById(user);


        System.out.println(userManager.selectUser());
        userManager.updateUserData("savo","davojan","sfdgs","@dfbhdb",20,9);
        System.out.println(userManager.selectUser());
    }

}