package com.src.receivingCompany.repository;

import com.src.receivingCompany.models.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Integer> {
    List<Statement> getAllBySpecialtyId(Integer id);
}
