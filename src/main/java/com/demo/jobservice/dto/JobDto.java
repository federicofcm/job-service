package com.demo.jobservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobDto {

    private Integer id;

    private String type;

    private String company;

    private String location;

    private String title;

    private String description;

    private String companyLogo;

}
