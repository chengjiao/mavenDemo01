package app04a.model.servlet;

import app04a.model.Address;
import app04a.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CJ on 2017/9/7.
 */
@WebServlet(urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet{
    private static final int serialVersionUID = -5392874;
    public void goGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        Address address = new Address();
        address.setStreetName("Rue D'Aniouo");
        address.setStreetNumber("5090B");
        address.setCity("Brossard");
        address.setState("Quebec");
        address.setZipCode("A1A B2B");
        address.setCountry("Canada");

        Employee employee = new Employee();
        employee.setAddress(address);
        employee.setId(1099);
        employee.setName("Charles Unjeye");

        request.setAttribute("employee",employee);
        Map<String,String> capitals = new HashMap<String, String>();
        capitals.put("China","Beijing");
        capitals.put("Austria","Vienna");
        capitals.put("Australia","Canberra");
        capitals.put("Canada","Ottawa");
        request.setAttribute("capitals",capitals);

        RequestDispatcher rd = request.getRequestDispatcher("/employee.jsp");
        rd.forward(request,response);
    }
}
