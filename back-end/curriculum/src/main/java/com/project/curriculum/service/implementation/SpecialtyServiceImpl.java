package com.project.curriculum.service.implementation;

import com.project.curriculum.domain.Specialty;
import com.project.curriculum.repository.SpecialtyRepository;
import com.project.curriculum.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Override
    public Specialty createSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty getSpecialtyById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public void updateSpecialty(Specialty specialty) {
        specialtyRepository.update(specialty.getFaculty().getId(), specialty.getName(), specialty.getId());
    }

    @Override
    public void deleteSpecialtyById(Long id) {
        specialtyRepository.deleteById(id);
    }

    @Override
    public void deleteSpecialtiesByIds(List<Long> ids) {
        specialtyRepository.deleteAllById(ids);
    }

}
