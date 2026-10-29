
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        // Read servlet-specific parameter
        String department = getServletConfig()
                           .getInitParameter("department");

        // Read application-wide parameter
        String college = getServletContext()
                         .getInitParameter("collegeName");

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Servlet Parameters</title></head><body>");
        out.println("<h2>Servlet Initialization Parameters</h2>");
        out.println("<p>Department: " + department + "</p>");
        out.println("<p>College: " + college + "</p>");
        out.println("</body></html>");
    }
}
    