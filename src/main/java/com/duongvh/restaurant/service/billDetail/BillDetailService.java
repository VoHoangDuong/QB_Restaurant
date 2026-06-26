package com.duongvh.restaurant.service.billDetail;


import com.duongvh.restaurant.model.BillDetail;
import com.duongvh.restaurant.repository.IBillDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BillDetailService implements IBillDetailService {
    @Autowired
    private IBillDetailRepository billDetailRepository;

    @Override
    public Iterable<BillDetail> findAll() {
        return billDetailRepository.findAll() ;
    }

    @Override
    public Optional<BillDetail> findById(Long id) {
        return billDetailRepository.findById(id);
    }

    @Override
    public BillDetail save(BillDetail billDetail) {
        return billDetailRepository.save(billDetail);
    }

    @Override
    public void remove(Long id) {
        billDetailRepository.deleteById(id);
    }
}
