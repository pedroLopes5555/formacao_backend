package com.formacao.demo_formacao_backend.Entities;
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private final String name;

    @Column(nullable = false)
    private final int age;


    @SuppressWarnings("unused")
    @Column(nullable = false)
    private final String password; // store hashed password


    /**
     * No-arg constructor required by JPA.
     * Private to prevent accidental use.
     */
    protected User() {
        this.name = null;
        this.password = null;
        this.age = 0;
    }

    /**
     * Constructor for creating a new User.
     *
     * @param name     The user's name
     * @param password The user's password (hashed)
     */
    public User(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    // --------------------
    // Getters
    // --------------------

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    /* *
    *  @Column(length = 50, nullable = false)
     */
}
