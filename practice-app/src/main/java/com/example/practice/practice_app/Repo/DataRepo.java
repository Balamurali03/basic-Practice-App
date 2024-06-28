package com.example.practice.practice_app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.practice.practice_app.Entity.DataEntity;

public interface DataRepo extends JpaRepository<DataEntity,Integer> {
	
	

}
