set search_path to dat108_oblig3;

DROP TABLE IF EXISTS deltager;

CREATE TABLE deltager 
(
   fornavn		varchar,
   etternavn	varchar,
   mobil		varchar,
   kjonn		varchar,
   passordHash	varchar,
   passordSalt	varchar,
   CONSTRAINT deltager_pk PRIMARY KEY (mobil)
);