package app05a.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CJ on 2017/9/25.
 */
public class BooksServlet extends HttpServlet{
    private static final int serialVersionUID = -234237;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        List<Book> books = new ArrayList<Book>();
        Book book1 = new Book();
    }
}
