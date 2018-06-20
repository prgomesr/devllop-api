CREATE TABLE IF NOT EXISTS `cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(20) NOT NULL,
  `rg` VARCHAR(20) NULL,
  `nascimento` DATETIME NULL,
  `nome` VARCHAR(70) NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `telefone_principal` VARCHAR(20) NOT NULL,
  `ativo` TINYINT NOT NULL,
  `situacao` VARCHAR(20) NOT NULL,
  `telefone_secundario` VARCHAR(20) NULL,
  `email` VARCHAR(70) NULL,
  `observacao` VARCHAR(255) NULL,
  `end_logradouro` VARCHAR(70) NULL,
  `end_numero` VARCHAR(10) NULL,
  `end_complemento` VARCHAR(45) NULL,
  `end_bairro` VARCHAR(70) NULL,
  `end_cidade` VARCHAR(70) NULL,
  `end_uf` CHAR(2) NULL,
  `end_cep` VARCHAR(20) NULL,
  `estado_civil_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_CLIENTE_ESTADO_CIVIL1_idx` (`estado_civil_id` ASC),
  CONSTRAINT `fk_CLIENTE_ESTADO_CIVIL1`
    FOREIGN KEY (`estado_civil_id`)
    REFERENCES `estado_civil` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB default charset=utf8;