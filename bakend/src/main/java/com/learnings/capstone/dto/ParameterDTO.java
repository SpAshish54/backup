package com.learnings.capstone.dto;

import com.learnings.capstone.entity.ParameterType;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ParameterDTO {

    private String name;

    private String internalName;

    private String details;

    private ParameterType parameterType;

    private String value;

   

    
}