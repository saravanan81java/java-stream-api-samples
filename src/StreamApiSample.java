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
