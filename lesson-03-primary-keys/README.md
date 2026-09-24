# Primary Keys

## Annotations

## `@Id`

Every JPA Entity must have an `@Id` attribute that represents its primary key.

## `@GeneratedValue`

Used to automatically generate the primary key value.

`strategy` specifies the ID generation strategy.

- `AUTO` — The JPA provider chooses the appropriate generation strategy automatically. This is the default strategy value.
- `IDENTITY` — The database generates the ID.
- `SEQUENCE` — Uses a database sequence to generate the ID.
- `TABLE` — Uses a database table to generate the ID.
- `UUID` — Generates the ID as a Universally Unique Identifier.

Without `@GeneratedValue`, the ID must be manually assigned.

# Composite Primary Keys

In order to define the composite primary keys, some rules should be followed:

- The composite primary key class must be public.
- It must have a no-arg constructor.
- It must define the equals() and hashCode() methods.
- It must be Serializable.

## Annotations

### `@IdClass`

A `Book` table has two columns, `title` and `language`, that together form the composite key.

Create a `BookId` class containing these fields:

```java
public class BookId implements Serializable {

    private String title;
    private String language;

    // default constructor

    public BookId(String title, String language) {
        this.title = title;
        this.language = language;
    }

    // equals() and hashCode()
}
```

Associate `BookId` with the `Book` entity using `@IdClass`.

The same fields must be declared in the entity and annotated with `@Id`:

```java
@Entity
@IdClass(BookId.class)
public class Book {

    @Id
    private String title;

    @Id
    private String language;

    // getters and setters
}
```

### `@EmbeddedId`

`@EmbeddedId` is an alternative to `@IdClass`.

A `Book` entity has `title` and `language` as its composite primary key fields.

The primary key class, `BookId`, must be annotated with `@Embeddable`:

```java
@Embeddable
public class BookId implements Serializable {

    private String title;
    private String language;

    // default constructor

    public BookId(String title, String language) {
        this.title = title;
        this.language = language;
    }

    // equals() and hashCode()
}
```

Embed `BookId` in the `Book` entity using `@EmbeddedId`:

```java
@Entity
public class Book {

    @EmbeddedId
    private BookId bookId;

    // constructors, getters and setters
}
```

## `@IdClass` vs `@EmbeddedId`

With `@IdClass`, the primary key fields are specified twice, once in bookId and again in Book. With @EmbeddedId, the fields are not specified twice.

This also affects JPQL queries.

With `@IdClass`:

```sql
SELECT book.title FROM Book book;
```

With `@EmbeddedId`:

```sql
SELECT book.bookId.title FROM Book book;
```

If individual parts of the composite key are frequently accessed, `@IdClass` provides direct access to those fields.

If the complete composite key is frequently used as a single object, `@EmbeddedId` is more suitable.