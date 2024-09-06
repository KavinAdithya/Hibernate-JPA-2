package org.hibernate.HibernateFinal.mappingRelationship;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_link")
    private User user;

    public Profile() {
        super();
    }

    public Profile(int id, String firstName, String lastName, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile profile)) return false;
        return getId() == profile.getId() && Objects.equals(getFirstName(), profile.getFirstName()) && Objects.equals(getLastName(), profile.getLastName()) && Objects.equals(getUser(), profile.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getUser());
    }

    @Override
    public String toString() {
        return "Profile : "                         + "\n" +
                "        profileId : "  + id        + "\n" +
                "        firstName : "  + firstName + "\n" +
                "        lastName  : "  + lastName  + "\n" + user;
    }
}
