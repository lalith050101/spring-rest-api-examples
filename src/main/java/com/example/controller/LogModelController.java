package com.example.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.LogModel;
import com.example.repository.LogModelRepository;

@RestController
public class LogModelController {

	@Autowired
	LogModelRepository logModelRepository;
	
	@GetMapping("/checkIn")
	public ResponseEntity<LogModel> checkIn(@RequestParam String name) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); 
		Date date = new Date();
				
		LogModel logModel = new LogModel();
		
		logModel.setName(name);
		logModel.setLogType("IN");
		logModel.setDate(dateFormat.format(date));
		logModel.setTime(timeFormat.format(date));
		logModel.setId(logModel.getName()+logModel.getTime());
		
		return new ResponseEntity<LogModel>( logModelRepository.save(logModel), HttpStatus.CREATED);
	}
	
	@GetMapping("/checkOut")
	public ResponseEntity<LogModel> checkOut(@RequestParam String name) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); 
		Date date = new Date();
				
		LogModel logModel = new LogModel();
		
		logModel.setName(name);
		logModel.setLogType("OUT");
		logModel.setDate(dateFormat.format(date));
		logModel.setTime(timeFormat.format(date));
		logModel.setId(logModel.getName()+logModel.getTime());
		
		return new ResponseEntity<LogModel>( logModelRepository.save(logModel), HttpStatus.CREATED);
	}
	
	@GetMapping("getLog")
	public ResponseEntity<List<LogModel>> getLogByDate(@RequestParam String date) {
		return new ResponseEntity<List<LogModel>> (logModelRepository.findByDate(date) , HttpStatus.OK);
	}
	
	@GetMapping("getAllLog")
	public ResponseEntity<List<LogModel>> getAllLog() {
		return new ResponseEntity<List<LogModel>> (logModelRepository.findAll(), HttpStatus.OK);
	}
	
}
