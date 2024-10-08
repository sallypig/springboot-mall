package com.sallypig.springboot_mall.dao;

import java.util.List;

import com.sallypig.springboot_mall.dto.ProductQuaryParams;
import com.sallypig.springboot_mall.dto.ProductRequest;
import com.sallypig.springboot_mall.model.Product;

public interface ProductDao {

    Integer countProduct(ProductQuaryParams productQuaryParams);

    List<Product> getProducts(ProductQuaryParams productQuaryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);

    void updateStock(Integer productId, Integer stock);
}
