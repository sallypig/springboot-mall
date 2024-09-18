package com.sallypig.springboot_mall.model;

import java.util.Date;

import com.sallypig.springboot_mall.constant.ProductCategory;

public class Product {

    private Integer productId;
    private String productName;
    private ProductCategory category;
    private String imageUrl;
    private Integer price;
    private Integer stock;
    private String description;
    private Date createdDate;
    private Date last_modifiedDate;

    public Integer getProductId() {
        return this.productId;
    }

    public void setProduct_id(Integer product_id) {
        this.productId = product_id;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductCategory getCategory() {
        return this.category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLast_modifiedDate() {
        return this.last_modifiedDate;
    }

    public void setLast_modifiedDate(Date last_modifiedDate) {
        this.last_modifiedDate = last_modifiedDate;
    }

}
