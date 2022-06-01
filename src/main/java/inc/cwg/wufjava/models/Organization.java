package inc.cwg.wufjava.models;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected Long id;

    protected String name;

    protected String adjective;

    protected int nbMembers;

    protected String dof;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

    public String getDof() {
        return dof;
    }

    public void setDof(String dof) {
        this.dof = dof;
    }

    public Organization() {
    }

    public Organization(String name, String adjective, int nbMembers, String dof) {
        this.name = name;
        this.adjective = adjective;
        this.nbMembers = nbMembers;
        this.dof = dof;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adjective='" + adjective + '\'' +
                ", nbMembers=" + nbMembers +
                ", dof=" + dof +
                '}';
    }
}
