package com.chensongqing.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {
    private Integer id;

    private String username;

    private String passwordHash;

}
