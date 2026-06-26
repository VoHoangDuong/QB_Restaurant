package com.duongvh.restaurant.service.orderDetail;

import com.duongvh.restaurant.model.OrderDetail;
import com.duongvh.restaurant.service.IGeneralService;

import java.util.Optional;

public interface IOrderDetailService extends IGeneralService<OrderDetail> {

    Iterable<OrderDetail> findAllByOrderOrderId(Long id);

    Optional<OrderDetail> findByOrderOrderIdAndProductProductId(Long id1, Long id2);

}
