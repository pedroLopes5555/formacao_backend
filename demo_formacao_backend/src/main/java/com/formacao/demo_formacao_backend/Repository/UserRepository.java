package com.formacao.demo_formacao_backend.Repository;

import com.formacao.demo_formacao_backend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByName(String name);  // returns list (if duplicates exist)
}
