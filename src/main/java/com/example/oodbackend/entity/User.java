package com.example.oodbackend.entity;

import javax.persistence.*;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;

   @NotBlank(message = "username can't be blank")
    private String username;

    private String firstName;

    private String lastName;

    @Email
    @NotEmpty(message = "Email is required")
    @Column(unique=true)
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    private Instant createdAt;

    private boolean status ;

    // Each user is going to be mapped to a Location
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "location_id",
            referencedColumnName = "locationId"
    )
    @NotNull
    private Location location ;


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_categories",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "userId",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "category_id", referencedColumnName = "categoryId",
                            nullable = false, updatable = false)})
    private Set <Categories> categories = new HashSet<>();


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", status=" + status +
                '}';
    }
}
