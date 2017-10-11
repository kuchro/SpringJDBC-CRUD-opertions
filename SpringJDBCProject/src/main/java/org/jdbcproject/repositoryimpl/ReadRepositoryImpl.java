package org.jdbcproject.repositoryimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdbcproject.interfaces.ReadInterfaceRepo;
import org.jdbcproject.model.ModelMany;
import org.jdbcproject.model.ModelOne;
import org.jdbcproject.repoRowMapper.ModelManyRowMapper;
import org.jdbcproject.repoRowMapper.ModelOneRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ReadRepositoryImpl implements ReadInterfaceRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<ModelOne> getOneToMamy(){
		return getOneToManyData(StaticData.sOneToManyQwerend);
	}
	
	
	private List<ModelOne> getOneToManyData(String  query) {
		final Map<Integer,ModelOne> mapAll = new HashMap<>();
		
		this.jdbcTemplate.query(query, new RowMapper<ModelMany>() {

			@Override
			public ModelMany mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer modelOneId = rs.getInt("id");
				ModelOne one = mapAll.get(modelOneId);
				if(one==null) {
					ModelOneRowMapper rowMapperOne = new ModelOneRowMapper();
					one = rowMapperOne.mapRow(rs, rowNum);
					mapAll.put(modelOneId, one);
				}
				ModelManyRowMapper rowMapperMany = new ModelManyRowMapper();
				ModelMany many  = rowMapperMany.mapRow(rs, rowNum);
				many.setModelOneId(modelOneId);
				one.getModelMany().add(many);
				return many;
				
			}

		});
		// sort list
		List<ModelOne> result = new ArrayList<>(mapAll.values());
		Collections.sort(result, new Comparator<ModelOne>() {
			@Override
			public int compare(ModelOne r1, ModelOne r2) {
				return r1.getId() - r2.getId();
			}

		});

		return result;

	}
	
}
