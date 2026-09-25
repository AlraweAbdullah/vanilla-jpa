package be.abdullah.entities.Bidirectional;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Setter
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "office")
    private Employee employee;
}
