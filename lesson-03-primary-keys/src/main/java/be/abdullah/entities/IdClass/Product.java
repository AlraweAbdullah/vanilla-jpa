package be.abdullah.entities.IdClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@IdClass(ProductId.class)
public class Product {

    @Id
    private String color;

    @Id
    private String code;
}
