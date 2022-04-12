package com.project.curriculum.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "specialties_disciplines")
public class SpecialtyDiscipline {

    @Id
    @Column(name = "specialty_discipline_id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "specialty_id")
    @JsonBackReference
    private Specialty specialty;
    @ManyToOne
    @JoinColumn(name = "discipline_id")
    @JsonBackReference
    private Discipline discipline;
    private Integer semester;
    @Enumerated(EnumType.STRING)
    @Column(name = "form_of_control")
    private FormOfControl formOfControl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public FormOfControl getFormOfControl() {
        return formOfControl;
    }

    public void setFormOfControl(FormOfControl formOfControl) {
        this.formOfControl = formOfControl;
    }

}
