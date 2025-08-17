package servlet;
import dao.BookingDAO;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ProcessPaymentServlet")
public class ProcessPaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        int bookingId=Integer.parseInt(request.getParameter("bookingId"));
        BookingDAO dao=new BookingDAO();
        try{ dao.markAsPaid(bookingId); } catch(SQLException e){ e.printStackTrace(); }
        response.sendRedirect("bookings.jsp");
    }
}
