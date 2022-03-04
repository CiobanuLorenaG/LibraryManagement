package Entitati;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class LeaderTeam extends MemberTeam{
    @Id
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "skills")
    private String skills;

    public LeaderTeam(Integer id, String fullName, String skills) {
        this.id = id;
        this.fullName = fullName;
        this.skills = skills;
    }

    public LeaderTeam(Integer id, String name, Role role, Integer id1, String fullName, String skills) {
        super(id, name, role);
        this.id = id1;
        this.fullName = fullName;
        this.skills = skills;
    }

    public LeaderTeam() {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LeaderTeam that = (LeaderTeam) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "LeaderTeam{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}
