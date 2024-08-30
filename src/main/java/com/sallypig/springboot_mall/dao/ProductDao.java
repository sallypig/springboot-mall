package com.sallypig.springboot_mall.dao;

import java.util.List;

import com.sallypig.springboot_mall.dto.ProductRequest;
import com.sallypig.springboot_mall.model.Product;

public interface ProductDao {

    List<Product> getProducts();

    Product geProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
