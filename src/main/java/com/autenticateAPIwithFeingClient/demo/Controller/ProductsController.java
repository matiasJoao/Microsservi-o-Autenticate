package com.autenticateAPIwithFeingClient.demo.Controller;

import com.autenticateAPIwithFeingClient.demo.DTO.ProductsDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.ProductsPostDTO;
import com.autenticateAPIwithFeingClient.demo.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    @RequestMapping("/productsList")
    public List<ProductsDTO> getAllProducts(){
        return productsService.getAllProducts();
    }
    @GetMapping("/product/page")
    public ResponseEntity<Object> getAllProductsPage(){
        return productsService.getAllProductsPage();
    }

    @PostMapping
    @RequestMapping("/postProducts")
    public ProductsPostDTO postProducts(@RequestBody ProductsPostDTO productsPostDTO){
        return productsService.postProducts(productsPostDTO);
    }

}
