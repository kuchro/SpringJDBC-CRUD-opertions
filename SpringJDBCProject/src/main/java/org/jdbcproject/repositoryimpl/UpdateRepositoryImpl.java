package org.jdbcproject.repositoryimpl;

import org.jdbcproject.model.ModelMany;
import org.jdbcproject.model.ModelOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.jdbcproject.repositoryimpl.StaticData.*;


@Repository
public class UpdateRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTEmplate;

    public ModelOne updateOne(ModelOne modelOne){
        return  updateObject(modelOne);
    }

    public int[] updateMany(ModelOne modelOne){
        return updateManyObjects(modelOne);
    }

/*update one object - parent*/
private ModelOne updateObject(ModelOne modelOne){

    jdbcTEmplate.update(sUpdateOneObject,modelOne.getName(),modelOne.getNumber(),modelOne.getPlace(), modelOne.getId());
    return modelOne;
}
/*update many objects from parent object*/
private int[]  updateManyObjects(ModelOne modelOne){
    List<ModelMany> list = modelOne.getModelMany();
    int[] listOfObjects = jdbcTEmplate.batchUpdate(sUpdateModelMany, new BatchPreparedStatementSetter() {
        @Override
        public void setValues(PreparedStatement ps, int i) throws SQLException {
                ModelMany  modelObject = list.get(i);
                ps.setString(1,modelObject.getNameOne());
                ps.setString(2,modelObject.getNameTwo());
                ps.setString(3,modelObject.getNameThree());
                ps.setInt(4,modelObject.getNumber());
                ps.setInt(5,modelObject.getId());
        }

        @Override
        public int getBatchSize() {
            return list.size();
        }
    });
    return listOfObjects;
}

}
