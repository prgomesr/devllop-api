-- -----------------------------------------------------
-- Table `devllop`.`parcela_pagar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devllop`.`parcela_pagar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_emissao` DATETIME NOT NULL,
  `data_vencimento` DATETIME NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `situacao` VARCHAR(45) NOT NULL,
  `num_documento` VARCHAR(45) NULL,
  `num_nf` VARCHAR(45) NULL,
  `conta_id` INT NOT NULL,
  `fornecedor_id` INT NOT NULL,
  `categoria_pagamento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_parcela_pagar_conta1_idx` (`conta_id` ASC),
  INDEX `fk_parcela_pagar_fornecedor1_idx` (`fornecedor_id` ASC),
  INDEX `fk_parcela_pagar_categoria_pagamento1_idx` (`categoria_pagamento_id` ASC),
  CONSTRAINT `fk_parcela_pagar_conta1`
    FOREIGN KEY (`conta_id`)
    REFERENCES `devllop`.`conta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parcela_pagar_fornecedor1`
    FOREIGN KEY (`fornecedor_id`)
    REFERENCES `devllop`.`fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parcela_pagar_categoria_pagamento1`
    FOREIGN KEY (`categoria_pagamento_id`)
    REFERENCES `devllop`.`categoria_pagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB default charset=utf8;

-- -----------------------------------------------------
-- Table `devllop`.`parcela_receber`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devllop`.`parcela_receber` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_emissao` DATETIME NOT NULL,
  `data_vencimento` DATETIME NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `situacao` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  `num_documento` VARCHAR(45) NULL,
  `nosso_numero` VARCHAR(45) NULL,
  `conta_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  `categoria_recebimento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_parcela_receber_conta1_idx` (`conta_id` ASC),
  INDEX `fk_parcela_receber_cliente1_idx` (`cliente_id` ASC),
  INDEX `fk_parcela_receber_categoria_recebimento1_idx` (`categoria_recebimento_id` ASC),
  CONSTRAINT `fk_parcela_receber_conta1`
    FOREIGN KEY (`conta_id`)
    REFERENCES `devllop`.`conta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parcela_receber_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `devllop`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parcela_receber_categoria_recebimento1`
    FOREIGN KEY (`categoria_recebimento_id`)
    REFERENCES `devllop`.`categoria_recebimento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB default charset=utf8;


-- -----------------------------------------------------
-- Table `devllop`.`parcela_recebimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devllop`.`parcela_recebimento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_recebimento` DATETIME NOT NULL,
  `valor_recebido` DECIMAL(10,2) NOT NULL,
  `parcela_receber_id` INT NOT NULL,
  `conta_id` INT NOT NULL,
  `tipo_lancamento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_parcela_recebimento_parcela_receber1_idx` (`parcela_receber_id` ASC),
  INDEX `fk_parcela_recebimento_conta1_idx` (`conta_id` ASC),
  INDEX `fk_parcela_recebimento_tipo_lancamento1_idx` (`tipo_lancamento_id` ASC),
  CONSTRAINT `fk_parcela_recebimento_parcela_receber1`
    FOREIGN KEY (`parcela_receber_id`)
    REFERENCES `devllop`.`parcela_receber` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parcela_recebimento_conta1`
    FOREIGN KEY (`conta_id`)
    REFERENCES `devllop`.`conta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parcela_recebimento_tipo_lancamento1`
    FOREIGN KEY (`tipo_lancamento_id`)
    REFERENCES `devllop`.`tipo_lancamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB default charset=utf8;


-- -----------------------------------------------------
-- Table `devllop`.`parcela_pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devllop`.`parcela_pagamento` (
  `id` INT NOT NULL,
  `data_pagamento` DATETIME NOT NULL,
  `valor_pago` DECIMAL(10,2) NOT NULL,
  `parcela_pagar_id` INT NOT NULL,
  `conta_id` INT NOT NULL,
  `tipo_lancamento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_parcela_pagamento_parcela_pagar1_idx` (`parcela_pagar_id` ASC),
  INDEX `fk_parcela_pagamento_conta1_idx` (`conta_id` ASC),
  INDEX `fk_parcela_pagamento_tipo_lancamento1_idx` (`tipo_lancamento_id` ASC),
  CONSTRAINT `fk_parcela_pagamento_parcela_pagar1`
    FOREIGN KEY (`parcela_pagar_id`)
    REFERENCES `devllop`.`parcela_pagar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parcela_pagamento_conta1`
    FOREIGN KEY (`conta_id`)
    REFERENCES `devllop`.`conta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parcela_pagamento_tipo_lancamento1`
    FOREIGN KEY (`tipo_lancamento_id`)
    REFERENCES `devllop`.`tipo_lancamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB default charset=utf8;