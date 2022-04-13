package com.src.students.service;

import com.src.students.model.Mark;
import com.src.students.repository.MarkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MarkService {
    private final MarkRepository markRepository;

    public List<Mark> getList() {
        log.info("Get all mark...");
        return markRepository.findAll();
    }


    public Mark getById(Integer id) {
        return markRepository.getById(id);
    }

    public Mark create(Mark mark) {
        log.info("Create mark...");
        return markRepository.save(mark);
    }

    public void update(Integer id, Mark mark) {
        mark.setId(id);
        log.info("Update mark with ip={}...", id);
        markRepository.save(mark);
    }

    public void delete(Integer id) {
        log.info("Delete mark with ip={}...", id);
        markRepository.deleteById(id);
    }

}
