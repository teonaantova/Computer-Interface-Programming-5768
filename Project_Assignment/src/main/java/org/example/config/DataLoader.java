package org.example.config;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee("Alice Johnson", "Onboarding", "Engineering", "Bob Smith"));
            repository.save(new Employee("Mark Lee", "Active", "Marketing", "Nina Davis"));
            repository.save(new Employee("Sara Kim", "Onboarding", "HR", "Tom Brown"));
        };
    }
}
