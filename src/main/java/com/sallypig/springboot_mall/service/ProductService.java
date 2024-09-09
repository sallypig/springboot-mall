package com.sallypig.springboot_mall.service;

import java.util.List;

import com.sallypig.springboot_mall.dto.ProductQuaryParams;
import com.sallypig.springboot_mall.dto.ProductRequest;
import com.sallypig.springboot_mall.model.Product;

public interface ProductService {

    Integer countProduct(ProductQuaryParams productQuaryParams);

    List<Product> getProducts(ProductQuaryParams productQuaryParams);

    Product geProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
