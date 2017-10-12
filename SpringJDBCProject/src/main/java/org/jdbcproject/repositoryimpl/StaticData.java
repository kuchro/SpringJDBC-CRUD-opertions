package org.jdbcproject.repositoryimpl;

public class StaticData {
	public static final String sOneToManyQwerend = "select model_one.id, model_one.name, model_one.number_one, model_one.place, "
			+ "model_many.id,model_many.name_one,model_many.name_two ,model_many.name_three, model_many.number_many, model_many.model_one_id "
			+ "from model_one inner join model_many ON (model_one.id=model_many.model_one_id)";

	public static final String sCreateWihListOfElements = "WITH rows AS("
			+ "INSERT INTO model_one(name,number_one,place)"
			+ "VALUES(?,?,?) RETURNING id)"
			+ "INSERT INTO model_many(name_one,name_two,name_three,number_many,model_one_id) VALUES (?,?,?,?,(SELECT id FROM rows))";;

	public static final String sCreateJustModelOne ="INSERT INTO model_one(name,number_one,place) VALUES(?,?,?)";
	
	public static final String sUpdateOneObject = "UPDATE model_one SET name=?,number_one=?,place=? WHERE id=?";
	public static final String sUpdateModelMany = "UPDATE model_many SET name_one=?,name_two=?,name_three=?,number_many=? WHERE id=?";
}
