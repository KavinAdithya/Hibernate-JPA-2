package org.hibernate.HibernateFinal.mappingRelationship;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email_id")
    private String email;

    public User() {
        super();
    }

    public User(String userName, String email) {

        this.userName = userName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId() == user.getId() && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getEmail());
    }

    @Override
    public String toString() {
        return "User : \n" +
                "      userId   : " + id + "\n" +
                "      userName : " + userName  + "\n" +
                "      E-mail   : " + email;
    }
}
