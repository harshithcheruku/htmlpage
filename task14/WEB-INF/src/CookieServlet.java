import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class CookieServlet extends HttpServlet{
    public void CreateCookie(HttpServletResponse res){
    Cookie c1 = new Cookie("user1", "pwd1");
    Cookie c2 = new Cookie("user2", "pwd2");    
    Cookie c3 = new Cookie("user3", "pwd3");
    Cookie c4 = new Cookie("user4", "pwd4");
    c1.setMaxAge(3600);
    c2.setMaxAge(3600);
    c3.setMaxAge(3600);
    c4.setMaxAge(3600);
    res.addCookie(c1);
    res.addCookie(c2);
    res.addCookie(c3);  
    res.addCookie(c4);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        CreateCookie(res);
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        boolean valid = false;
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie c : cookies){
                if(c.getName().equals(user) && c.getValue().equals(pwd)){
                    valid = true;
                    break;
                }
            }
        }
        PrintWriter out = res.getWriter();
        if(valid){
            out.println("<h1>Welcome " + user + "</h1>");
        } else {
            out.println("<h1>Invalid user or password</h1>");
        }
}
}