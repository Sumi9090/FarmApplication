package com.farm.dto;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


@JsonInclude(JsonInclude.Include.NOT_NULL)
@JsonPropertyOrder({
	"farmName",
	"cropTypes",
	"plantingArea",

})

@Generated("jsonschema2pojo")
public class FarmData implements Serializable{

	@JsonProperty("farmName")
	@Valid
	@NotNull(message="Please provide farm name")
	private String farmName;
	
	@JsonProperty("cropTypes")
	@Valid
	@NotNull(message="Please provide crop details")
	private Map<String,Double> cropTypes;
	
	@JsonProperty("plantingArea")
	@Valid
	@NotNull(message="Please provide planting Area")
	private Double plantingArea;
	
	public String getFarmName(){
		return farmName;
	}

	public void setFarmName(String farmName){
		this.farmName = farmName;
	}
	
	public Map<String,Double> getCropTypes(){
		return cropTypes;
	}

	public void setCropTypes(Map<String,Double> cropTypes){
		this.cropTypes = cropTypes;
	}
	
	public Double getPlantingArea(){
		return plantingArea;
	}

	public void setPlantingArea(Double plantingArea){
		this.plantingArea = plantingArea;
	}


}
