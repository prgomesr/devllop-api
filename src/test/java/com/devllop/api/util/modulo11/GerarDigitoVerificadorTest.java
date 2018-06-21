package com.devllop.api.util.modulo11;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.devllop.api.util.modulo11.GeradorDigitoVerificador;

public class GerarDigitoVerificadorTest {
	
	public GeradorDigitoVerificador gerador;
	
	@Before
	public void init() {
		this.gerador = new GeradorDigitoVerificador();
	}
	
	@Test
	public void deve_gerar_digito_verificador_entrada_2_saida_9() {
		Integer carteira = 6;
		String nossoNumero =  "00000000002";
		
		String digitoVerificador = gerador.gerarDigito(carteira, nossoNumero);
		assertEquals("9", digitoVerificador);
	}

}
