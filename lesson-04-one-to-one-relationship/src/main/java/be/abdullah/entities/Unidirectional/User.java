package be.abdullah.entities.Unidirectional;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Profile profile;

}
