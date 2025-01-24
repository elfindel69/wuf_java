package inc.cwg.wufjava.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
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
