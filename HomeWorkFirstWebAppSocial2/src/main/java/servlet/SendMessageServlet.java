package servlet;

import manager.MessageManager;
import model.Message;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Vardan on 29.06.2017.
 */
public class SendMessageServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("ToFriendId"));
        String strMessage = req.getParameter("message");

        User user = (User) req.getSession().getAttribute("user");

        Message message = new Message();
        message.setFromUserId(user.getId());
        message.setToUserId(id);
        message.setDescription(strMessage);

        MessageManager messageManager=new MessageManager();
        try {
            messageManager.addMessage(message);
            resp.sendRedirect("/homeServlet");


        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("/error.jsp");
        }
    }
}
