package com.learnings.capstone.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
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

    @Column(name = "max_products_per_location")
    private Integer maxProductsPerLocation;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Feature> features;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInternalName() {
		return internalName;
	}

	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getMaxProductsPerLocation() {
		return maxProductsPerLocation;
	}

	public void setMaxProductsPerLocation(Integer maxProductsPerLocation) {
		this.maxProductsPerLocation = maxProductsPerLocation;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
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
