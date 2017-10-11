package org.jdbcproject.repositoryimpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.jdbcproject.interfaces.CreateInterfaceRepo;
import org.jdbcproject.model.ModelMany;
import org.jdbcproject.model.ModelOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreateRepositoryImpl implements CreateInterfaceRepo {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ModelOne createData(ModelOne modelOne) {
		return createModelOneToMany(modelOne);
	}

	
	
	private ModelOne createModelOneToMany(ModelOne modelOne) {
		List<ModelMany> modelManyList = modelOne.getModelMany();
		String sql;
		if(modelManyList.isEmpty()) {
			sql = StaticData.sCreateJustModelOne;
		}else {
			sql = StaticData.sCreateWihListOfElements;
		}
		StringBuffer buildSql = new StringBuffer(sql);
		if(modelManyList.size()>0) {
			for(int i=1;i<modelManyList.size();i++) {
				buildSql.append(",(?,?,?,?,(SELECT id FROM ROWS))");
			}
		}
		jdbcTemplate.batchUpdate(buildSql.toString(), new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setObject(1, modelOne.getName());
				ps.setObject(2, modelOne.getNumber());
				ps.setObject(3, modelOne.getPlace());
				
				int j=4;
				for(int k=0; k<modelManyList.size();k++) {
					ModelMany modelMany = modelManyList.get(i);
					ps.setObject(j++, modelMany.getNameOne());
					ps.setObject(j++, modelMany.getNameTwo());
					ps.setObject(j++, modelMany.getNameThree());
					ps.setObject(j++, modelMany.getNumber());
					i+=1;
				}
				
			}

			@Override
			public int getBatchSize() {
				return 1;
			}
			
		});
		
		return modelOne;
	}
}
