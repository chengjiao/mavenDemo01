package app02d;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

@WebServlet(name = "CookieInfoServlet",urlPatterns = "/cookieInfo")
public class CookieInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 3829L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServerException,IOException{
        Cookie[] cookies = request.getCookies();
        StringBuilder styles = new StringBuilder();
        styles.append(".title{");
        if(cookies != null){
            for (Cookie cookie:cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                if (name.equals("titleFontSize")){
                    styles.append("font-size:"+value+";");
                }else if(name.equals("titleFontWeight")){
                    styles.append("font-weight:"+value+";");
                }else if (name.equals("titleFontStyle")){
                    styles.append("font-style:"+value+";");
                }
            }
          styles.append("}");
          response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("<html>" + "<head>" + "<title>Cookie Info</title>"
                    +"<style>"+styles.toString()+"</style></head><body>"
                    +PreferenceServlet.MENU
                    +"<div class='title'>"
                    +"Session Management with Cookies:</div>");
        }
    }
}
