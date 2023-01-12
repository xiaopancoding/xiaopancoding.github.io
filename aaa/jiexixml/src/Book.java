import java.math.BigDecimal;

public class Book {
    private String sn;
    private String name;
    private String author;
    private String price;

    public Book() {}

    public Book(String sn, String name, String author, String price) {
        this.sn = sn;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getSn() {
        return sn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrice() {
        return price;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
