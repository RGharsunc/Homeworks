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


public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserManager userManager = new UserManager();
        try {
            User user = userManager.getUserByUsernameAndPassword(username, password);
            List<User> users = userManager.getUsersList();
            if (user != null) {
                List<User> usersFriendList = userManager.getCurrentUsersFriendList(user);
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/homeServlet");
            } else {
                req.getSession().setAttribute("message", "Incorrect Username or password");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
