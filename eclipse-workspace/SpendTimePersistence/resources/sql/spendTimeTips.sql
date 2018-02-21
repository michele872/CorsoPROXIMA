CREATE TABLE spendTimeTips(
id int auto_increment not null,
label varchar(50),
descrizione varchar(50),
primary key(id)
);

INSERT INTO spendTimeTips (label, descrizione) VALUES ('permesso' , 'retribuito');

SELECT * FROM spendTimeTips;


DROP TABLE spendTimeTips;