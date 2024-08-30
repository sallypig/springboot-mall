package com.sallypig.springboot_mall.service;

import com.sallypig.springboot_mall.dto.ProductRequest;
import com.sallypig.springboot_mall.model.Product;

public interface ProductService {

    Product geProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
