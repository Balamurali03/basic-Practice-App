package com.example.practice.practice_app.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.practice_app.Entity.DataEntity;
import com.example.practice.practice_app.Exception.DataNotStoredException;
import com.example.practice.practice_app.Exception.NoDataFoundException;
import com.example.practice.practice_app.Exception.UserAlreadyExistException;
import com.example.practice.practice_app.Exception.UserNotFoundException;
import com.example.practice.practice_app.Mapper.MapperClass;
import com.example.practice.practice_app.Repo.DataRepo;
import com.example.practice.practice_app.Response.DataResponse;
import com.example.practice.practice_app.Service.DataService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class DataServiceImpl implements DataService {

	@Autowired
	private MapperClass mapperClass;

	@Autowired
	private DataRepo dataRepo;

	@Override
	public Optional<DataResponse> save(DataResponse dataEntity) {
		log.info("Entered into the DataServiceImpl class save method");
		boolean value = dataRepo.existsById(dataEntity.getId());
		if (!value) {
			DataResponse dataResponse = mapperClass.setDataResponse(dataRepo.save(mapperClass.setData(dataEntity)));

			Optional<DataResponse> response = Optional.of(dataResponse);

			if (response.isEmpty()) {
				log.error("Throwing DataNotStoredException");
				throw new DataNotStoredException("Data not stored in the database");
			}

			return response;
		} else {
			log.warn("Throwing UserAlreadyExistException");
			throw new UserAlreadyExistException("Data Already exist with this id: " + dataEntity.getId());
		}
	}

	@Override
	public Optional<DataResponse> update(DataResponse dataEntity) {
		log.info("Entered into the DataServiceImpl class update method");
		boolean value = dataRepo.existsById(dataEntity.getId());
		if (value) {
			DataResponse dataResponse = mapperClass.setDataResponse(dataRepo.save(mapperClass.setData(dataEntity)));

			Optional<DataResponse> response = Optional.of(dataResponse);

			if (response.isEmpty()) {
				log.error("Throwing DataNotStoredException");
				throw new DataNotStoredException("Data not stored in the database");
			}

			return response;
		} else {
			log.warn("Throwing UserNotFoundException");
			throw new UserNotFoundException("User not found for this id: " + dataEntity.getId() + " to update !!!");
		}
	}

	@Override
	public Optional<DataResponse> getById(int id) {
		log.info("Entered into the DataServiceImpl class getById method");
		Optional<DataEntity> entry = dataRepo.findById(id);
		if (entry.isEmpty()) {
			log.warn("Throwing UserNotFoundException");
			throw new UserNotFoundException("User not found for this id: " + id);
		} else {
			Optional<DataResponse> response = Optional.of(mapperClass.setDataResponse(entry.get()));
			return response;
		}
	}

	@Override
	public Optional<List<DataResponse>> getAll() {
		log.info("Entered into the DataServiceImpl class getAll method");
		List<DataEntity> entries = dataRepo.findAll();
		if(entries.size()>=0) {
			log.warn("Throwing NoDataFoundException");
			throw new NoDataFoundException("No data avilable to show");
		} else {
			List<DataResponse> allResponse = new ArrayList<>();
			for (DataEntity entry : entries) {
				allResponse.add(mapperClass.setDataResponse(entry));
			}
			return Optional.of(allResponse);
		}	
		
	}

	@Override
	public Optional<DataEntity> deleteById(int id) {
		log.info("Entered into the DataServiceImpl class deleteById method");
		Optional<DataEntity> entry = dataRepo.findById(id);
		if (entry.isEmpty()) {
			log.warn("Throwing NoDataFoundException");
			throw new NoDataFoundException("No data avilable to get in this id: " + id);
		} else {
			dataRepo.delete(entry.get());
			return entry;
		}

	}

	@Override
	public Optional<DataResponse> getByName(String name) {
		log.info("Entered into the DataServiceImpl class getByName method");
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<DataResponse> getByEmail(String email) {
		log.info("Entered into the DataServiceImpl class getByEmail method");
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
