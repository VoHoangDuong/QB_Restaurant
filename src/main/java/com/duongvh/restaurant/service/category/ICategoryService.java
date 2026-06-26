package com.duongvh.restaurant.service.category;

import com.duongvh.restaurant.model.Category;
import com.duongvh.restaurant.service.IGeneralService;

import java.util.Optional;

public interface ICategoryService  extends IGeneralService<Category> {

    Optional<Category> findCategoryByCategoryName(String categoryName);
}
