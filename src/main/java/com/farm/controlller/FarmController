package com.farm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;
import org.sl4j.Logger;
import org.sl4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import com.farm.dto.FarmData;
import jakarta.validation.Valid;

@RestController
public class FarmController {

	private static final Logger log = LoggerFactory.getLogger(FarmController.class);

	//This API is used to calculate the expected amount of each crop
	@PostMapping("/planted", consumes = { MediaType.APPLICATION_JSON_VALUE })
	//Validating JSON Request for Null checks
	public Map<String,Object> planted(@Valid @RequestBody FarmData plantationReq) {
		
		//this map will have the final response with details including crop and its expected amount
		Map<String,Object> plantationResponse = new HashMap<>();
		try{
			//Fetching total plantation area of a farm from Request
			Double plantationArea = plantationReq.getPlantingArea();
			
//Fetching crops planted in a farm with their quantity from request
			Map<String,Double> cropDetails = plantationReq.getCropTypes();

			//This loop will fetch the expected amount for each crop and store it in final response
			for(Map.Entry<String,Double> cropData : cropDetails.entrySet()){
				Double expectedAmount = plantationArea *  cropData.getValue();
				plantationResponse.put(cropData.getKey(), expectedAmount);
			}
		
		} catch(Exception e){
			//catching exceptions for any failures
			log.error("Error while calling Planted API", e);
			
		}
		

		return plantationResponse;
	}

	
	//This API is used to calculate the harvested amount of each crop
	@PostMapping("/harvested", consumes = { MediaType.APPLICATION_JSON_VALUE })
	//Validating JSON Request for Null checks
	public Map<String,Object> harvested(@Valid @RequestBody FarmData harvestedReq) {
		
		//this map will have the final response with details including crop and its actual harvested amount
		Map<String,Object> harvestedResponse = new HashMap<>();
		try{
			//Fetching total plantation area of a farm from Request
			Double plantationArea = harvestedReq.getPlantingArea();
			
//Fetching crops planted in a farm with their quantity from request
			Map<String,Double> cropDetails = harvestedReq.getCropTypes();

			//This loop will fetch the harvested amount for each crop and store it in final response
			for(Map.Entry<String,Double> cropData : cropDetails.entrySet()){
				Double harvestedAmount = cropData.getValue()/plantationArea;
				harvestedResponse.put(cropData.getKey(), harvestedAmount);
			}
		
		} catch(Exception e){
			//catching exceptions for any failures
			log.error("Error while calling Harvested API", e);
			
		}
		

		return harvestedResponse;
	}

}
