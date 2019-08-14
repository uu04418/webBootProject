package com.bootproject.sklweb.mapper;


import com.bootproject.sklweb.entity.Employee;

public interface EmployeeMapper {
	
	 Employee getEmpById(int id); 
	 
	 void insertEmployee (Employee employee);

}
