CREATE TABLE IF NOT EXISTS `devllop`.`lancamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(25) NOT NULL COMMENT 'RECEITA, DESPESA',
  `descricao` VARCHAR(100) NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `valor_recebido` DECIMAL(10,2) NULL,
  `data_vencimento` DATETIME NOT NULL,
  `data_pagamento` DATETIME NULL,
  `data_balanco` DATETIME NULL,
  `observacao` VARCHAR(255) NULL,
  `conta_fixa` TINYINT NOT NULL COMMENT 'TRUE, FALSE',
  `num_documento` VARCHAR(45) NULL,
  `num_nf` VARCHAR(45) NULL,
  `nosso_numero` VARCHAR(45) NULL,
  `valor_juros` DECIMAL(10,2) NULL,
  `valor_multa` DECIMAL(10,2) NULL,
  `situacao` VARCHAR(25) NOT NULL,
  `conta_id` INT NOT NULL,
  `categoria_id` INT NOT NULL,
  `tipo_lancamento_id` INT NULL COMMENT 'DINHEIRO, CARTAO',
  `fornecedor_id` INT NULL,
  `cliente_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_LACAMENTOS_CONTA1_idx` (`conta_id` ASC),
  INDEX `fk_LACAMENTOS_CATEGORIA1_idx` (`categoria_id` ASC),
  INDEX `fk_LACAMENTOS_TIPO_LANCAMENTO1_idx` (`tipo_lancamento_id` ASC),
  INDEX `fk_LACAMENTOS_FORNECEDOR1_idx` (`fornecedor_id` ASC),
  INDEX `fk_LACAMENTOS_CLIENTE1_idx` (`cliente_id` ASC),
  CONSTRAINT `fk_LACAMENTOS_CONTA1`
    FOREIGN KEY (`conta_id`)
    REFERENCES `devllop`.`conta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LACAMENTOS_CATEGORIA1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `devllop`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LACAMENTOS_TIPO_LANCAMENTO1`
    FOREIGN KEY (`tipo_lancamento_id`)
    REFERENCES `devllop`.`tipo_lancamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LACAMENTOS_FORNECEDOR1`
    FOREIGN KEY (`fornecedor_id`)
    REFERENCES `devllop`.`fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LACAMENTOS_CLIENTE1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `devllop`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB default charset=utf8;