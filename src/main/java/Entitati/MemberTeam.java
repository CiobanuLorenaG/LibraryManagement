package Entitati;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "member_team", schema = "public", catalog = "library" )
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MemberTeam {
    @Id
    private Integer id;
    @Column(name = "name_member_team", length = 150)
    private String name;
    @Column(name = "role_member_team", length = 20)
    private Role role;
    @ManyToOne
    private MemberTeam teamMember;
    @ManyToOne
    private Team team;


    public MemberTeam() {}

    public MemberTeam(Integer id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeamMember(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberTeam that = (MemberTeam) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MemberTeam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }

}
