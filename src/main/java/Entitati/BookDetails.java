package Entitati;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "book_details", schema = "public", catalog = "library" )
public class BookDetails {
    @Id
    @Column(name="book_id")
    private Integer id;
    @Column(name="author_name", length = 100)
    private String authorName;
    @Column(name="book_name", length = 100)
    private String bookName;
    @Column(name="book_price", length = 10)
    private Double price;
    @Column(name="isbn_number_book", length = 50)
    private String bookNumber;
    @Column(name="status_book", length = 20)
    private String status;

    @ManyToOne
    private OrderBooks orderBook;

    public BookDetails() {}

    public BookDetails(Integer id, String authorName, String bookName, Double price, String bookNumber, String status) {
        this.id = id;
        this.authorName = authorName;
        this.bookName = bookName;
        this.price = price;
        this.bookNumber = bookNumber;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDetails that = (BookDetails) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BookDetails{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", bookNumber='" + bookNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
