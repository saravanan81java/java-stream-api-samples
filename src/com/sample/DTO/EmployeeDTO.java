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
