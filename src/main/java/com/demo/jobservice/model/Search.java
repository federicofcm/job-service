package com.demo.jobservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "job_location")
    private String jobLocation;

    @Column(name = "user_ip")
    private String userIp;

    @Column(name = "creation_timestamp", updatable = false)
    private ZonedDateTime creationTimestamp;

    @PrePersist
    public void prePersist() {
        creationTimestamp = ZonedDateTime.now();
    }

}
