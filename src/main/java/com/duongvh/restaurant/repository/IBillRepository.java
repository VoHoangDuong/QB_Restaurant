package com.duongvh.restaurant.repository;

import com.duongvh.restaurant.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Long> {
	
	int countByBillTime(Date date);
	
	Iterable<Bill> findByBillTime(Date date);
}
