CREATE TABLE Personne_p (
  p_nom VARCHAR2(30),
  p_prenom VARCHAR(30),
  p_dateDeNaissance DATE,
  p_id INTEGER,
  p_fonction VARCHAR (30),
  p_b_numero NUMBER(30),
  CONSTRAINT p_pk PRIMARY KEY(p_id),
  CONSTRAINT p_b_numero_fk FOREIGN KEY(p_b_numero) REFERENCES Badge_b(b_numero)
);

CREATE TABLE Badge_b (
  b_numero NUMBER(30),
  CONSTRAINT b_pk PRIMARY KEY(b_numero)
);