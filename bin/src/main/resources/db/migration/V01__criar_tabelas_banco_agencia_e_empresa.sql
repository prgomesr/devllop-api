CREATE TABLE IF NOT EXISTS banco (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(10) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB default charset=utf8;


-- -----------------------------------------------------
-- Table `devllop`.`agencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS agencia (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(20) NOT NULL,
  `digito` CHAR(1) NULL,
  `telefone` VARCHAR(20) NULL,
  `gerente` VARCHAR(45) NULL,
  `banco_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_AGENCIA_BANCO1_idx` (`banco_id` ASC),
  CONSTRAINT `fk_AGENCIA_BANCO1`
    FOREIGN KEY (`banco_id`)
    REFERENCES `devllop`.`banco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB default charset=utf8;

CREATE TABLE IF NOT EXISTS empresa (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cnpj` VARCHAR(25) NOT NULL,
  `fantasia` VARCHAR(70) NULL,
  `razao_social` VARCHAR(70) NOT NULL,
  `insc_estadual` VARCHAR(45) NULL,
  `insc_municipal` VARCHAR(45) NULL,
  `isento` TINYINT NOT NULL,
  `email` VARCHAR(70) NULL,
  `data_fundacao` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB default charset=utf8;