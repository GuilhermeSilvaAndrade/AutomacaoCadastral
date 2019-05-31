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
		movimentacaoPage.setDescricao("teste descrição");
		movimentacaoPage.setInteressado("interessado teste");
		movimentacaoPage.setValor("200");
		movimentacaoPage.setConta("Conta alterada");
		movimentacaoPage.setSituacaoPendente();
		movimentacaoPage.salvarMovimentacao();
		Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obtemMensagemSucesso());
	}
	
	@Test
	public void validaRegrasCampos() {
		menuPage.acessarTelaMovimentacao();
		movimentacaoPage.salvarMovimentacao();
		List<String> erros = movimentacaoPage.obtemErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
				"Descrição é obrigatório", "Interessado é obrigatório", 
				"Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void validaMovimentacaoFutura() {
		menuPage.acessarTelaMovimentacao();
		movimentacaoPage.setTipoMovimentacaoReceita();
		movimentacaoPage.setDataMovimentacao("31/05/2019");
		movimentacaoPage.setDataPagamento("30/05/2019");
		movimentacaoPage.setDescricao("teste descrição");
		movimentacaoPage.setInteressado("interessado teste");
		movimentacaoPage.setValor("200");
		movimentacaoPage.setConta("Conta alterada");
		movimentacaoPage.setSituacaoPendente();
		movimentacaoPage.salvarMovimentacao();
		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", 
				movimentacaoPage.obtemMensagemErroDataFutura());
//		List<String> erros = movimentacaoPage.obtemErros();
//		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
//		Assert.assertEquals(1, erros.size());
	}
	
}
