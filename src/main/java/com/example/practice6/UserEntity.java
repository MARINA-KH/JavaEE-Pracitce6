package com.example.practice6;

import javax.persistence.*;


import lombok.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(query = "SELECT u FROM UserEntity u WHERE u._lastName = :lastName", name = UserEntity.FIND_BY_LASTNAME)
})
public class UserEntity {

    public static final String FIND_BY_LASTNAME = "UserEntity.FIND_BY_LASTNAME";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer _id;

    @Column(name = "first_name")
    private String _firstName;

    @Column(name = "last_name")
    private String _lastName;

    @Column(name = "email")
    private String _email;



    public Integer getId() {
        return _id;
    }


    public String getFirstName(String firstName) {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        this._firstName = firstName;
    }


    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        this._lastName = lastName;
    }


    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        this._email = email;
    }


    UserEntity(String firstName, String lastName, String email) {
        this._firstName = firstName;
        this._lastName = lastName;
        this._email = email;
    }



}