package Entitati;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.TemporalType.DATE;
import javax.persistence.Temporal;

@Entity
@Table(name = "book_transaction", schema = "public", catalog = "library" )
public class BookTransaction {
    @Id
    private Integer id;
    @Column(name="quantity", length = 10)
    private Double quantity;
    @Column(name = "transaction_date")
    @Temporal(DATE)
    private Date transactionDate;
    @Column(name = "due_date")
    @Temporal(DATE)
    private Date dueDate;
    @Column(name="returned_date")
    @Temporal(DATE)
    private Date returnedDate;
    @Column(name="status_book")
    private String statusBook;
    @ManyToOne
    private StudentDetails studentDetails;
    @ManyToOne
    private BookDetails bookDetails;
    @ManyToOne
    private OrderBooks order;

    public BookTransaction() {
    }

    public BookTransaction(Integer id, Double quantity, Date transactionDate, Date dueDate, Date returnedDate, String statusBook) {
        this.id = id;
        this.quantity = quantity;
        this.transactionDate = transactionDate;
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
        this.statusBook = statusBook;
    }

    public BookTransaction(Integer id, Double quantity, Date transactionDate, String statusBook) {
        this.id = id;
        this.quantity = quantity;
        this.transactionDate = transactionDate;
        this.statusBook = statusBook;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getStatusBook() {
        return statusBook;
    }

    public void setStatusBook(String statusBook) {
        this.statusBook = statusBook;
    }

    public StudentDetails getTransactionBooks() {
        return studentDetails;
    }

    public void setTransactionBooks(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    public BookDetails getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDetails bookDetails) {
        this.bookDetails = bookDetails;
    }

    public OrderBooks getOrder() {
        return order;
    }

    public void setOrder(OrderBooks order) {
        this.order = order;
    }

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookTransaction that = (BookTransaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BookTransaction{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", transactionDate=" + transactionDate +
                ", dueDate=" + dueDate +
                ", returnedDate=" + returnedDate +
                ", statusBook='" + statusBook + '\'' +
                '}';
    }
}
