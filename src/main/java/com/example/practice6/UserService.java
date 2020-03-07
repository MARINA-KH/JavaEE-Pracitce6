package com.example.practice6;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final EntityManager entityManager;

    @Transactional
    public UserEntity createUser(String firstName, String lastName, String email) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        return entityManager.merge(user);
    }


    @Transactional
    public List<UserEntity> findAllUsers() {
        return entityManager.createQuery("SELECT u FROM UserEntity u", UserEntity.class)
                .getResultList();
    }



    @Transactional
    public List<UserEntity> findUserWhereFirstOrLastNameContains(String searchText) {
        return entityManager.createQuery("SELECT u FROM UserEntity u WHERE u._firstName LIKE :query OR u._lastName LIKE :query", UserEntity.class)
                .setParameter("query", '%' + searchText + '%')
                .getResultList();
    }

    public List<UserEntity> findByLastName(String lastName) {
        return entityManager.createNamedQuery(UserEntity.FIND_BY_LASTNAME, UserEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

}