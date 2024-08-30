package com.sallypig.springboot_mall.dao;

import com.sallypig.springboot_mall.model.Product;

public interface ProductDao {

    Product geProductById(Integer productId);
}
