package com.duongvh.restaurant.service.desk;

import com.duongvh.restaurant.model.Desk;
import com.duongvh.restaurant.service.IGeneralService;
import org.springframework.data.repository.query.Param;

public interface IDeskService extends IGeneralService<Desk> {
    Iterable<Desk> findAllByCustomIsTrue(Long id);

    Iterable<Desk> findAllDeskSplit(@Param("id") Long id);

}
