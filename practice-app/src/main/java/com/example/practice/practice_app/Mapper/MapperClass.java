package com.example.practice.practice_app.Mapper;


import org.springframework.stereotype.Component;

import com.example.practice.practice_app.Entity.DataEntity;
import com.example.practice.practice_app.Response.DataResponse;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class MapperClass {
	
	public DataEntity setData(DataResponse response) {
		log.info("Entered into the MapperClass setData method");
		DataEntity dataEntity= new DataEntity();
		
		dataEntity.setId(response.getId());
		dataEntity.setName(response.getName());
		dataEntity.setEmail(response.getEmail());
		dataEntity.setState(response.getState());
		dataEntity.setCity(response.getCity());
		dataEntity.setGender(response.getGender());
		
		return dataEntity;
	}
	
	public DataResponse setDataResponse(DataEntity entity) {
		log.info("Entered into the MapperClass setDataResponse method");
		DataResponse DataResponse= new DataResponse();
		
		DataResponse.setId(entity.getId());
		DataResponse.setName(entity.getName());
		DataResponse.setEmail(entity.getEmail());
		DataResponse.setState(entity.getState());
		DataResponse.setCity(entity.getCity());
		DataResponse.setGender(entity.getGender());
		
		return DataResponse;
	}

}
