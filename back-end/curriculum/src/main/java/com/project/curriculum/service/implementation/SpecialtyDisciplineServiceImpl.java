package com.project.curriculum.service.implementation;

import com.project.curriculum.domain.SpecialtyDiscipline;
import com.project.curriculum.repository.SpecialtyDisciplineRepository;
import com.project.curriculum.service.SpecialtyDisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpecialtyDisciplineServiceImpl implements SpecialtyDisciplineService {

    @Autowired
    private SpecialtyDisciplineRepository specialtyDisciplineRepository;

    @Override
    public SpecialtyDiscipline createSpecialtyDiscipline(SpecialtyDiscipline specialtyDiscipline) {
        return specialtyDisciplineRepository.save(specialtyDiscipline);
    }

    @Override
    public List<SpecialtyDiscipline> getAllSpecialtiesDisciplines() {
        return specialtyDisciplineRepository.findAll();
    }

    @Override
    public SpecialtyDiscipline getSpecialtyDisciplineById(Long id) {
        return specialtyDisciplineRepository.findById(id).orElse(null);
    }

    @Override
    public void updateSpecialtyDiscipline(SpecialtyDiscipline specialtyDiscipline) {
        specialtyDisciplineRepository.update(
                specialtyDiscipline.getSpecialty().getId(),
                specialtyDiscipline.getDiscipline().getId(),
                specialtyDiscipline.getSemester(),
                specialtyDiscipline.getFormOfControl(),
                specialtyDiscipline.getId());
    }

    @Override
    public void deleteSpecialtyDiscipline(Long id) {
        specialtyDisciplineRepository.deleteById(id);
    }

    @Override
    public void deleteSpecialtiesByIds(List<Long> ids) {
        specialtyDisciplineRepository.deleteAllById(ids);
    }

}
