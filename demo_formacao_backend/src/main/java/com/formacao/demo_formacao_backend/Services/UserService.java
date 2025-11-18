package com.formacao.demo_formacao_backend.Services;

import com.formacao.demo_formacao_backend.Entities.User;
import com.formacao.demo_formacao_backend.Entities.UserDTO;
import com.formacao.demo_formacao_backend.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements IUserService {



    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //or Autowired, Wy im i not using Autowired?
    //    @Autowired


    // Create user
    @Transactional //when should i use it ? (makes the methos calles atomic)
    public UserDTO createUser(String name, int age, String password) {
        User user = new User(name, age, password);
        var saved = userRepository.save(user);
        return new UserDTO(saved.getId(), saved.getName(), saved.getAge());
    }


    // Get user by ID
    public UserDTO getById(Long id) {
        var result =  userRepository.findById(id)
                .orElse(null);

        assert result != null;
        return new UserDTO(result.getId(), result.getName(), result.getAge());
    }

    // Get all users by name
    public List<UserDTO> getAllByName(String name) {
        return userRepository.findAllByName(name)
                .stream()
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getAge()))
                .toList();
    }

}

