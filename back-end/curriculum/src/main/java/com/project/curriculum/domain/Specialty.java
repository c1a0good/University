package com.project.curriculum.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "specialties")
public class Specialty {

    @Id
    @Column(name = "specialty_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    @JsonManagedReference
    private Faculty faculty;
    @OneToMany(mappedBy = "specialty", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<SpecialtyDiscipline> specialtyDiscipline;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<SpecialtyDiscipline> getSpecialtyDiscipline() {
        return specialtyDiscipline;
    }

    public void setSpecialtyDiscipline(List<SpecialtyDiscipline> specialtyDiscipline) {
        this.specialtyDiscipline = specialtyDiscipline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
