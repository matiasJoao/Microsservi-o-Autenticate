package com.autenticateAPIwithFeingClient.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductsPostDTO {
    private String description;
    private Float price;
    private Integer amount;
    private String type;

}
