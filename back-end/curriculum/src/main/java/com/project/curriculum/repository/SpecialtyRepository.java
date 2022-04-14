package com.project.curriculum.repository;

import com.project.curriculum.domain.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    @Modifying
    @Query("UPDATE Specialty SET faculty = :faculty_id, name = :name WHERE id = :specialty_id")
    void update(@Param("faculty_id") Long facultyId,
                @Param("name") String name,
                @Param("specialty_id") Long specialtyId);
}
