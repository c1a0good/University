package com.project.curriculum.service.implementation;

import com.project.curriculum.domain.Discipline;
import com.project.curriculum.domain.SpecialtyDiscipline;
import com.project.curriculum.repository.DisciplineRepository;
import com.project.curriculum.repository.SpecialtyDisciplineRepository;
import com.project.curriculum.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private SpecialtyDisciplineRepository specialtyDisciplineRepository;

    @Override
    public Discipline createDiscipline(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    @Override
    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();
    }

    @Override
    public Discipline getDisciplineById(Long id) {
        return disciplineRepository.findById(id).orElse(null);
    }

    @Override
    public void updateDiscipline(Discipline discipline) {
        disciplineRepository.update(discipline.getName(), discipline.getId());
    }

    @Override
    public void deleteDisciplineById(Long id) {
        disciplineRepository.deleteById(id);
    }

    @Override
    public void deleteDisciplinesByIds(List<Long> ids) {
        disciplineRepository.deleteAllById(ids);
    }

    @Override
    public List<SpecialtyDiscipline> getAllSpecDisByDis(Discipline discipline) {
        return specialtyDisciplineRepository.getAllByDiscipline(discipline);
    }

}
