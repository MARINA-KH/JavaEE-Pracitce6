package com.example.practice6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Practice6Application {

	public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Practice6Application.class, args);
        UserService userService = applicationContext.getBean(UserService.class);

        UserEntity userEntity = userService.createUser("firstName1", "lastName1", "email@example.com");
        System.out.println("Saved new user: " + userEntity);


        userService.createUser("Kate", "Smith", "email2@example.com");
        userService.createUser("Julia", "Smith", "email3@example.com");
        userService.createUser("John", "Sanders", "email4@example.com");


        System.out.println("Find all");
        List<UserEntity> users = userService.findAllUsers();
        for(UserEntity user : users)
            System.out.println(user);


        System.out.println("All Smith");
        users = userService.findByLastName("Smith");
        for(UserEntity user : users)
            System.out.println(user);


        System.out.println("Find all with a");
        users = userService.findUserWhereFirstOrLastNameContains("a");
        for(UserEntity user : users)
            System.out.println(user);




	}

}
