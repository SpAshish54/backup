package com.learnings.capstone.entity;


import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "internal_name")
    private String internalName;

    @Column(name = "details")
    private String details;
    
    @JoinColumn(name = "user_id")
    private Long userId;

    @Column(name = "max_products_per_location")
    private Integer maxProductsPerLocation;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Feature> features;

	
    public Product() {
    }

    public Product(Long id, String name, String internalName, String details, Integer maxProductsPerLocation) {
        this.id = id;
        this.name = name;
        this.internalName = internalName;
        this.details = details;
        this.maxProductsPerLocation = maxProductsPerLocation;
    }
    
}
