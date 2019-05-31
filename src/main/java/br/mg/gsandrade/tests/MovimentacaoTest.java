package br.mg.gsandrade.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.mg.gsandrade.core.BaseTest;
import br.mg.gsandrade.pages.MenuPage;
import br.mg.gsandrade.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	
	@Test
	public void criarMovimentacao() {
		menuPage.acessarTelaMovimentacao();
		movimentacaoPage.setTipoMovimentacaoReceita();
		movimentacaoPage.setDataMovimentacao("30/05/2019");
		movimentacaoPage.setDataPagamento("30/05/2019");
		movimentacaoPage.setDescricao("teste descri��o");
		movimentacaoPage.setInteressado("interessado teste");
		movimentacaoPage.setValor("200");
		movimentacaoPage.setConta("Conta alterada");
		movimentacaoPage.setSituacaoPendente();
		movimentacaoPage.salvarMovimentacao();
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movimentacaoPage.obtemMensagemSucesso());
	}
	
	@Test
	public void validaRegrasCampos() {
		menuPage.acessarTelaMovimentacao();
		movimentacaoPage.salvarMovimentacao();
		List<String> erros = movimentacaoPage.obtemErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio", "Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio", "Interessado � obrigat�rio", 
				"Valor � obrigat�rio", "Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void validaMovimentacaoFutura() {
		menuPage.acessarTelaMovimentacao();
		movimentacaoPage.setTipoMovimentacaoReceita();
		movimentacaoPage.setDataMovimentacao("31/05/2019");
		movimentacaoPage.setDataPagamento("30/05/2019");
		movimentacaoPage.setDescricao("teste descri��o");
		movimentacaoPage.setInteressado("interessado teste");
		movimentacaoPage.setValor("200");
		movimentacaoPage.setConta("Conta alterada");
		movimentacaoPage.setSituacaoPendente();
		movimentacaoPage.salvarMovimentacao();
		Assert.assertEquals("Data da Movimenta��o deve ser menor ou igual � data atual", 
				movimentacaoPage.obtemMensagemErroDataFutura());
//		List<String> erros = movimentacaoPage.obtemErros();
//		Assert.assertTrue(erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
//		Assert.assertEquals(1, erros.size());
	}
	
}
