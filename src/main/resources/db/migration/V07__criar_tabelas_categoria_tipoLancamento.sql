CREATE TABLE IF NOT EXISTS `devllop`.`categoria_pagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB default charset=utf8;


-- -----------------------------------------------------
-- Table `devllop`.`categoria_recebimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devllop`.`categoria_recebimento` (
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
