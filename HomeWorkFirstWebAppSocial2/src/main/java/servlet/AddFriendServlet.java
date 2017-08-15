package servlet;


import manager.UserManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Vardan on 28.06.2017.
 */
public class AddFriendServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.valueOf(req.getParameter("ToId"));
        User currentUser = (User) req.getSession().getAttribute("user");
        UserManager userManager=new UserManager();


        try {
            userManager.addUserToFriendsListForCurrentUser(id,currentUser);
            resp.sendRedirect("/homeServlet");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
