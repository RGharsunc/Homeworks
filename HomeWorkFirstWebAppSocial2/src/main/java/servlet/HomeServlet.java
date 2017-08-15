package servlet;

import manager.UserManager;
import model.User;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vardan on 02.07.2017.
 */
public class HomeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        UserManager userManager = new UserManager();

        try {
            List<User> usersList=userManager.getUsersList();
            List<User> usersFriendList=userManager.getCurrentUsersFriendList(user);
                req.setAttribute("usersList",usersList);
                req.setAttribute("usersFriendList",usersFriendList);
                req.getRequestDispatcher("/home.jsp").forward(req, resp);



        } catch (SQLException e) {

        }


    }
}
