package com.bootproject.sklweb.service;

import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.entity.Product;

public interface ProductService {

	void getItem();

	APIResponse addOrUpdateProduct(Product product);

}
