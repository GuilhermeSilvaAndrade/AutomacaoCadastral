package br.mg.gsandrade.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.mg.gsandrade.core.BaseTest;
import br.mg.gsandrade.core.Propriedades;
import br.mg.gsandrade.pages.ContaPage;
import br.mg.gsandrade.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private ContaPage contaPage = new ContaPage();
	
	@Test
	public void test1_InserirConta() {
		menuPage.acessarTelaInserirConta();
		contaPage.setNome("Conta do teste");
		contaPage.salvarNome();
		Assert.assertEquals("Conta adicionada com sucesso!", contaPage.obtemMensagemSucesso());
	}
	
	@Test
	public void test2_AlterarConta() {
		menuPage.acessarTelaListarConta();
		contaPage.clicarALterarConta("Conta do teste");
		contaPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contaPage.salvarNome();
		Assert.assertEquals("Conta alterada com sucesso!", contaPage.obtemMensagemSucesso());
	}
	
	@Test
	public void test3_InserirContaExistente() {
		menuPage.acessarTelaInserirConta();
		contaPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contaPage.salvarNome();
		Assert.assertEquals("Já existe uma conta com esse nome!", contaPage.obtemMensagemErro());
	}
	
//Classe criada para esse metodo	
//	@Test
//	public void testRemoverContaComMovimentacao() {
//		menuPage.acessarTelaListarConta();
//		contaPage.clicarRemoverConta("Conta existente");
//		Assert.assertEquals("Conta em uso na movimentações", contaPage.obtemMensagemErro());
//	}
		
}
