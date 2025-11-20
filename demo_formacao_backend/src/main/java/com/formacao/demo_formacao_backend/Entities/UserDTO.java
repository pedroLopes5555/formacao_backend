package com.formacao.demo_formacao_backend.Entities;
@SuppressWarnings("unused")
public class UserDTO {
    private final Long id;
    private final String name;
    private final int age;

    public UserDTO(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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
}
