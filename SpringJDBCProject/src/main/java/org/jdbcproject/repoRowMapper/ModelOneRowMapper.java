package org.jdbcproject.repoRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jdbcproject.model.ModelOne;
import org.springframework.jdbc.core.RowMapper;

public class ModelOneRowMapper implements RowMapper<ModelOne> {

	@Override
	public ModelOne mapRow(ResultSet rs, int rowNum) throws SQLException {
		ModelOne obModel = new ModelOne();
		obModel.setId(rs.getInt("id"));
		obModel.setName(rs.getString("name"));
		obModel.setNumber(rs.getInt("number_one"));
		obModel.setPlace(rs.getString("place"));
		//dont fofget to set this empty array list, otherwise U will get NullPointerException exception
		obModel.setModelMany(new ArrayList<>());

		return  obModel;
	}

}
