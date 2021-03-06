
DROP TABLE users;
DROP TABLE userlogintoken;
DROP TABLE spendtime;
DROP TABLE spendtimetips;
DROP TABLE surveytag;
DROP TABLE surveycategory;
drop table survey;

CREATE TABLE users (
	id int NOT NULL AUTO_INCREMENT, 
	email VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	dateofbirth date,
	regdate date,
	role int not null,
	imgpath VARCHAR(255) null,
	PRIMARY KEY(id),
	CONSTRAINT uniqueEmail UNIQUE (email)
);

CREATE TABLE userlogintoken (
	id int NOT NULL AUTO_INCREMENT, 
	email VARCHAR(50),
	generated_token VARCHAR(50),
	expiration_date VARCHAR(50),
	PRIMARY KEY(id),
	CONSTRAINT uniqueToken UNIQUE (generated_token)
);
CREATE TABLE spendtimetips(
id int auto_increment not null,
label varchar(50),
descrizione varchar(50),
primary key(id)
);
CREATE TABLE spendtime(
id int not null auto_increment,
userID int not null,
data VARCHAR(30) not null,
ora int,
tipoOre int,
UNIQUE(id,data),
primary key(id),
FOREIGN KEY (tipoOre) REFERENCES spendtimetips (id)
);

create table survey(
    id int primary key not null auto_increment,
    question varchar(255),
    ANSA VARCHAR(255) NOT NULL DEFAULT "",
	ANSB VARCHAR(255) NOT NULL DEFAULT "",
	ANSC VARCHAR(255) NOT NULL DEFAULT "",
	ANSD VARCHAR(255) NOT NULL DEFAULT "",
	ANSE VARCHAR(255) NOT NULL DEFAULT "",
	ANSF VARCHAR(255) NOT NULL DEFAULT "",
	CANSA BIT(1) DEFAULT 0,
	CANSB BIT(1) DEFAULT 0,
	CANSC BIT(1) DEFAULT 0,
	CANSD BIT(1) DEFAULT 0,
	CANSE BIT(1) DEFAULT 0,
	CANSF BIT(1) DEFAULT 0
);
insert into survey(question) values('Java');
insert into survey(question) values('Spring');
insert into survey(question) values('Java EE');
insert into survey(question) values('Hibernate');

CREATE TABLE surveycategory(
	id int primary key not null auto_increment,
	label VARCHAR(50) NOT NULL,
	description VARCHAR(100)
);
INSERT INTO surveycategory(label, description) 
VALUES('Java Capitolo 1', 'Questionario Certificazione Java Capitolo 1');
INSERT INTO surveycategory(label, description) 
VALUES('Java Capitolo 2', 'Questionario Certificazione Java Capitolo 2');


create table surveytag (
    survey_tag_map_id int primary key auto_increment,
    survey_id int not null,
    surveycategory_id int not null,
    foreign key (survey_id) references survey(id),
    foreign key (surveycategory_id) references surveycategory(id)
);

