package com.src.receivingCompany.repository;

import com.src.receivingCompany.models.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {
    @Modifying
    @Query("update Plan p set p.specialtyId = :specialtyId, p.count = :count where p.id = :id")
    void update(@Param("id") Integer id, @Param("specialtyId") Integer specialtyId, @Param("count") Integer count);

    Plan getBySpecialtyId(Integer id);
}
