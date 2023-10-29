package com.learnings.capstone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private String name;

    private String internalName;

    private Long userId;

    private String details;

    private Integer maxProductsPerLocation;

}

