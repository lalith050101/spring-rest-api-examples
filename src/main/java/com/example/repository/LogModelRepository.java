package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.LogModel;

@Repository
public interface LogModelRepository extends JpaRepository<LogModel, String> {

	List<LogModel> findByDate(String date);

}
