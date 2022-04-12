package com.project.curriculum.repository;

import com.project.curriculum.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    @Modifying
    @Query("UPDATE Faculty SET name = :name WHERE id = :faculty_id")
    void update(@Param("name") String name,
                @Param("faculty_id") Long id);
}
