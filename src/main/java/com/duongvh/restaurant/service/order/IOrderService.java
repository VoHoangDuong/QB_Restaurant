package com.duongvh.restaurant.service.order;

import com.duongvh.restaurant.model.Order;
import com.duongvh.restaurant.service.IGeneralService;

import java.util.Optional;

public interface IOrderService extends IGeneralService<Order> {
    Optional<Order> findByTableId(Long id);

    Optional<Order> findByOrderId(Long id);
}
