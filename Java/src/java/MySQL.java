
import Bean.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySQL {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "123";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    
    public MySQL(){
        
    }
    
    private static Connection initialize() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER_CLASS);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static boolean register(User user) throws ClassNotFoundException, SQLException{
        Connection connection = initialize();
        connection.setAutoCommit(false);
        PreparedStatement confirmNickname = connection.prepareStatement("SELECT COUNT(*) FROM User WHERE nickname = ?");
        PreparedStatement addUser = connection.prepareStatement("INSERT INTO User(firstname, lastname, middlename, nickname, password) "
                + "VALUES (?, ?, ?, ?, ?)");
        confirmNickname.setString(1, user.getNickname());
        ResultSet rs = confirmNickname.executeQuery();
        int count = rs.getInt(0);
        /* If there is a user using this nickname, registration failed */
        if(count > 0){
            confirmNickname.close();
            addUser.close();
            connection.close();
            throw new SQLException();
        }
        
        count = addUser.executeUpdate();
        /* If no row inserted, execution failed */
        if(count == 0){
            confirmNickname.close();
            addUser.close();
            connection.close();
            throw new SQLException();
        }
        confirmNickname.close();
        addUser.close();
        connection.close();
    }
}
