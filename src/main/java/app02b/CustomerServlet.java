package app02b;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = -20L;
    private List<Customer> customers = new ArrayList<Customer>();
    @Override
    public void init() throws ServletException {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Donald D.");
        customer1.setCity("Miami");
        customers.add(customer1);
        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Mickey M.");
        customer2.setCity("Orlando");
        customers.add(customer2);
    }
    private void sendCustomerList(HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>Customere</title></head>"+"<body><h2>Customer</h2>");
        writer.println("<ul>");
        for (Customer customer:customers){
            writer.println("<li>"+customer.getName()+"("+customer.getCity()+")("+"<a href='editCustomer?id='"+customer.getId()+"'>edit</a>'");
        }
        writer.println("</ul>");
        writer.println("</body></html>");
    }
    private Customer getCustomer(int customerId){
        for (Customer customer:customers){
            if (customer.getId()==customerId){
                return customer;
            }
        }
        return null;
    }
    private void sendEditCustomerForm(HttpServletRequest request,HttpServletResponse response)throws IOException{
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        int customerId = 0;
        customerId = Integer.parseInt(request.getParameter("id"));
        Customer customer = getCustomer(customerId);
        if(customer != null){
            writer.println("<html><head>"+"<title>Edit Customer</title></head>"
                    +"<body><h2>Edit Customer</h2>"
                    +"<form method='post' "
                    +"action='uodateCustomer'");
            writer.println("<input type='hidden' name='id' value='"+customerId+"'/>");
            writer.println("<table>");
            writer.println("<tr><td>Name:</td><td>"
                    +"<input name='name' value='"
                    +customer.getName().replaceAll("'","&#39;")
                    +"'/></td></tr>");
        }
    }
}
