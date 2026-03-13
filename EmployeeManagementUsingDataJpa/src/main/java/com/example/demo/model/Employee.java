package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cts_emp_info")
@Data //@Setter @Getter @RequiredArgsConstructor @equalsHashCode @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@Column(name = "empno")
	@Min(value = 1, message = "Employee Id cannot be -ve")
	
	private int empId;
	@NotBlank(message = "Name cannot be null, empty or blank")
	@Column(name = "ename", nullable = false, length = 10)
	@Size(min = 4, max = 15, message = "Name length must be between 6 and 15 characters")
	private String empName;
	@Min(value = 10000, message = "Salary cannot be below 10000")
	@Max(value = 100000, message = "Salary cannot be aboce 100000")
	private int empSal;
	@NotEmpty(message = "Employee Designation cannot be null/empty")
	private String empDesg;

	
}
