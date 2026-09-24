package be.abdullah.entities.EmbeddedId;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AccountId implements Serializable {
    private Integer accountNumber;
    private String accountType;

}
