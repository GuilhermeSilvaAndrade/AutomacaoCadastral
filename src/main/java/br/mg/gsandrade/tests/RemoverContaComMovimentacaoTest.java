package br.mg.gsandrade.tests;

import org.junit.Assert;
import org.junit.Test;

import br.mg.gsandrade.core.BaseTest;
import br.mg.gsandrade.pages.ContaPage;
import br.mg.gsandrade.pages.MenuPage;

public class RemoverContaComMovimentacaoTest extends BaseTest{

	private MenuPage menuPage = new MenuPage();
	private ContaPage contaPage = new ContaPage();
	
	@Test
	public void testRemoverContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
//		contaPage.clicarRemoverConta(Propriedades.NOME_CONTA_ALTERADA);
		contaPage.clicarRemoverConta("Conta com movimentacao");
		Assert.assertEquals("Conta em uso na movimentações", contaPage.obtemMensagemErro());
	}
}
