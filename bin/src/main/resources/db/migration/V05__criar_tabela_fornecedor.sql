CREATE TABLE IF NOT EXISTS `devllop`.`fornecedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `razao_social` VARCHAR(70) NOT NULL,
  `fantasia` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(45) NULL,
  `insc_estadual` VARCHAR(45) NULL,
  `insc_municipal` VARCHAR(45) NULL,
  `isento` TINYINT NULL,
  `telefone_principal` VARCHAR(20) NULL,
  `telefone_secundario` VARCHAR(20) NULL,
  `contato` VARCHAR(45) NULL,
  `email` VARCHAR(70) NULL,
  `observacao` VARCHAR(255) NULL,
  `endereco_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_FORNECEDOR_ENDERECO1_idx` (`endereco_id` ASC),
  CONSTRAINT `fk_FORNECEDOR_ENDERECO1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `devllop`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB default charset=utf8;