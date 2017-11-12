package app08a.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CJ on 2017/10/10.
 */
public class AppListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        Map<String,String> countries = new HashMap<String, String>();
        countries.put("ca","Canada");
        countries.put("us","United States");
        servletContext.setAttribute("countries",countries);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
