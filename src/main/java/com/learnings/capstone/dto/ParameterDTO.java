package com.learnings.capstone.dto;

import com.learnings.capstone.entity.ParameterType;

public class ParameterDTO {

    private String name;

    private String internalName;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String details;

    private ParameterType parameterType;

    private String value;

    // Getter and Setter methods for each field

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

    public ParameterType getParameterType() {
        return parameterType;
    }

    public void setParameterType(ParameterType parameterType) {
        this.parameterType = parameterType;
    }
}