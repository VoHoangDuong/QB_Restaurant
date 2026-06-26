package com.duongvh.restaurant.service.employee;

import com.duongvh.restaurant.model.Employee;
import com.duongvh.restaurant.service.IGeneralService;


public interface IEmpService extends IGeneralService<Employee> {
	
	int countEmployee();
	
	int countByStatusFalse();
}
