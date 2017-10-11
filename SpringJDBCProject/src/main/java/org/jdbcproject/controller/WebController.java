package org.jdbcproject.controller;

import java.util.List;

import org.jdbcproject.model.ModelOne;
import org.jdbcproject.services.ReadJdbcServices;
import org.jdbcproject.services.CreateJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	@Autowired
	private ReadJdbcServices service;

	@Autowired
	private CreateJdbcService createService;

	// call uri localhost:8080/SpringJDBC-SAMPLE/ to receive json response
	@GetMapping("/")
	public List<ModelOne> getAllData() {
		return service.getAllDataOneToMany();
	}

	// call uri localhost:8080/SpringJDBC-SAMPLE/create with json request, which u
	// Can find in src/main/resources: create.json
	@PostMapping("/create")
	public ResponseEntity<ModelOne> create(@RequestBody ModelOne modelOne) {
		createService.create(modelOne);
		return new ResponseEntity<ModelOne>(HttpStatus.OK);
	}
}
