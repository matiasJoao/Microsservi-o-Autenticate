package com.autenticateAPIwithFeingClient.demo.Repository;

import com.autenticateAPIwithFeingClient.demo.DTO.ProductsDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.ProductsPostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "products", url = "localhost:3000")
public interface FeingProductsRepository {
    @GetMapping(value = "/products")
    List<ProductsDTO> getAllProducts();

    @PostMapping(value = "/product/register")
    ProductsPostDTO postProducts(ProductsPostDTO productsPostDTO);

    @GetMapping(value = "/products/pagination")
    ResponseEntity<Object> getallProductsPage();

}
