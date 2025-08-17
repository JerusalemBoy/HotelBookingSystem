package servlet;
import dao.UserDAO;
import model.User;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        UserDAO dao=new UserDAO();
        try{
            if("register".equals(action)){
                String username=request.getParameter("username");
                String password=request.getParameter("password");
                User user=new User(0,username,password,"user");
                dao.registerUser(user);
                response.sendRedirect("login.jsp");
            } else if("login".equals(action)){
                String username=request.getParameter("username");
                String password=request.getParameter("password");
                User user=dao.loginUser(username,password);
                if(user!=null){
                    HttpSession session=request.getSession();
                    session.setAttribute("user",user);
                    if("admin".equals(user.getRole())) response.sendRedirect("admin.jsp");
                    else response.sendRedirect("bookings.jsp");
                } else response.sendRedirect("login.jsp");
            }
        } catch (SQLException e){ e.printStackTrace(); }
    }
}
