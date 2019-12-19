package com.bootproject.sklweb.service;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.entity.Category;

public interface CategoryService {

	APIResponse addOrUpdateCategory(Category category);

	APIResponse getallcategory(String state);

}
