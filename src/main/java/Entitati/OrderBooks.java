package Entitati;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import static javax.persistence.TemporalType.DATE;
import javax.persistence.Temporal;

import static javax.persistence.TemporalType.DATE;

@Entity
@Table(name = "order", schema = "public", catalog = "library" )
public class OrderBooks {
    @Id
    private Integer id;
    @Column(name = "date_order")
    @Temporal(DATE)
    private Date dateOrder;
    @OneToMany(mappedBy = "orderBook", cascade = CascadeType.ALL)
    private List<BookDetails> books=new ArrayList<>();
    @ManyToOne
    private StudentDetails studentDetails;
    @ManyToOne
    private UserDetails userDetails;

    public OrderBooks(Integer id, Date dateOrder) {
        this.id = id;
        this.dateOrder = dateOrder;
    }

    public OrderBooks() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public List<BookDetails> getBooks() {
        return books;
    }

    public void setBooks(List<BookDetails> books) {
        this.books = books;
    }

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderBooks that = (OrderBooks) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrderBooks{" +
                "id=" + id +
                ", dateOrder=" + dateOrder +
                '}';
    }
}
