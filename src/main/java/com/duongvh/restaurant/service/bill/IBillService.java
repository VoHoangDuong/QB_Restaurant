package com.duongvh.restaurant.service.bill;

import com.duongvh.restaurant.model.Bill;
import com.duongvh.restaurant.service.IGeneralService;

import java.sql.Date;

public interface IBillService extends IGeneralService<Bill> {
	int countByBillTime(Date date);
	
	Iterable<Bill> findByBillTime(Date date);
}
