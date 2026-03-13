package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.EmployeeNotFound;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	
	EmployeeRepository repository;

	@Override
	public String saveEmployee(Employee employee) {
		repository.save(employee);
		return "Employee saved successfully!";
	}

	@Override
	public String updateEmployee(Employee employee) {
		repository.save(employee);
		return "Employee updated successfully!";
	}

	@Override
	public String deleteEmployee(int empdId) {

		repository.deleteById(empdId);
		return "Employee deleted successfully!";
	}

	@Override
	public Employee getEmployee(int empId) throws EmployeeNotFound {

		Optional<Employee> optional = repository.findById(empId);
		
		if(optional.isEmpty()) {
			throw new EmployeeNotFound("No Employee found with given ID...");
		} else {
			return optional.get();
		}
		
	}

	@Override
	public List<Employee> getAllEmployees() {

		return repository.findAll();
	}

	@Override
	public List<Employee> getEmployeesByDesg(String empDesg) {

		return repository.getEmployeesByDesg(empDesg);
	}

	@Override
	public List<Employee> getEmployeesBetweenSal(int initialSal, int finalSal) {

		return repository.getEmployeesBetweenSal(initialSal, finalSal);
	}

}
