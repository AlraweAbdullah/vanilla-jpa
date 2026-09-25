package be.abdullah.entities.bidirectional;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @ToString.Exclude
    private Office office;
}
