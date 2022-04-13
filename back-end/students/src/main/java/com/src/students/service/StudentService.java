package com.src.students.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.src.students.model.Disciple;
import com.src.students.model.Mark;
import com.src.students.model.Student;
import com.src.students.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StudentService {
    private final StudentsRepository studentRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final static String SPEC_URL = "localhost:8080/specialties/%s/disciplines";

    public List<Student> getList() {
        log.info("Get all student...");
        return studentRepository.findAll();
    }

    public Student getById(Integer id){
        return studentRepository.getById(id);
    }

    public Student create(Student student) {
        log.info("Create student...");
        return studentRepository.save(student);
    }

    public void update(Integer id, Student student) {
        Student old = getById(id);
        if (!old.getCourse().equals(student.getCourse())) {
            fillMark(student);
        }
        log.info("Update Student with ip={}...", id);
        student.setId(id);
        studentRepository.save(student);
    }

    public void delete(Integer id) {
        log.info("Delete student with ip={}...", id);
        studentRepository.deleteById(id);
    }

    private void fillMark(Student newS) {
        List<Disciple> disciples;
        ResponseEntity<Disciple[]> response =
                restTemplate.getForEntity(String.format(SPEC_URL, newS.getSpecialtyId()), Disciple[].class);
        disciples = Arrays.stream(response.getBody()).toList();

        List<Mark> marks =  Collections.emptyList();

        for (Disciple dis: disciples) {
            marks.add(new Mark(null, dis.getDisciplineId(), 0));
        }
        newS.setMarks(marks);
    }
}
