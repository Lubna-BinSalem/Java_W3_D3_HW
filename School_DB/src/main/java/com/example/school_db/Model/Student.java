package com.example.school_db.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})

public class Student {


    @NotNull(message = "id must not be null")
    @Id
    private Integer id;

    @NotEmpty(message = "name must not be null")
    private String name;

    @NotEmpty(message = "age must not be null")
    private String age;

    @NotEmpty(message = "major must not be null")
    @Column(columnDefinition = "varchar(10) check (major='CS' or major='MATH' or major='Engineer' )")
    private String major;
}
