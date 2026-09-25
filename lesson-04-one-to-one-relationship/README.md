# One-to-One Relationship

## Unidirectional Relationship

A unidirectional one-to-one relationship means:

* Entity A references a single instance of Entity B.
* Entity B does not reference Entity A.
* Entity A is the owning side of the relationship.
* Table A contains a foreign key to Table B.

### Example

```java
@Entity
public class Employee {
    @OneToOne
    private TravelProfile profile;

    public TravelProfile getProfile() {
        return profile;
    }

    public void setProfile(TravelProfile profile) {
        this.profile = profile;
    }

    // ...
}
```

```java
@Entity
public class TravelProfile {

    // ...
}
```

In this example:

* `Employee` references a single instance of `TravelProfile`.
* `TravelProfile` does not reference `Employee`.
* `Employee` is the owner of the relationship.
* The `employee` table has the foreign key to the `travel_profile` table.

## Bidirectional One-to-One Relationship

* Entity `A` references a single instance of Entity `B`.
* Entity `B` references a single instance of Entity `A`.
* Entity `A` is specified as the owner of the relationship.
* Table `A` contains a foreign key to Table `B`.

```java
@Entity
public class Employee {

    @OneToOne
    private Office office;

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    // ...
}
```

```java
@Entity
public class Office {

    @OneToOne(mappedBy = "office")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // ...
}
```

In this example:

* `Employee` references a single instance of `Office`.
* `Office` references a single instance of `Employee`.
* `Employee` is the owner of the relationship.
* The `employee` table has the foreign key to the `office` table.

