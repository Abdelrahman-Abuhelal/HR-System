package com.springdata.secondDemo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springdata.secondDemo.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.transform.sax.SAXResult;

@Entity
@Data
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private Employee employee;

    public static User toUser(UserDTO user){
        return User.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .employee(user.getEmployee())
                .build();
    }


}
