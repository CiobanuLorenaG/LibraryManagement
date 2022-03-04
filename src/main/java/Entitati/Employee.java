package Entitati;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

@Entity
public class Employee extends MemberTeam{
    @Id
    private Integer id;
    @Column(name = "date_hired",length = 20)
    private Date dateHired;
    @ManyToOne
    private Team team;

    public Employee(Integer id, Date dateHired) {
        this.id = id;
        this.dateHired = dateHired;
    }

    public Employee(Integer id, String name, Role role, Date dateHired) {
        super(id, name, role);
        this.dateHired = dateHired;
    }

    public Employee() {
        super();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    @Override
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", dateHired=" + dateHired +
                '}';
    }
}
