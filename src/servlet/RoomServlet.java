package servlet;
import dao.RoomDAO;
import model.Room;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String action=request.getParameter("action");
        RoomDAO dao=new RoomDAO();
        try{
            if("add".equals(action)){
                int number=Integer.parseInt(request.getParameter("roomNumber"));
                String type=request.getParameter("type");
                double price=Double.parseDouble(request.getParameter("price"));
                dao.addRoom(new Room(0,number,type,price,true));
            } else if("delete".equals(action)){
                int id=Integer.parseInt(request.getParameter("roomId"));
                dao.deleteRoom(id);
            }
        } catch(SQLException e){e.printStackTrace();}
        response.sendRedirect("admin.jsp");
    }
}
