package app08a.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Created by CJ on 2017/10/10.
 */
public class Product implements HttpSessionBindingListener{
    private String id;
    private String name;
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        String attributeName = httpSessionBindingEvent.getName();
        System.out.println(attributeName+" valueBound");
    }

    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        String attributeName = httpSessionBindingEvent.getName();
        System.out.println(attributeName+" valueUnbound");
    }
}
