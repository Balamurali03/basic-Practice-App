package com.example.practice.practice_app.Service;

import java.util.List;
import java.util.Optional;

import com.example.practice.practice_app.Entity.DataEntity;
import com.example.practice.practice_app.Response.DataResponse;

public interface DataService {
	
	public Optional<DataResponse> save(DataResponse dataEntity);
	public Optional<DataResponse> update(DataResponse dataEntity);
	public Optional<DataResponse> getById(int id);
	public Optional<DataResponse> getByName(String name);
	public Optional<DataResponse> getByEmail(String email);
	public Optional<List<DataResponse>> getAll();
	public Optional<DataEntity> deleteById(int id);

}
