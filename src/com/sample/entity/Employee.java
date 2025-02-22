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
