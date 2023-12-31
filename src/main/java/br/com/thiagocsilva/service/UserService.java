package br.com.thiagocsilva.service;

import br.com.thiagocsilva.controller.CreateUserDto;
import br.com.thiagocsilva.entity.User;
import br.com.thiagocsilva.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public UUID createUser(CreateUserDto createUserDto) {

           var entity = new User(
                    UUID.randomUUID(),
                    createUserDto.username(),
                    createUserDto.email(),
                    createUserDto.password(),
                    Instant.now(),
                    null
            );
           var userSaved = userRepository.save(entity);

           return userSaved.getUserId();
    }
}
