package dao;
import model.Room;
import java.sql.*;
import java.util.*;

public class RoomDAO {

    public List<Room> getAllRooms() throws SQLException{
        Connection conn=DBConnection.getConnection();
        List<Room> list=new ArrayList<>();
        String sql="SELECT * FROM rooms";
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new Room(rs.getInt("id"), rs.getInt("room_number"), rs.getString("type"), rs.getDouble("price"), rs.getBoolean("is_available")));
        }
        conn.close();
        return list;
    }

    public void addRoom(Room room) throws SQLException{
        Connection conn=DBConnection.getConnection();
        String sql="INSERT INTO rooms(room_number,type,price,is_available) VALUES(?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,room.getRoomNumber());
        ps.setString(2,room.getType());
        ps.setDouble(3,room.getPrice());
        ps.setBoolean(4,room.isAvailable());
        ps.executeUpdate();
        conn.close();
    }

    public void deleteRoom(int roomId) throws SQLException{
        Connection conn=DBConnection.getConnection();
        String sql="DELETE FROM rooms WHERE id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,roomId);
        ps.executeUpdate();
        conn.close();
    }
}
