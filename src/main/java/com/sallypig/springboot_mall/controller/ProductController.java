package com.sallypig.springboot_mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sallypig.springboot_mall.constant.ProductCategory;
import com.sallypig.springboot_mall.dto.ProductQuaryParams;
import com.sallypig.springboot_mall.dto.ProductRequest;
import com.sallypig.springboot_mall.model.Product;
import com.sallypig.springboot_mall.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // restful理念：不論productList是否存在 只要@GetMapping("/products")這資源存在，就是回200
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search
    ) {
        ProductQuaryParams productQuaryParams = new ProductQuaryParams();
        productQuaryParams.setCategory(category);
        productQuaryParams.setSearch(search);

        List<Product> product = productService.getProducts(productQuaryParams);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(product);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.geProductById(productId);
        System.out.println(product);
        if (product != null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(product);
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.geProductById(productId);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId, @RequestBody ProductRequest productRequest) {
        // 檢查 product 是否存在
        Product product = productService.geProductById(productId);
        if (product == null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }

        // 修改商品的數據
        productService.updateProduct(productId, productRequest);

        Product updatedProduct = productService.geProductById(productId);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(updatedProduct);
    }

    // 刪除，無論是否有刪到商品，只要商品不存在 都是回傳204，才是正確的後端設計
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {

        productService.deleteProduct(productId);

        return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
    }
}
