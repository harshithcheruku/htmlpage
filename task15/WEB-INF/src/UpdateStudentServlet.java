
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String idText = request.getParameter("id");
        String name = request.getParameter("name");

        try {
            int id = Integer.parseInt(idText);

            if (name == null || name.trim().isEmpty()) {
                out.println("<h3>Name cannot be empty.</h3>");
                return;
            }

            String url = "jdbc:mysql://localhost:3306/college";
            String user = "root";
            String password = "mysql";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                try (Connection con =
                         DriverManager.getConnection(url, user, password);
                     PreparedStatement ps = con.prepareStatement(
                         "UPDATE student SET name = ? WHERE id = ?")) {

                    ps.setString(1, name.trim());
                    ps.setInt(2, id);

                    int rows = ps.executeUpdate();

                    if (rows > 0) {
                        out.println("<h2>Student updated successfully.</h2>");
                    } else {
                        out.println("<h2>No student found with that ID.</h2>");
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new ServletException("Database operation failed.", e);
            }

        } catch (NumberFormatException e) {
            out.println("<h3>Student ID must be a valid number.</h3>");
        }
    }
}
