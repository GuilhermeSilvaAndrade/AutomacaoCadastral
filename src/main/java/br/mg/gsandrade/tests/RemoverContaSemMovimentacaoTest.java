package br.mg.gsandrade.tests;

import org.junit.Assert;
import org.junit.Test;

import br.mg.gsandrade.core.BaseTest;
import br.mg.gsandrade.core.Propriedades;
import br.mg.gsandrade.pages.ContaPage;
import br.mg.gsandrade.pages.MenuPage;

public class RemoverContaSemMovimentacaoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ContaPage contaPage = new ContaPage();
	
	@Test
	public void testRemoverContaSemMovimentacao() {
		menuPage.acessarTelaListarConta();
		contaPage.clicarRemoverConta(Propriedades.NOME_CONTA_ALTERADA);
		Assert.assertEquals("Conta removida com sucesso!", contaPage.obtemMensagemSucesso());
	}
}
