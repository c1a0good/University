package com.src.receivingCompany.service;

import com.src.receivingCompany.exception.EntityNotFoundException;
import com.src.receivingCompany.models.Plan;
import com.src.receivingCompany.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PlanService {
    private final PlanRepository repository;

    public List<Plan> getList() {
        log.info("Get all entity...");
        return repository.findAll();
    }

    public Plan getById(Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(String.format("no plan with id = %s", id));
        }
        return repository.getById(id);
    }

    public Plan getBySpec(Integer id) {
        return repository.getBySpecialtyId(id);
    }

    public Plan create(Plan plan) {
        log.info("Create entity...");
        return repository.save(plan);
    }

    public void update(Integer id, Plan plan) {
        log.info("Update plan with ip={}...", id);
        repository.update(id, plan.getSpecialtyId(), plan.getCount());
    }

    public void delete(Integer id) {
        log.info("Delete entity with ip={}...", id);
        repository.deleteById(id);
    }


}
