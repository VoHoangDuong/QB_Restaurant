package com.duongvh.restaurant.repository;

import com.duongvh.restaurant.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    Iterable<OrderDetail> findAllByOrderOrderId(Long id);

    Optional<OrderDetail> findByOrderOrderIdAndProductProductId(Long id1, Long id2);
}
