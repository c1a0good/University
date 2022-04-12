package com.src.receivingCompany.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.src.receivingCompany.exception.EntityNotFoundException;
import com.src.receivingCompany.models.Specialty;
import com.src.receivingCompany.models.Statement;
import com.src.receivingCompany.repository.StatementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
public class StatementService {
    private final StatementRepository statementRepository;
    private final PlanService planService;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final static String SPEC_URL = "http://localhost:8080/specialties";
    private final static String STUD_URL = "http://localhost:8081/students";

    public void start() throws JsonProcessingException {
        log.info("Start receiving...");
        List<Specialty> specialties = Collections.emptyList();
        try {
            ResponseEntity<Specialty[]> response =
                    restTemplate.getForEntity(SPEC_URL, Specialty[].class);
            specialties = Arrays.stream(response.getBody()).toList();
        }
        catch (Exception e) {
            log.warn(e.getMessage());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request;

        for (Specialty specialty : specialties) {
            Integer count = planService.getBySpec(specialty.getId()).getCount();
            List<Statement> statements = getBySpec(specialty.getId());
            for (int i = 0; i < count; i++) {
                request = new HttpEntity<String>(objectMapper.writeValueAsString(statements.get(i)), headers);
                try {
                    restTemplate.postForLocation(STUD_URL, request);
                }
                catch (Exception e) {
                    log.warn(e.getMessage());
                }
            }
        }
    }

    public List<Statement> getList() {
        log.info("Get all entity...");
        return statementRepository.findAll();
    }

    public Statement getById(Integer id){
        if (statementRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(String.format("no Statement with id = %s", id));
        }
        return statementRepository.getById(id);
    }

    public List<Statement> getBySpec(Integer id){
        return statementRepository.getAllBySpecialtyId(id);
    }


    public Statement create(Statement statement) {
        log.info("Create entity...");
        return statementRepository.save(statement);
    }

    public void update(Integer id, Statement statement) {
        log.info("Update Statement with ip={}...", id);
        statement.setId(id);
        statementRepository.save(statement);
    }

    public void delete(Integer id) {
        log.info("Delete entity with ip={}...", id);
        statementRepository.deleteById(id);
    }
}
