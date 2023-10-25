package com.learnings.capstone.dto;

import lombok.Data;

@Data
public class FeatureDTO {

    private String name;

    private String internalName;

    private String details;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        FeatureDTO featureDTO = (FeatureDTO) obj;

        if (name != null ? !name.equals(featureDTO.name) : featureDTO.name != null) return false;
        if (internalName != null ? !internalName.equals(featureDTO.internalName) : featureDTO.internalName != null)
            return false;
        return details != null ? details.equals(featureDTO.details) : featureDTO.details == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (internalName != null ? internalName.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FeatureDTO{" +
                "name='" + name + '\'' +
                ", internalName='" + internalName + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public boolean canEqual(Object obj) {
        return obj instanceof FeatureDTO;
    }
}

