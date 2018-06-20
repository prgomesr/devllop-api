CREATE TABLE IF NOT EXISTS  `estado_civil` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB default charset=utf8;

INSERT INTO  `estado_civil` (`descricao`) VALUES ('Solteiro(a)');
INSERT INTO  `estado_civil` (`descricao`) VALUES ('Casado(a)');
INSERT INTO  `estado_civil` (`descricao`) VALUES ('Divorciado(a)');
INSERT INTO  `estado_civil` (`descricao`) VALUES ('Viúvo(a)');
INSERT INTO  `estado_civil` (`descricao`) VALUES ('Separado(a)');
INSERT INTO  `estado_civil` (`descricao`) VALUES ('União estável');