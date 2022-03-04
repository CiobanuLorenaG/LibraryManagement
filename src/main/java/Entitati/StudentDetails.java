package Entitati;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student_details", schema = "public", catalog = "library" )
public class StudentDetails {
    @Id
    private Integer id;
    @Column(name="name_student", length = 100)
    private String name;
    @Column(name="university_id", length = 100)
    private String universityId;
    @Column(name="address_student", length = 100)
    private String address;
    @Column(name = "max_book_allow", length = 50)
    private Integer maxBookAllow;
    @Column(name="issued_student")
    private String issuedStudent;

    @OneToMany(mappedBy = "studentDetails", cascade = CascadeType.ALL)
    private List<BookTransaction> bookTransactions=new ArrayList<>();

    public StudentDetails() {
    }

    public StudentDetails(Integer id, String name, String universityId, String address, Integer maxBookAllow, String issuedStudent) {
        this.id = id;
        this.name = name;
        this.universityId = universityId;
        this.address = address;
        this.maxBookAllow = maxBookAllow;
        this.issuedStudent = issuedStudent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMaxBookAllow() {
        return maxBookAllow;
    }

    public void setMaxBookAllow(Integer maxBookAllow) {
        this.maxBookAllow = maxBookAllow;
    }

    public String getIssuedStudent() {
        return issuedStudent;
    }

    public void setIssuedStudent(String issuedStudent) {
        this.issuedStudent = issuedStudent;
    }

    public List<BookTransaction> getBookTransactions() {
        return bookTransactions;
    }

    public void setBookTransactions(List<BookTransaction> bookTransactions) {
        this.bookTransactions = bookTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDetails that = (StudentDetails) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", universityId='" + universityId + '\'' +
                ", address='" + address + '\'' +
                ", maxBookAllow=" + maxBookAllow +
                ", issuedStudent='" + issuedStudent + '\'' +
                '}';
    }
}
