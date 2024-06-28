package com.example.practice.practice_app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.practice_app.Entity.DataEntity;
import com.example.practice.practice_app.Exception.NoValidDataException;
import com.example.practice.practice_app.Response.DataResponse;
import com.example.practice.practice_app.Service.DataService;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class DataController {


	
	@Autowired
	private DataService dataService;

	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid@RequestBody DataResponse dataEntity) {
		log.info("Entered into the DataController class save method");
		if(dataEntity.getName() != null && dataEntity.getEmail() !=null ) {
			log.info(" with valid object");
			Optional<DataResponse> response = dataService.save(dataEntity);
			if (response.isEmpty()) {
				return ResponseEntity.badRequest().body("Data not Stored");
			}
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} else {
			log.error("with inValid Object");
			throw new NoValidDataException("Not a valid Data") ;
		}
		

	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody DataResponse dataEntity) {
		log.info("Entered into the DataController class update method");
		Optional<DataResponse> response = dataService.update(dataEntity);
		if (response.isEmpty()) {
			log.warn("response is empty");
			return ResponseEntity.badRequest().body("Data not updated");
		}
		log.info("Got the Updated Object");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestHeader int id) {
		log.info("Entered into the DataController class getById method");
		Optional<DataResponse> response = dataService.getById(id);
		if (response.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no data");
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/getByName")
	public ResponseEntity<Optional<DataResponse>> getByName(@RequestHeader String name) {
		log.info("Entered into the DataController class getByName method");
		Optional<DataResponse> response = dataService.getByName(name);
		if (response.isEmpty()) {

		}
		return null;
	}

	@GetMapping("/getByEmail")
	public ResponseEntity<Optional<DataResponse>> getByEmail(@RequestHeader String email) {
		log.info("Entered into the DataController class getByEmail method");
		Optional<DataResponse> response = dataService.getByEmail(email);
		if (response.isEmpty()) {

		}
		return null;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		log.info("Entered into the DataController class getAll method");
		Optional<List<DataResponse>> response = dataService.getAll();
		if (response.isEmpty()) {
			return ResponseEntity.badRequest().body("No data found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteById(@RequestHeader int id) {
		log.info("Entered into the DataController class deleteById method");
		Optional<DataEntity> deleteById = dataService.deleteById(id);
		System.out.println(deleteById);
		if (deleteById.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body("Data deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no data");
		}

	}

}
