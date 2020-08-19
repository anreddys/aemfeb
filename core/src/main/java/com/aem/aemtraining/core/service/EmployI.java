package com.aem.aemtraining.core.service;

import java.util.List;

import com.aem.aemtraining.core.bean.Employees;

public interface EmployI {
	
	public boolean registerEmployeeDetails(Employees emps);	
	public List<Employees> getAllEmployees();
	public boolean loginEmploye();
	public boolean updateEmployee(String name,String age,String email,String weight);
	public boolean deleteEmployee(String name);
	
	
	

}
