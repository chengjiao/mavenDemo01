package appo1c;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by CJ on 2017/8/10.
 */
public class WelcomeServlet extends HttpServlet {
    public static final long serialVersionUID = 27126L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.print("<html><head></head>"+"<body>Welcome</body></html>");
    }

}
