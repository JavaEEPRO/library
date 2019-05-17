package si.inspirited.model.abstractModel;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Jesus Lord Almighty
 * at 23.01.2018
 */

@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
