package br.mg.gsandrade.tests;

import org.junit.Assert;
import org.junit.Test;
import br.mg.gsandrade.core.BaseTest;
import br.mg.gsandrade.pages.ContasPage;
import br.mg.gsandrade.pages.MenuPage;


public class ContaTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ContasPage contasPage = new ContasPage();
	
	@Test
	public void testInserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta do teste");
		contasPage.salvarNome();
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obtemMensagemSucesso());
	}
	
	@Test
	public void testAlterarConta() {
		menuPage.acessarTelaListarConta();
		contasPage.clicarALterarConta("Conta do teste");
		contasPage.setNome("Conta alterada");
		contasPage.salvarNome();
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obtemMensagemSucesso());
	}
	
	@Test
	public void testInserirContaExistente() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta alterada");
		contasPage.salvarNome();
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obtemMensagemErro());
	}
}
