package bookshopsystemapp.domain.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    public Integer id;

    public BaseEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
