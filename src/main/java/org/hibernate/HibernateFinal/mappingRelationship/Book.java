package org.hibernate.HibernateFinal.mappingRelationship;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Book_id")
    private int id;

    @Column(name = "Book_title")
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Book_author")
    private Author author;


    public Book() {
        super();
    }

    public Book(String title, Author author) {
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getId() == book.getId() && Objects.equals(getTitle(), book.getTitle() ) && Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getAuthor());
    }

    @Override
    public String toString() {
        return "Book : " + "\n" +
                "     BookId     : " + id       + "\n" +
                "     BookTitle  : " + title    + "\n" +
                "     AuthorName : " + author;
    }
}
