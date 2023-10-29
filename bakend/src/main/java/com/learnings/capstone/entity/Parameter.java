package com.learnings.capstone.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Table(name = "parameters")
@Getter
@Setter
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "internal_name")
    private String internalName;

    @Column(name = "details")
    private String details;

    @Enumerated(EnumType.STRING)
    @Column(name = "parameter_type")
    private ParameterType parameterType;

	@Column(name="values")
	private String value;
    
    @ManyToOne
    @JoinColumn(name = "feature_id", nullable = false)
    private Feature feature;


	public Parameter(Long id, String name, String internalName, String details, ParameterType parameterType, String value,
			Feature feature) {
		this.id = id;
		this.name = name;
		this.internalName = internalName;
		this.details = details;
		this.parameterType = parameterType;
		this.feature = feature;
        this.value = value;
	}

    public Parameter(){

	}
}