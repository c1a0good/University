package com.project.curriculum.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "disciplines")
public class Discipline {

    @Id
    @Column(name = "discipline_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "discipline", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<SpecialtyDiscipline> disciplineSpecialties;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<SpecialtyDiscipline> getDisciplineSpecialties() {
        return disciplineSpecialties;
    }

    public void setDisciplineSpecialties(List<SpecialtyDiscipline> disciplineSpecialties) {
        this.disciplineSpecialties = disciplineSpecialties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
