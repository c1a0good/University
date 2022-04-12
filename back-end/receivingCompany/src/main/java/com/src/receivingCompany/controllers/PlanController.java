package com.src.receivingCompany.controllers;

import com.src.receivingCompany.models.Plan;
import com.src.receivingCompany.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plans")
@CrossOrigin
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    @GetMapping
    public List<Plan> getAllPlans() {
        return planService.getList();
    }

    @GetMapping("/{id}")
    public Plan getPlanById(@PathVariable Integer id) {
        return planService.getById(id);
    }

    @PostMapping
    public Plan addNewPlan(@RequestBody Plan plan) {
        return planService.create(plan);
    }

    @PutMapping("/{id}")
    public void updatePlan(@PathVariable Integer id, @RequestBody Plan plan) {
        planService.update(id, plan);
    }

    @DeleteMapping("/{id}")
    public void deletePlanById(@PathVariable Integer id) {
        planService.delete(id);
    }
}
