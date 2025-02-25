# java-stream-api-samples

**Java Stream API Examples** - How to convert List of objects to another List of objects using Java streams?
In this section, we will show you how to convert a List of objects to another List of objects in Java using the Java streams map(). The ‘map’ method maps each element to its corresponding result.

## Java Stream API 
The Java Stream API provides a functional programming approach over the object oriented capabilities of Java. It is used for processing collections of objects. The Stream in Java can be defined as a sequence of elements from a source List, Set or Array. Most of the stream operations return a Stream. This avails engender a chain of stream operations(stream pipe-lining). The streams withal support the aggregate or terminal operations on the elements. for example, finding the sum or maximum element or finding the average etc...Stream operations can either be executed sequentially or parallel. when performed parallelly, it is called a parallel stream. 

## Stream map() Method 
The Java 8 Stream map() is an intermediate operation. It converts Stream<obj1> to Stream<obj2>. For each object of type obj1, a new object of type obj2 is created and put in the new Stream. The map() operation takes a Function, which is called for each value in the input stream and produces one result value, which is sent to the output stream. The stream map method takes Function as an argument that is a functional interface.

## Example 1- Convert List of Employee to List of EmployeeDTO

<details>
<summary>Code Section</summary>

## Employee.java 

package com.sample.entity;
public class Employee {
    private int id;
    private String name;
    private String email;
    private String phone;
    private Department department;
    
    public Employee(int id, String name, String email, String phone, Department department) {
    	this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department =  department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", department="+ department + "]";
	}
}
 
## Department

package com.sample.entity;
public class Department {
    private int  departmentId;
    private String departmentName;
    
    public Department(int departmentId, String departmentName) {
    	this.departmentId =  departmentId;
    	this.departmentName = departmentName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}	
}

## EmployeeDTO

package com.sample.DTO;
public class EmployeeDTO {
	
    private int id;
    private String name;
    private String email;
    private String phone;
    private DepartmentDTO departmentDTO;
    
    public EmployeeDTO( int id, String name, String email, String phone, DepartmentDTO department) {
    	this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.departmentDTO =  department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}

	public void setDepartmentDTO(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", departmentDTO="
				+ departmentDTO + "]";
	}
}

## DepartmentDTO

package com.sample.DTO;
public class DepartmentDTO {
    private int  departmentId;
    private String departmentName;
    
