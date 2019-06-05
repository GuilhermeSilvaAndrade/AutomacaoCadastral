package br.mg.gsandrade.tests;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.mg.gsandrade.core.BaseTest;
import br.mg.gsandrade.core.DriverFactory;
import br.mg.gsandrade.pages.MenuPage;
import br.mg.gsandrade.pages.ResumoMensalPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoMensalTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ResumoMensalPage resumoMensalPage = new ResumoMensalPage();
	
//Remoção de conta especifica	
//	@Test
//	public void testValidarRemocaoMovimentacaoEspecifica() {
//		menuPage.acessarTelaResumoMensal();
//		resumoMensalPage.removerMovimentacaoEspecifica("asdf");
//		Assert.assertEquals("Movimentação removida com sucesso!", resumoMensalPage.obtemMensagemSucessoDeRemocao());
//	}
	
	@Test
	public void test1_ValidarRemocaoPrimeiraMovimentacao() {
		menuPage.acessarTelaResumoMensal();
		resumoMensalPage.removerPrimeiraMovimentacao();
		Assert.assertEquals("Movimentação removida com sucesso!", resumoMensalPage.obtemMensagemSucessoDeRemocao());
	}
	
	@Test
	public void test2_ResumoMensal() {
		menuPage.acessarTelaResumoMensal();
		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
	}
	
	@Test
	public void test3_ValidaTabelaVazia() {
		menuPage.acessarTelaResumoMensal();
		if(resumoMensalPage.validaTabelaVazia()) {
			Assert.assertTrue(resumoMensalPage.validaTabelaVazia());
			System.out.println("A tabela possui registros");
		}
		else {
			Assert.assertFalse(resumoMensalPage.validaTabelaVazia());
			System.out.println("A tabela nao possui registros");
		}
	}
	
}
