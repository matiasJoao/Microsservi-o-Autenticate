package com.autenticateAPIwithFeingClient.demo.Service;

import com.autenticateAPIwithFeingClient.demo.DTO.ProductsDTO;
import com.autenticateAPIwithFeingClient.demo.DTO.ProductsPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autenticateAPIwithFeingClient.demo.Repository.FeingProductsRepository;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private FeingProductsRepository feingRepository;

    public List<ProductsDTO> getAllProducts(){
        return  feingRepository.getAllProducts();
    }
    public ProductsPostDTO postProducts(ProductsPostDTO productsPostDTO){
        return feingRepository.postProducts(productsPostDTO);
    }
}
