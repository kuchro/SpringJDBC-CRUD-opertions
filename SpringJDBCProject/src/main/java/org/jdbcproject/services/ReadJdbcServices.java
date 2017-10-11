package org.jdbcproject.services;

import java.util.List;

import org.jdbcproject.interfaces.ReadInterfaceRepo;
import org.jdbcproject.model.ModelOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadJdbcServices {
	
	@Autowired
	private ReadInterfaceRepo repository;
	
	
	public List <ModelOne> getAllDataOneToMany(){
		return repository.getOneToMamy();
	}

}
