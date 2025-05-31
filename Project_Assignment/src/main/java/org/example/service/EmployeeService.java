package org.example.service;

import org.example.model.EmergencyContact;
import org.example.model.Employee;
import org.example.model.PerformanceReview;
import org.example.repository.EmployeeRepository;
import org.example.repository.PerformanceReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PerformanceReviewRepository reviewRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<String> getOnboardingTasks(Long employeeId) {
        return List.of("Submit ID", "Sign NDA", "Complete orientation");
    }

    public Employee updateStatus(Long employeeId, String status) {
        Employee emp = employeeRepository.findById(employeeId).orElseThrow();
        emp.setStatus(status);
        return employeeRepository.save(emp);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public String uploadDocument(Long employeeId, MultipartFile file) {
        return "Uploaded for employee " + employeeId;
    }

    public int getTrainingProgress(Long employeeId) {
        return 75;
    }

    public String assignTeam(Long employeeId, String teamName) {
        Employee emp = employeeRepository.findById(employeeId).orElseThrow();
        emp.setTeam(teamName);
        employeeRepository.save(emp);
        return "Assigned to team " + teamName;
    }

    public String assignMentor(Long employeeId, String mentorName) {
        Employee emp = employeeRepository.findById(employeeId).orElseThrow();
        emp.setMentor(mentorName);
        employeeRepository.save(emp);
        return "Mentor " + mentorName + " assigned.";
    }

    public String getMentor(Long employeeId) {
        return "Mentor: " + employeeRepository.findById(employeeId).orElseThrow().getMentor();
    }

    public PerformanceReview submitReview(Long employeeId, PerformanceReview review) {
        review.setEmployee(employeeRepository.findById(employeeId).orElseThrow());
        return reviewRepository.save(review);
    }

    public List<PerformanceReview> getReviews(Long employeeId) {
        return reviewRepository.findByEmployeeId(employeeId);
    }

    public String addEmergencyContact(Long employeeId, EmergencyContact contact) {
        contact.setEmployee(employeeRepository.findById(employeeId).orElseThrow());
        return "Emergency contact saved.";
    }
}

