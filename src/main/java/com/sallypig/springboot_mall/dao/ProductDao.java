package com.sallypig.springboot_mall.dao;

import java.util.List;

import com.sallypig.springboot_mall.constant.ProductCategory;
import com.sallypig.springboot_mall.dto.ProductRequest;
import com.sallypig.springboot_mall.model.Product;

public interface ProductDao {

    List<Product> getProducts(ProductCategory category, String search);

    Product geProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
