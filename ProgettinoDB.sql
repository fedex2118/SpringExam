DROP DATABASE progettinodb;

CREATE DATABASE IF NOT EXISTS progettinodb;

USE progettinodb;

CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cognome VARCHAR(255),
    numero_telefono VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE ordine (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_consegna DATETIME NOT NULL,
    data_ritiro DATETIME NOT NULL,
    cliente_id BIGINT NOT NULL,
    costo_totale DOUBLE,
	FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

CREATE TABLE prodotto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(255),
    prezzo FLOAT,
    quantita INT NOT NULL
);

CREATE TABLE ordine_prodotto (
    ordine_id BIGINT NOT NULL,
    prodotto_id BIGINT NOT NULL,
    FOREIGN KEY (ordine_id) REFERENCES ordine(id)
		ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (prodotto_id) REFERENCES prodotto(id)
		ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY (ordine_id, prodotto_id)
);