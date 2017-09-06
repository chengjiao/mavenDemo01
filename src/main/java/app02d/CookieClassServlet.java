package app02d;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "CookieClassServlet",urlPatterns = "/cookieClass")
public class CookieClassServlet extends HttpServlet {
    private static final long serialVersionUID = 837369L;
    private String[] methods = {"clone","getComment","getDomain","getMaxAge",
    "getName","getPath","getSecure","getValue","getVersio","isHttpOnly",
    "setComment","setDomain","setHttpOnly","setMaxAge","setPath","setSecure","setVlaue","setVersion"};

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        Cookie[] cookies = request.getCookies();
        Cookie maxRecordsCookie = null;
        if(cookies != null){
            for(Cookie cookie:cookies){
                if (cookie.getName().equals("maxRecords")){
                    maxRecordsCookie = cookie;
                    break;
                }
            }
        }
        int maxRecords = 10;
        if(maxRecordsCookie != null){
            try {
                maxRecords = Integer.parseInt(maxRecordsCookie.getValue());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head>"+"<title>Cookie Class</title>"
                +"</head></body>"+PreferenceServlet.MENU
                +"<div>Here are some of the methods in"
                +"javax.servlet.http.Cookie");
        writer.println("<ul>");
        for(int i=0;i<maxRecords;i++){
            writer.println("<li>"+methods[i]+"<li>");
        }
        writer.println("</ul>");
        writer.println("</div></body></html>");
    }
}
