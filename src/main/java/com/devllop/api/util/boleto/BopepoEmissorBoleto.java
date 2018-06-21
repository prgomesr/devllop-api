package com.devllop.api.util.boleto;

import java.io.File;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;

import com.devllop.api.model.Conta;
import com.devllop.api.model.Empresa;
import com.devllop.api.model.ParcelaReceber;


public class BopepoEmissorBoleto implements EmissorBoleto {

	private static final long serialVersionUID = 1L;

	@Override
	public byte[] gerarBoleto(Empresa empresa, ParcelaReceber lancamento) {
		Boleto boleto = criarBoleto(empresa, lancamento);
		BoletoViewer boletoViewer = new BoletoViewer(boleto);
		return boletoViewer.getPdfAsByteArray();
	}

	@Override
	public File gerarBoletoEmArquivo(String arquivo, Empresa empresa, ParcelaReceber lancamento) {
		Boleto boleto = criarBoleto(empresa, lancamento);
		BoletoViewer boletoViewer = new BoletoViewer(boleto);
		return boletoViewer.getPdfAsFile(arquivo);
	}

	private Boleto criarBoleto(Empresa empresa, ParcelaReceber lancamento) {
		ContaBancaria contaBancaria = criarContaBancaria(lancamento);
		Sacado sacado = new Sacado(lancamento.getCliente().getNome());
		Cedente cedente = new Cedente(empresa.getRazaoSocial(), empresa.getCnpj());
		
		Titulo titulo = criarTitulo(contaBancaria, sacado, cedente, lancamento);
		
		Boleto boleto = new Boleto(titulo);
		return boleto;
	}

	private Titulo criarTitulo(ContaBancaria contaBancaria, Sacado sacado, Cedente cedente, ParcelaReceber lancamento) {
		// TODO Auto-generated method stub
		return null;
	}

	private ContaBancaria criarContaBancaria(ParcelaReceber lancamento) {
		ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_BRADESCO.create());
		Integer agencia = Integer.parseInt(lancamento.getConta().getAgencia().getNumero());
		String digitoAgencia = lancamento.getConta().getAgencia().getDigito();
		Integer numeroConta = Integer.parseInt(lancamento.getConta().getNumero());
		String digitoConta = lancamento.getConta().getDigito();
		contaBancaria.setAgencia(new Agencia(agencia, digitoAgencia));
		contaBancaria.setNumeroDaConta(new NumeroDaConta(numeroConta, digitoConta));
		contaBancaria.setCarteira(new Carteira(19));
		
		return contaBancaria;
	}

}
