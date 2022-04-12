package com.src.receivingCompany.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statement")
@Data
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Integer id;
    @JsonProperty("FirstName")
    @Column(name = "first_name")
    private String firstName;
    @JsonProperty("SecondName")
    @Column(name = "second_name")
    private String secondName;
    @JsonProperty("SpecialtyId")
    @Column(name = "specialty_id")
    private Integer specialtyId;
    @JsonProperty("Semester")
    @Column(name = "semester")
    private Integer semester;
}
