package org.jdbcproject.services;

import org.jdbcproject.interfaces.CreateInterfaceRepo;
import org.jdbcproject.model.ModelOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJdbcService {
	
	@Autowired
	private CreateInterfaceRepo createRepo;
	
	public ModelOne create(ModelOne modelOne) {
		return createRepo.createData(modelOne);
	}

}
