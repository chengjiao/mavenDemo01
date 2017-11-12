package app11a.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by CJ on 2017/11/12.
 */
@WebServlet(urlPatterns = {"/singleUpload"})
@MultipartConfig
public class SingleUploadServlet extends HttpServlet{
    private static final long serialVersionUID = 8593039L;
    private String getFilename(Part part){
        String contentDispositionHeader = part.getHeader("content-disposition");
        String[] elements = contentDispositionHeader.split(";");
        for (String element:elements){
            if (element.trim().startsWith("filename")){
                return element.substring(element.indexOf('='+1)).trim().replace("\"","");
            }
        }
        return null;
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        //save upload file to WEB_INF
        Part part = request.getPart("filename");
        String filename = getFilename(part);

        if(filename != null && !filename.isEmpty()){
            part.write(getServletContext().getRealPath("/WEB-INF")+"/"+filename);
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.print("<br/>Upload file name:"+filename);
            writer.print("<br />Size:"+part.getSize());
            String author = request.getParameter("author");
            writer.print("<br/>Author:"+author);
        }
    }
}
