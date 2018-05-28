CREATE TABLE IF NOT EXISTS  `categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB default charset=utf8;


-- -----------------------------------------------------
-- Table  `tipo_lancamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `tipo_lancamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB default charset=utf8;


-- -----------------------------------------------------
-- Table  `endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS  `endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(70) NULL,
  `numero` INT  NULL,
  `complemento` VARCHAR(45) NULL,
  `bairro` VARCHAR(70)  NULL,
  `cidade` VARCHAR(70) NULL,
  `uf` CHAR(2)  NULL,
  `cep` VARCHAR(20)  NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB default charset=utf8;