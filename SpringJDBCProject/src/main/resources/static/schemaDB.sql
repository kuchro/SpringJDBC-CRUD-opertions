CREATE TABLE model_one(
id serial,
name VARCHAR(150),
number_one int,
place VARCHAR(150),
PRIMARY KEY(id));


CREATE TABLE model_many(
id serial,
name_one VARCHAR(150),
name_two VARCHAR(150),
name_three VARCHAR(150),
number_many int,
model_one_id int,
PRIMARY KEY(id),
FOREIGN KEY(model_one_id) REFERENCES model_one(id) ON DELETE CASCADE);


