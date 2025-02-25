package com.sample.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sample.DTO.DepartmentDTO;
import com.sample.DTO.EmployeeDTO;
import com.sample.entity.Employee;

public class Mapper {
	
	private List<Employee> employee = new ArrayList<Employee>();

    public Mapper(List<Employee> employees) {
        this.employee = employees;
    }

    public List<EmployeeDTO> map() {
    	// id,  name,  email,  phone, Department department - departId, departName
        List<EmployeeDTO> employeeDTO = employee
        		.stream()
        		.map(o -> new EmployeeDTO(o.getId(),o.getName(),o.getEmail(),o.getPhone(),
        				new DepartmentDTO(o.getDepartment().getDepartmentId(), o.getDepartment().getDepartmentName())))
                .collect(Collectors.toList());
        return employeeDTO;

    }

}
