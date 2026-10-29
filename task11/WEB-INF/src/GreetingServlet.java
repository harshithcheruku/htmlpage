import java.io.*;
import jakarta.servlet.*;

public class GreetingServlet extends GenericServlet{
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        out.println("Hello " + name);
    }
}