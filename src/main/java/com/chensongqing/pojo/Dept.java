package com.chensongqing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id;
    private String name;
    private int age;
    private int gender;
    private String phone;

//    public user() {
//    }
//
//    public user(int id, String name, int age, int gender, String phone) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.phone = phone;
//    }
//
//    @Override
//    public String toString() {
//        return "user{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", gender=" + gender +
//                ", phone='" + phone + '\'' +
//                '}';
//    }
}
