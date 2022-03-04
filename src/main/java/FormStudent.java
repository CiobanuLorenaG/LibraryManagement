
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

public class FormStudent {
    private StudentDetails studentDetails;
    private List<StudentDetails> studentDetailsList = new ArrayList<StudentDetails>();
    EntityManager entityManager;

    public FormStudent() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        entityManager = entityManagerFactory.createEntityManager();
        init();
    }

    private void init() {
        this.studentDetailsList = entityManager.createQuery("select student from StudentDetails student", StudentDetails.class).getResultList();
        if (!studentDetailsList.isEmpty()) {
            this.studentDetails = this.studentDetailsList.get(0);
        }
    }

    public void previousStudent(ActionEvent event) {
        Integer index = this.studentDetailsList.indexOf(this.studentDetails);
        if (index > 0) {
            this.studentDetails = this.studentDetailsList.get(index - 1);
        } else {
            this.studentDetails = this.studentDetailsList.get(0);
        }
    }

    public void nextStudent(ActionEvent event) {
        Integer index = this.studentDetailsList.indexOf(this.studentDetails);
        if (index < this.studentDetailsList.size() - 1) {
            this.studentDetails = this.studentDetailsList.get(index + 1);
        } else {
            this.studentDetails = this.studentDetailsList.get(this.studentDetailsList.size() - 1);
        }
    }

    public void addStudent(ActionEvent event) {
        this.studentDetails = new StudentDetails();
        this.studentDetails.setId(200);
        this.studentDetails.setName("Pislaru Ana");
        this.studentDetails.setUniversityId("310440501RSL178992");
        this.studentDetails.setAddress("Iasi, strada Petru Voda III, nr. 199");
        this.studentDetails.setMaxBookAllow(25);
        this.studentDetails.setIssuedStudent("Nothing");
        this.studentDetailsList.add(studentDetails);
    }

    public void saveStudent(ActionEvent event) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(this.studentDetails);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.getSuppressed();
        }
    }

    public void deleteStudent(ActionEvent event) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.remove(this.studentDetails);
        entityManager.getTransaction().commit();
        this.studentDetailsList.remove(this.studentDetails);
        this.studentDetails = this.studentDetailsList.get(0);
    }


    public void abandonStudent(ActionEvent event) {
        entityManager.clear();
        init();
    }

    public Integer getIdStudent() {
        return this.studentDetails.getId();
    }

    public void setIdStudent(Integer id) {
        Integer index = this.studentDetailsList.indexOf(new StudentDetails(id, null, null, null, null, null));
    }


    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    public List<StudentDetails> getStudentDetailsList() {
        return studentDetailsList;
    }

    public void setStudentDetailsList(List<StudentDetails> studentDetailsList) {
        this.studentDetailsList = studentDetailsList;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