    public DepartmentDTO(int departmentId, String departmentName) {
    	this.departmentId =  departmentId;
    	this.departmentName = departmentName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
}

## Mapper

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

## StreamApiSample

import java.util.Arrays;
import java.util.List;
import com.sample.entity.Department;
import com.sample.entity.Employee;
import com.sample.mapper.Mapper;

public class StreamApiSample {
	public static void main(String arg[]) {
		System.out.println("Convert List of Employee to List of EmployeeDTO");
		
		List<Employee> listOfEmployee = Arrays.asList(
				new Employee(1, "Saravanan", "Saravanan@test.com", "01234567890", new Department(1, "Computer Science")),
				new Employee(2, "Seenu", "Seenu@test.com", "12345678900", new Department(2, "Civil Engineering")),
				new Employee(3, "Ramu", "Ramu@test.com", "23456789001", new Department(1, "Computer Science")),
				new Employee(4, "Shankar", "Shankar@test.com", "34567890012", new Department(3, "Mechanical Engineering")),
				new Employee(5, "Seyon", "Seyon@test.com", "45678900123", new Department(1, "Computer Science")),
				new Employee(6, "Tharun", "Tharun@test.com", "56789001234", new Department(2, "Civil Engineering")),
				new Employee(7, "Arun", "Arun@test.com", "67890012345", new Department(1, "Computer Science")),
				new Employee(8, "Karthik", "Karthik@test.com", "78900123456", new Department(4, "EEE Engineering")),
				new Employee(9, "Kumar", "Kumar@test.com", "89001234567", new Department(1, "Computer Science")),
				new Employee(10, "Vignesh", "Vignesh@test.com", "90012345678", new Department(4, "EEE Engineering"))
				); 
		
		Mapper mapper = new Mapper(listOfEmployee);
		mapper.map().stream().forEach(emp -> System.out.println(emp));
	}
}

## Output

Convert List of Employee to List of EmployeeDTO

EmployeeDTO [id=1, name=Saravanan, phone=01234567890, departmentDTO=DepartmentDTO]</br>
EmployeeDTO [id=2, name=Seenu, phone=12345678900, departmentDTO=DepartmentDTO]</br>
EmployeeDTO [id=3, name=Ramu, phone=23456789001, departmentDTO=DepartmentDTO </br>
EmployeeDTO [id=4, name=Shankar, phone=34567890012, departmentDTO=DepartmentDTO </br>
EmployeeDTO [id=5, name=Seyon, phone=45678900123, departmentDTO=DepartmentDTO </br>
EmployeeDTO [id=6, name=Tharun, phone=56789001234, departmentDTO=DepartmentDTO </br>
EmployeeDTO [id=7, name=Arun, phone=67890012345, departmentDTO=DepartmentDTO </br>
EmployeeDTO [id=8, name=Karthik, phone=78900123456, departmentDTO=DepartmentDTO </br>
EmployeeDTO [id=9, name=Kumar, phone=89001234567, departmentDTO=DepartmentDTO </br>
EmployeeDTO [id=10, name=Vignesh, phone=90012345678, departmentDTO=DepartmentDTO </br>
</details>

## Example 2- Convert List of String to List of Integer
<details>
	<summary>Code Section</summary>

## StreamApiSample
 
import java.util.Arrays;
import java.util.List;
import com.sample.entity.Department;
import com.sample.entity.Employee;
import com.sample.mapper.Mapper;
public class StreamApiSample {
	public static void main(String arg[]) {
		System.out.println("Convert List of String to List of Integer");
		Mapper mapper = new Mapper(listOfEmployee);
		mapper.map().stream().forEach(emp -> System.out.println(emp));
		List<String> list = Arrays.asList( "8" , "7", "36", "2" );
	        List<Integer> intList = list.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
	        intList.stream().forEach(obj -> System.out.println(obj));    
	}
}



## Output

Convert List of String to List of Integer
8
7
36
2
</details>

## Example 3- List of Employees by department
<details>
	<summary>Code Section</summary>

## StreamApiSample
 
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.sample.DTO.EmployeeDTO;
import com.sample.entity.Department;
import com.sample.entity.Employee;
import com.sample.mapper.Mapper;
public class StreamApiSample {
	public static void main(String arg[]) {
		System.out.println("Convert List of Employee to List of EmployeeDTO");
		List<Employee> listOfEmployee = Arrays.asList(
				new Employee(1, "Saravanan", "Saravanan@test.com", "01234567890", new Department(1, "Computer Science")),
				new Employee(2, "Seenu", "Seenu@test.com", "12345678900", new Department(2, "Civil Engineering")),
				new Employee(3, "Ramu", "Ramu@test.com", "23456789001", new Department(1, "Computer Science")),
				new Employee(4, "Shankar", "Shankar@test.com", "34567890012", new Department(3, "Mechanical Engineering")),
				new Employee(5, "Seyon", "Seyon@test.com", "45678900123", new Department(1, "Computer Science")),
				new Employee(6, "Tharun", "Tharun@test.com", "56789001234", new Department(2, "Civil Engineering")),
				new Employee(7, "Arun", "Arun@test.com", "67890012345", new Department(1, "Computer Science")),
				new Employee(8, "Karthik", "Karthik@test.com", "78900123456", new Department(4, "EEE Engineering")),
				new Employee(9, "Kumar", "Kumar@test.com", "89001234567", new Department(1, "Computer Science")),
				new Employee(10, "Vignesh", "Vignesh@test.com", "90012345678", new Department(4, "EEE Engineering"))
				); 
		Mapper mapper = new Mapper(listOfEmployee);
		mapper.map().stream().forEach(emp -> System.out.println(emp));
		Map<String, List<EmployeeDTO>> listOfEmpByDep = mapper.map().stream()
				.collect(Collectors.groupingBy(empDTO -> empDTO.getDepartmentDTO().getDepartmentName()));
		System.out.println("------List of Employees by department------");
		listOfEmpByDep.forEach((departmentName, empList) -> System.out.println(departmentName +", "+ empList));
		System.out.println("------Employees count based department-----");
		Map<String, Long> listOfEmpByDepCount = mapper
				.map()
				.stream()
				.collect(Collectors.groupingBy(empDTO -> 
				empDTO.getDepartmentDTO().getDepartmentName(), 
				Collectors.counting()));
		listOfEmpByDepCount.forEach((departmentName, empCount) -> System.out.println(departmentName +", "+ empCount));	
	}
}
</details>
