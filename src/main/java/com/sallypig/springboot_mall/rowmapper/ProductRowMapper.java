package com.sallypig.springboot_mall.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sallypig.springboot_mall.constant.ProductCategory;
import com.sallypig.springboot_mall.model.Product;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));

        // String categoryStr = resultSet.getString("category");
        // ProductCategory category = ProductCategory.valueOf(categoryStr);
        // product.setCategory(category);
        product.setCategory(ProductCategory.valueOf(resultSet.getString("category")));
        // 若是資料庫中的值非ProductCategory:(FOOD) 會回500，有幫助看資料庫是否受汙染

        product.setImageUrl(resultSet.getString("image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));
        product.setCreatedDate(resultSet.getTimestamp("created_date"));
        product.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return product;
    }

}
