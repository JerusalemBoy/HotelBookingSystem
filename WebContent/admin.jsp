<%@ page import="dao.RoomDAO, model.Room, java.util.List" %>
<%@ page session="true" %>
<%
    // Check if admin is logged in
    Object userObj = session.getAttribute("user");
    if (userObj == null || !((model.User)userObj).getRole().equals("admin")) {
        response.sendRedirect("login.jsp");
        return;
    }

    RoomDAO roomDao = new RoomDAO();
    List<Room> rooms = roomDao.getAllRooms();
%>
<html>
<head>
    <title>Admin Panel - Hotel Booking System</title>
</head>
<body>
<h1>Admin Panel</h1>

<h2>Add Room</h2>
<form action="RoomServlet" method="post">
    <input type="hidden" name="action" value="add">
    Room Number: <input type="number" name="roomNumber" required><br>
    Type: <input type="text" name="type" required><br>
    Price: <input type="number" step="0.01" name="price" required><br>
    <button type="submit">Add Room</button>
</form>

<h2>All Rooms</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Room Number</th>
        <th>Type</th>
        <th>Price</th>
        <th>Available</th>
        <th>Action</th>
    </tr>
    <%
        for(Room r : rooms){
    %>
    <tr>
        <td><%= r.getId() %></td>
        <td><%= r.getRoomNumber() %></td>
        <td><%= r.getType() %></td>
        <td>$<%= r.getPrice() %></td>
        <td><%= r.isAvailable() ? "Yes" : "No" %></td>
        <td>
            <form action="RoomServlet" method="post" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="roomId" value="<%= r.getId() %>">
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>

<a href="logout.jsp">Logout</a>
</body>
</html>
