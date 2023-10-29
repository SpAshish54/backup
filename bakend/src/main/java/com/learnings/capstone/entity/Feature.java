package com.learnings.capstone.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "features")
@Getter
@Setter
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "internal_name")
    private String internalName;

    @Column(name = "details")
    private String details;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(mappedBy = "feature", cascade = CascadeType.ALL)
    private List<Parameter> parameters;

	public Feature() {
        this.parameters = new ArrayList<>();
    }

	
	public Feature(Long id, String name, String internalName, String details, Product product,
			List<Parameter> parameters) {
		this.id = id;
		this.name = name;
		this.internalName = internalName;
		this.details = details;
		this.product = product;
		this.parameters = parameters;
	}
    
    
}