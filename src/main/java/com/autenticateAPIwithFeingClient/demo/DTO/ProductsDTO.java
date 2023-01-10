package com.autenticateAPIwithFeingClient.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {
    private Float price;
    private Integer amount;
    private String type;
    private Integer codigo;
    private String description;


}
