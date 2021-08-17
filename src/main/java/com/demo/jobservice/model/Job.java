package com.demo.jobservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Job {

    private Integer id;

    private String type;

    private String url;

    private String created_at;

    private String company;

    private String company_url;

    private String location;

    private String title;

    private String description;

    private String how_to_apply;

    private String company_logo;

}
