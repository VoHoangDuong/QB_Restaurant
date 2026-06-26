package com.duongvh.restaurant.service.orderDetail;

import com.duongvh.restaurant.model.OrderDetail;
import com.duongvh.restaurant.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private IOrderDetailRepository orderDetailRepository;
    @Override
    public Iterable<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void remove(Long id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public Iterable<OrderDetail> findAllByOrderOrderId(Long id) {
        return orderDetailRepository.findAllByOrderOrderId(id);
    }

    @Override
    public Optional<OrderDetail> findByOrderOrderIdAndProductProductId(Long id1, Long id2) {
        return orderDetailRepository.findByOrderOrderIdAndProductProductId(id1,id2);
    }
}
