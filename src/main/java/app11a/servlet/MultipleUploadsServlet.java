package app11a.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * Created by CJ on 2017/11/12.
 */

@WebServlet(urlPatterns = {"/multipleUploads"})
public class MultipleUploadsServlet extends HttpServlet {
    private static final long serialVersionUID = 9991L;
    private String getFilename(Part part){
        String contentDispositionHeader = part.getHeader("content-disposition");
        String[] elements = contentDispositionHeader.split(";");
        for (String element:elements){
            if(element.trim().startsWith("filename")){
                return element.substring(element.indexOf('=')+1).trim().replace("\"","");
            }
        }
        return null;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Collection<Part> parts = request.getParts();
        for (Part part:parts){
            if (part.getContentType() != null){
                String filename = getFilename(part);
                if (filename!=null && !filename.isEmpty()){
                    part.write(getServletContext().getRealPath("/WEB-INF"+"/"+filename));
                    writer.print("<br>Upload file name:"+filename);
                    writer.print("<br>Size:"+part.getSize());
                }
            }else {
                String partname = part.getName();
                String fieldValue = request.getParameter(partname);
                writer.print("<br/>"+partname+":"+fieldValue);
            }
        }
    }
}