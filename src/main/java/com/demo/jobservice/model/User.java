package com.demo.jobservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private Integer id;

    private String name;

    private String username;

    private String email;

    private String phone;

    private String website;

}
