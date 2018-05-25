CREATE TABLE IF NOT EXISTS `devllop`.`convenio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(45) NOT NULL,
  `tx_juros` DECIMAL(10,2) NULL,
  `tx_multa` DECIMAL(10,2) NULL,
  `conta_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_CONVENIO_CONTA1_idx` (`conta_id` ASC),
  CONSTRAINT `fk_CONVENIO_CONTA1`
    FOREIGN KEY (`conta_id`)
    REFERENCES `devllop`.`conta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB default charset=utf8;