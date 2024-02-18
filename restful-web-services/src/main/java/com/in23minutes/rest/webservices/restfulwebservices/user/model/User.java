package com.in23minutes.rest.webservices.restfulwebservices.user.model;

import lombok.*;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private LocalDate birthDate;
}
