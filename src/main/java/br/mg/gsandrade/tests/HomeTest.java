package br.mg.gsandrade.tests;

import org.junit.Assert;
import org.junit.Test;

import br.mg.gsandrade.core.BaseTest;
import br.mg.gsandrade.pages.HomePage;

public class HomeTest extends BaseTest {

	private HomePage homePage = new HomePage();
	
	@Test
	public void testValidaSaldoConta() {
		Assert.assertEquals("1000.00", homePage.obterSaldoConta("Conta alterada"));
	}
}
