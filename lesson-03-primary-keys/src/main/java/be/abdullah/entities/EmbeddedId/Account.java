package be.abdullah.entities.EmbeddedId;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Setter;

@Entity
@Setter
public class Account {
    @EmbeddedId
    private AccountId accountId;
}
