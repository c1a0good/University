package com.project.curriculum.repository;

import com.project.curriculum.domain.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    @Modifying
    @Query("UPDATE Discipline SET name = :name WHERE id = :discipline_id")
    void update(@Param("name") String name,
                @Param("discipline_id") Long id);
}
