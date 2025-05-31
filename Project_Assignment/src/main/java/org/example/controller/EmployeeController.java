package org.example.controller;

import org.example.model.EmergencyContact;
import org.example.model.Employee;
import org.example.model.PerformanceReview;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/onboarding-tasks")
    public ResponseEntity<List<String>> getOnboardingTasks(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getOnboardingTasks(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Employee> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(employeeService.updateStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/documents")
    public ResponseEntity<String> uploadDocument(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(employeeService.uploadDocument(id, file));
    }

    @GetMapping("/{id}/training-progress")
    public ResponseEntity<Integer> getTrainingProgress(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getTrainingProgress(id));
    }

    @PutMapping("/{id}/team")
    public ResponseEntity<String> assignTeam(@PathVariable Long id, @RequestParam String team) {
        return ResponseEntity.ok(employeeService.assignTeam(id, team));
    }

    @PutMapping("/{id}/mentor")
    public ResponseEntity<String> assignMentor(@PathVariable Long id, @RequestParam String mentor) {
        return ResponseEntity.ok(employeeService.assignMentor(id, mentor));
    }

    @GetMapping("/{id}/mentor")
    public ResponseEntity<String> getMentor(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getMentor(id));
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<PerformanceReview> submitReview(@PathVariable Long id, @RequestBody PerformanceReview review) {
        return new ResponseEntity<>(employeeService.submitReview(id, review), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<PerformanceReview>> getReviews(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getReviews(id));
    }

    @PostMapping("/{id}/emergency-contact")
    public ResponseEntity<String> addEmergencyContact(@PathVariable Long id, @RequestBody EmergencyContact contact) {
        return ResponseEntity.ok(employeeService.addEmergencyContact(id, contact));
    }
}

