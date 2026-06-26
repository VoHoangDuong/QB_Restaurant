package com.duongvh.restaurant.service.product;

import com.duongvh.restaurant.model.Product;
import com.duongvh.restaurant.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findAllByOrderByProductIdDesc();

    void deleteProductById(@Param("id") Long id);

    Iterable<Product> findAllByOrderByProductHiddenDesc();

    void restoreProductById(@Param("id") Long id);

    Optional<Product> findByProductName(String productName);
    
    int countByStatusTrue();

    Iterable<Product> findAllByCategoryCategoryId(Long id);

    Optional<Product> findPriceByOrdOrderByProductId(Long id);
}
