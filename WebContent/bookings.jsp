<%@ page import="dao.BookingDAO, dao.RoomDAO, model.Booking, model.Room, java.util.List" %>
<%@ page session="true" %>
<%
    Object userObj = session.getAttribute("user");
    if(userObj == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    int userId = ((model.User)userObj).getId();
    BookingDAO bookingDao = new BookingDAO();
    RoomDAO roomDao = new RoomDAO();
    List<Booking> allBookings = bookingDao.getAllBookings();
%>
<html>
<head>
    <title>My Bookings - Hotel Booking System</title>
</head>
<body>
<h1>My Bookings</h1>
<table border="1">
    <tr>
        <th>Booking ID</th>
        <th>Room Number</th>
        <th>Type</th>
        <th>Price</th>
        <th>Check-In</th>
        <th>Check-Out</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <%
        for(Booking b : allBookings){
            if(b.getUserId() == userId){
                Room room = roomDao.getAllRooms().stream().filter(r -> r.getId() == b.getRoomId()).findFirst().orElse(null);
    %>
    <tr>
        <td><%= b.getId() %></td>
        <td><%= room != null ? room.getRoomNumber() : "N/A" %></td>
        <td><%= room != null ? room.getType() : "N/A" %></td>
        <td>$<%= room != null ? room.getPrice() : 0 %></td>
        <td><%= b.getCheckIn() %></td>
        <td><%= b.getCheckOut() %></td>
        <td><%= b.getStatus() %></td>
        <td>
            <%
                if(!b.getStatus().equals("Paid")){
            %>
            <form action="ProcessPaymentServlet" method="post">
                <input type="hidden" name="bookingId" value="<%= b.getId() %>">
                <button type="submit">Pay</button>
            </form>
            <%
                } else {
                    out.print("Paid");
                }
            %>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
<a href="logout.jsp">Logout</a>
</body>
</html>
