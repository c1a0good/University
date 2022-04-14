package com.src.receivingCompany.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.src.receivingCompany.models.Statement;
import com.src.receivingCompany.service.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/statements")
@CrossOrigin
@RequiredArgsConstructor
public class StatementController {
    private final StatementService statementService;

    @GetMapping
    public List<Statement> getAllStatements() {
        return statementService.getList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statement> getStatementById(@PathVariable Integer id) {
        return ResponseEntity.ok(statementService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Statement> addNewStatement(@RequestBody Statement statement) {
        return ResponseEntity.status(201).body(statementService.create(statement));
    }

    @PutMapping("/{id}")
    public void updateStatement(@PathVariable Integer id, @RequestBody Statement statement) {
        statementService.update(id, statement);
    }

    @DeleteMapping("/{id}")
    public void deleteStatementById(@PathVariable Integer id) {
        statementService.delete(id);
    }

    @PostMapping("/start")
    public ResponseEntity<?> startReceiving() throws JsonProcessingException {
        statementService.start();
        return ResponseEntity.ok("receiving company is done");
    }
}
