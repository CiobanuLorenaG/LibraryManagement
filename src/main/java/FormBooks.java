
import Entitati.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@ManagedBean
@SessionScoped
public class FormBooks {
    private BookDetails bookDetails;
    private List<BookDetails> bookDetailsList = new ArrayList<BookDetails>();
    EntityManager entityManager;

    public FormBooks() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        entityManager = entityManagerFactory.createEntityManager();
        init();
    }

    private void init() {
        this.bookDetailsList = entityManager.createQuery("select book from BookDetails book", BookDetails.class).getResultList();
        if (!bookDetailsList.isEmpty()) {
            this.bookDetails = this.bookDetailsList.get(0);
        }
    }

    public void previousBook(ActionEvent event) {
        Integer index = this.bookDetailsList.indexOf(this.bookDetails);
        if (index > 0) {
            this.bookDetails = this.bookDetailsList.get(index - 1);
        } else {
            this.bookDetails = this.bookDetailsList.get(0);
        }
    }

    public void nextBook(ActionEvent event) {
        Integer index = this.bookDetailsList.indexOf(this.bookDetails);
        if (index < this.bookDetailsList.size() - 1) {
            this.bookDetails = this.bookDetailsList.get(index + 1);
        } else {
            this.bookDetails = this.bookDetailsList.get(this.bookDetailsList.size() - 1);
        }
    }

    public void addBook(ActionEvent event) {
        this.bookDetails = new BookDetails();
        this.bookDetails.setId(10);
        this.bookDetails.setAuthorName("Kyle Simpson");
        this.bookDetails.setBookName("You don't know JS");
        this.bookDetails.setPrice(150.49);
        this.bookDetails.setBookNumber("63738847484");
        this.bookDetails.setStatus("In stock");
        this.bookDetailsList.add(bookDetails);
    }

    public void saveBook(ActionEvent event) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(this.bookDetails);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.getSuppressed();
        }
    }

    public void deleteBook(ActionEvent event) {
        if (!this.entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.remove(this.bookDetails);
        entityManager.getTransaction().commit();
        this.bookDetailsList.remove(this.bookDetails);
        this.bookDetails = this.bookDetailsList.get(0);
    }

    public void abandonBook(ActionEvent event) {
        entityManager.clear();
        init();
    }

    public Integer getIdBook() {
        return this.bookDetails.getId();
    }

    public void setIdBook(Integer id) {
        Integer index = this.bookDetailsList.indexOf(new BookDetails(id, null, null, null, null, null));
    }

    public BookDetails getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDetails bookDetails) {
        this.bookDetails = bookDetails;
    }

    public List<BookDetails> getBookDetailsList() {
        return bookDetailsList;
    }

    public void setBookDetailsList(List<BookDetails> bookDetailsList) {
        this.bookDetailsList = bookDetailsList;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
