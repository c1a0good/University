package com.project.curriculum.repository;

import com.project.curriculum.domain.FormOfControl;
import com.project.curriculum.domain.SpecialtyDiscipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyDisciplineRepository extends JpaRepository<SpecialtyDiscipline, Long> {
    @Modifying
    @Query("UPDATE SpecialtyDiscipline SET " +
            "specialty = :specialty_id, discipline = :discipline_id, semester = :semester, formOfControl = :form_of_control " +
            "WHERE id = :specialty_discipline_id")
    void update(@Param("specialty_id") Long specialtyId,
                @Param("discipline_id") Long disciplineId,
                @Param("semester") Integer semester,
                @Param("form_of_control") FormOfControl formOfControl,
                @Param("specialty_discipline_id") Long specialtyDisciplineId);
}
