CREATE TABLE IF NOT EXISTS `devllop`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(20) NOT NULL,
  `rg` VARCHAR(20) NULL,
  `nascimento` DATETIME NULL,
  `nome` VARCHAR(70) NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `telefone_principal` VARCHAR(20) NOT NULL,
  `telefone_secundario` VARCHAR(20) NULL,
  `email` VARCHAR(70) NULL,
  `observacao` VARCHAR(255) NULL,
  `endereco_id` INT NULL,
  `estado_civil_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_CLIENTE_ENDERECO1_idx` (`endereco_id` ASC),
  INDEX `fk_CLIENTE_ESTADO_CIVIL1_idx` (`estado_civil_id` ASC),
  CONSTRAINT `fk_CLIENTE_ENDERECO1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `devllop`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CLIENTE_ESTADO_CIVIL1`
    FOREIGN KEY (`estado_civil_id`)
    REFERENCES `devllop`.`estado_civil` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB default charset=utf8;