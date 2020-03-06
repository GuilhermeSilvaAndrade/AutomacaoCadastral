package br.mg.gsandrade.tests;

import org.junit.Assert;
import org.junit.Test;

import br.mg.gsandrade.core.BaseTest;
import br.mg.gsandrade.pages.HomePage;
import br.mg.gsandrade.pages.MenuPage;

public class HomeTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private HomePage homePage = new HomePage();
	
	@Test
	public void testValidaSaldoConta() {
		menuPage.acessarTelaHome();
//		Assert.assertEquals("500.00", homePage.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
		Assert.assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));
	}
}
