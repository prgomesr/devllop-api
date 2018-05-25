CREATE TABLE IF NOT EXISTS `devllop`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB default charset=utf8;


-- -----------------------------------------------------
-- Table `devllop`.`tipo_lancamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devllop`.`tipo_lancamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB default charset=utf8;


-- -----------------------------------------------------
-- Table `devllop`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devllop`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(70) NOT NULL,
  `numero` INT NOT NULL,
  `complemento` VARCHAR(45) NULL,
  `bairro` VARCHAR(70) NOT NULL,
  `cidade` VARCHAR(70) NOT NULL,
  `uf` CHAR(2) NOT NULL,
  `cep` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB default charset=utf8;