package com.udemy.course.config;

import com.udemy.course.entities.User;
import com.udemy.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("dev")
@Configuration
public class DevProfileConfig implements CommandLineRunner { // <== Implemento essa classe para poder executar algo
                                                            // quando a aplicacao for iniciada

    private final UserRepository userRepository;

    @Autowired
    public DevProfileConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@mail.com", "99999999", "123456");
        User u2 = new User(null, "Alex Green", "alex@mail.com", "98888888", "987654");

        userRepository.saveAll(List.of(u1, u2));

    }
}
