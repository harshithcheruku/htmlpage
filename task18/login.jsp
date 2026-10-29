
<%@ page import="java.sql.*" %>
<%
String message = "";

if ("POST".equalsIgnoreCase(request.getMethod())) {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager.getConnection(
                 "jdbc:mysql://localhost:3306/college",
                 "root", "mysql");
             PreparedStatement ps = con.prepareStatement(
                 "SELECT * FROM users WHERE username=? AND password=?")) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    message = "Login Successful! Welcome " + username;
                } else {
                    message = "Invalid username or password!";
                }
            }
        }
    } catch (Exception e) {
        application.log("Login database error", e);
        message = "Database connection failed. Check the server logs.";
    }
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
</head>
<body>
    <h2>User Login Form</h2>

    <form action="login.jsp" method="post">
        Username:
        <input type="text" name="username" required>
        <br><br>

        Password:
        <input type="password" name="password" required>
        <br><br>

        <input type="submit" value="Login">
    </form>

    <h3><%= message %></h3>
</body>
</html>
