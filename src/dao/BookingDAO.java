package dao;
import model.Booking;
import java.sql.*;
import java.util.*;

public class BookingDAO {

    public List<Booking> getAllBookings() throws SQLException{
        Connection conn=DBConnection.getConnection();
        List<Booking> list=new ArrayList<>();
        String sql="SELECT * FROM bookings";
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new Booking(rs.getInt("id"),rs.getInt("user_id"),rs.getInt("room_id"),rs.getDate("check_in"),rs.getDate("check_out"),rs.getString("status")));
        }
        conn.close();
        return list;
    }

    public void markAsPaid(int bookingId) throws SQLException{
        Connection conn=DBConnection.getConnection();
        String sql="UPDATE bookings SET status='Paid' WHERE id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,bookingId);
        ps.executeUpdate();
        conn.close();
    }
}
