package servlet;

import manager.UserManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserManager userManager = new UserManager();
        try {
            User user = userManager.getUserByUsernameAndPassword(username, password);
            if (user != null) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/home.jsp");
            } else {
                req.getSession().setAttribute("message", "Incorrect Username or password");
                resp.sendRedirect("/login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
