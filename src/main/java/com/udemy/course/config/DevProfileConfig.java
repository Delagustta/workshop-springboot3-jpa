package com.udemy.course.config;

import com.udemy.course.entities.Order;
import com.udemy.course.entities.User;
import com.udemy.course.repositories.OrderRepository;
import com.udemy.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.List;

@Profile("dev")
@Configuration
public class DevProfileConfig implements CommandLineRunner { // <== Implemento essa classe para poder executar algo
                                                            // quando a aplicacao for iniciada

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public DevProfileConfig(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@mail.com", "99999999", "123456");
        User u2 = new User(null, "Alex Green", "alex@mail.com", "98888888", "987654");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        userRepository.saveAll(List.of(u1, u2));
        orderRepository.saveAll(List.of(o1, o2, o3));
    }
}
