package dao;
import model.User;
import java.sql.*;

public class UserDAO {

    public void registerUser(User user) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql="INSERT INTO users(username,password,role) VALUES(?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,user.getUsername());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getRole());
        ps.executeUpdate();
        conn.close();
    }

    public User loginUser(String username, String password) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql="SELECT * FROM users WHERE username=? AND password=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,username);
        ps.setString(2,password);
        ResultSet rs=ps.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("role"));
        }
        conn.close();
        return user;
    }
}
