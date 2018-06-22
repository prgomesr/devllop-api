package com.devllop.api.util.boleto;

import java.io.File;
import java.sql.Date;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo.Aceite;
import org.springframework.beans.factory.annotation.Autowired;

import com.devllop.api.model.Empresa;
import com.devllop.api.model.ParcelaReceber;
import com.devllop.api.util.modulo11.GeradorDigitoVerificador;


public class BopepoEmissorBoleto implements EmissorBoleto {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private GeradorDigitoVerificador geradorDigitoVerificador;

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
		Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
		
		String codigo = this.geradorDigitoVerificador.completarComZeros(String.valueOf(lancamento.getId()));
		titulo.setNumeroDoDocumento(codigo);
		titulo.setNossoNumero(codigo);
		titulo.setDigitoDoNossoNumero(this.geradorDigitoVerificador.gerarDigito(19, codigo));
		
		titulo.setValor(lancamento.getValor());
		Date dataEmissao = Date.valueOf(lancamento.getDataEmissao());
		Date dataVencimento = Date.valueOf(lancamento.getDataVencimento());
		titulo.setDataDoDocumento(dataEmissao);
		titulo.setDataDoVencimento(dataVencimento);
		titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
		titulo.setAceite(Aceite.N);
		
		return titulo;
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
