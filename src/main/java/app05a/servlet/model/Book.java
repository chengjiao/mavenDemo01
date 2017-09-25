package app05a.servlet.model;

/**
 * Created by CJ on 2017/9/25.
 */
public class Book {
    private String isbn;
    private String title;
    private double price;
    public Book(String isbn,String title,double price){
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }


}
