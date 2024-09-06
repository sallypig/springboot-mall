package com.sallypig.springboot_mall.dto;

import com.sallypig.springboot_mall.constant.ProductCategory;

public class ProductQuaryParams {

    private ProductCategory category;
    private String search;

    public ProductCategory getCategory() {
        return this.category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return this.search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

}
