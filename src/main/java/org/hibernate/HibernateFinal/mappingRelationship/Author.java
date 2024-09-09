package org.hibernate.HibernateFinal.mappingRelationship;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(name = "author_name")
    private String name;

    @OneToMany(cascade =  CascadeType.ALL)
    @JoinColumn(name = "Books")
    private ArrayList<Book> bookList;

    public Author() {
        //bookList = new ArrayList<>();
    }

    public Author(String name, Book book) {
        this.name = name;
        bookList = new ArrayList<>();
        bookList.add(book);
    }

    @SuppressWarnings("unchecked")
    public List<Book> getBookList() {
        return (List<Book>) bookList.clone();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setBook(Book book) {
        if (bookList == null)
            bookList = new ArrayList<>();
        bookList.add(book);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return getId() == author.getId() && Objects.equals(getName(), author.getName()) && Objects.equals(getBookList(), author.getBookList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBookList());
    }

    @Override
    public String toString() {
        return "Author : " + "\n" +
                "       AuthorId : " + id + "\n" +
                "       AuthorName : " + name + "\n" +
                "       BookList : " + bookList;
    }
}
