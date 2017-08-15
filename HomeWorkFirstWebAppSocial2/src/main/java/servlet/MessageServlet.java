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
import java.util.List;

/**
 * Created by Vardan on 03.07.2017.
 */
public class MessageServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        MessageManager messageManager=new MessageManager();
        try {
            List<Message> messages=messageManager.getMessageByUserId(user);
            req.setAttribute("messagesOfCurrentUser",messages);
            req.getRequestDispatcher("/message.jsp").forward(req, resp);



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
