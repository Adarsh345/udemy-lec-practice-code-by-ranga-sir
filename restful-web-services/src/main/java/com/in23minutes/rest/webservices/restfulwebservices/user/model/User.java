package com.in23minutes.rest.webservices.restfulwebservices.user.model;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    @Size (min = 2,message = "Should have min 2 characters")
    private String name;
    @Past(message = "Should accept only past value")
    private LocalDate birthDate;
}
