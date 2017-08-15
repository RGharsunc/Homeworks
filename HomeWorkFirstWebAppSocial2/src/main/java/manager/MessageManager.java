package manager;

import db.DBConnectionProvider;
import model.Message;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vardan on 03.07.2017.
 */
public class MessageManager {
    private DBConnectionProvider provider;
    private Connection connection;
    public MessageManager() {
        provider = DBConnectionProvider.getInstance();
        connection = provider.getConnection();
    }

    public void addMessage(Message message) throws SQLException {
        String query="insert into `message`(`from_user_id`,`to_user_id`,`message`) values(?,?,?) ";
        PreparedStatement preparedStatement=connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setLong(1,message.getFromUserId());
        preparedStatement.setLong(2,message.getToUserId());
        preparedStatement.setString(3,message.getDescription());

        preparedStatement.executeUpdate();
        ResultSet generatedKeys=preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()){
            message.setId(generatedKeys.getLong(1));
        }
    }

    public List<Message> getMessageByUserId(User user) throws SQLException {
        String query="select*from message where to_user_id='"+user.getId()+"'";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(query);
        List<Message> messages=new ArrayList<Message>();
        Message message=null;
        while (resultSet.next()){
            message=new Message();
            message.setId(resultSet.getLong("id"));
            message.setFromUserId(resultSet.getLong("from_user_id"));
            message.setToUserId(resultSet.getLong("to_user_id"));
            message.setDescription(resultSet.getString("message"));
            message.setTimeStamp(resultSet.getString("created_time"));
            messages.add(message);
        }
        return  messages;
    }


}
