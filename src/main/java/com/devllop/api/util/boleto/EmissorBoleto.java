package com.devllop.api.util.boleto;

import java.io.File;
import java.io.Serializable;

import com.devllop.api.model.Empresa;
import com.devllop.api.model.ParcelaReceber;

public interface EmissorBoleto extends Serializable {
	public byte [] gerarBoleto(Empresa empresa, ParcelaReceber lancamento);
	public File gerarBoletoEmArquivo(String arquivo, Empresa empresa, ParcelaReceber lancamento);
}
