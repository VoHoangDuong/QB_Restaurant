package com.duongvh.restaurant.repository;

import com.duongvh.restaurant.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillDetailRepository extends JpaRepository<BillDetail, Long> {
}
