package com.example.school_db.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})

public class Teacher {

    @NotNull(message = "id must not be null")
    @Id
    private Integer id;

    @NotEmpty(message = "name must not be null")
    private String name;

    @NotEmpty(message = "Salary must not be null")
    private String salary;
}





