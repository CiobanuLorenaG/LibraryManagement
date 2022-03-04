package Entitati;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "team", schema = "public", catalog = "library" )
public class Team {
    @Id
    private Integer id;
    @Column(name = "specialization")
    private String specialization;
    @OneToMany(mappedBy = "teamMember", cascade = CascadeType.ALL)
    private List<MemberTeam> members = new ArrayList<>();
    @ManyToOne
    private LeaderTeam leader;

    public Team(Integer id, String specialization, LeaderTeam leader) {
        this.id = id;
        this.specialization = specialization;
        this.leader = leader;
    }

    public Team() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

//    public List<MemberTeam> getMembers() {
//        return members;
//    }
//
//    public void setMembers(List<MemberTeam> members) {
//        this.members = members;
//    }

    public LeaderTeam getLeader() {
        return leader;
    }

    public void setLeader(LeaderTeam leader) {
        this.leader = leader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", specialization='" + specialization + '\'' +
                ", leader=" + leader +
                '}';
    }
}
