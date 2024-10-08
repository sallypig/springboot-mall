package com.sallypig.springboot_mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sallypig.springboot_mall.dao.ProductDao;
import com.sallypig.springboot_mall.dto.ProductQuaryParams;
import com.sallypig.springboot_mall.dto.ProductRequest;
import com.sallypig.springboot_mall.model.Product;
import com.sallypig.springboot_mall.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public Integer countProduct(ProductQuaryParams productQuaryParams) {
        return productDao.countProduct(productQuaryParams);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productDao.deleteProduct(productId);
    }

    @Override
    public List<Product> getProducts(ProductQuaryParams productQuaryParams) {
        return productDao.getProducts(productQuaryParams);
    }

}
