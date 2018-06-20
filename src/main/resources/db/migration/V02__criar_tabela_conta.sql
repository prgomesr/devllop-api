CREATE TABLE IF NOT EXISTS `conta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `carteira` TINYINT NOT NULL,
  `numero` VARCHAR(20) NULL,
  `digito` CHAR(1) NULL,
  `saldo_inicial` DECIMAL(10,2) NULL,
  `saldo_atual` DECIMAL(10,2) NULL,
  `agencia_id` INT NULL,
  `empresa_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_CONTA_AGENCIA_idx` (`agencia_id` ASC),
  INDEX `fk_CONTA_EMPRESA1_idx` (`empresa_id` ASC),
  CONSTRAINT `fk_CONTA_AGENCIA`
    FOREIGN KEY (`agencia_id`)
    REFERENCES `agencia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CONTA_EMPRESA1`
    FOREIGN KEY (`empresa_id`)
    REFERENCES `empresa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB default charset=utf8;