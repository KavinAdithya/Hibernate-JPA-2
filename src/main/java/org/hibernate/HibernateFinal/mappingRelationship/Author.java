package org.hibernate.HibernateFinal.mappingRelationship;

import javax.persistence.*;

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
    private  List<Book> bookList ;

    public Author() {
        super();
    }

    public Author(String name, List<Book> book) {
        this.name = name;

        addBooks(book);
    }

    private void addBooks(List<Book> book) {
        this.bookList = book;
    }


    public List<Book> getBookList() {
        return  bookList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setBookList(List<Book> book) {
        this.bookList = book;
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
