package org.jdbcproject.repoRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbcproject.model.ModelMany;
import org.springframework.jdbc.core.RowMapper;

public class ModelManyRowMapper implements RowMapper<ModelMany>{

	@Override
	public ModelMany mapRow(ResultSet rs, int rowNum) throws SQLException {
		ModelMany manyItems = new ModelMany();
		manyItems.setId(rs.getInt("id"));
		manyItems.setNameOne(rs.getString("name_one"));
		manyItems.setNameTwo(rs.getString("name_two"));
		manyItems.setNameThree(rs.getString("name_three"));
		manyItems.setNumber(rs.getInt("number_many"));
		
		return manyItems;
	}
	
}