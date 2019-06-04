package br.mg.gsandrade.tests;

import static br.mg.gsandrade.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.mg.gsandrade.core.BaseTest;
import br.mg.gsandrade.pages.MenuPage;
import br.mg.gsandrade.pages.MovimentacaoPage;
import br.mg.gsandrade.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {

	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	
	@Test
	public void test1_CriarMovimentacao() {
		menuPage.acessarTelaMovimentacao();
		movimentacaoPage.setTipoMovimentacaoReceita();
		movimentacaoPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movimentacaoPage.setDataPagamento(obterDataFormatada(new Date()));
		movimentacaoPage.setDescricao("teste descrição");
		movimentacaoPage.setInteressado("interessado teste");
		movimentacaoPage.setValor("1000");
		movimentacaoPage.setConta("Conta alterada");
		movimentacaoPage.setSituacaoPago();
		movimentacaoPage.salvarMovimentacao();
		Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obtemMensagemSucesso());
	}
	
	@Test
	public void test2_ValidarRegrasCampos() {
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
	public void test3_ValidarMovimentacaoFutura() {
		menuPage.acessarTelaMovimentacao();
		movimentacaoPage.setTipoMovimentacaoReceita();
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		movimentacaoPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movimentacaoPage.setDataPagamento(obterDataFormatada(dataFutura));
		movimentacaoPage.setDescricao("teste descrição");
		movimentacaoPage.setInteressado("interessado teste");
		movimentacaoPage.setValor("1000");
		movimentacaoPage.setConta("Conta alterada");
		movimentacaoPage.setSituacaoPago();
		movimentacaoPage.salvarMovimentacao();
		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", 
				movimentacaoPage.obtemMensagemErroDataFutura());
//		List<String> erros = movimentacaoPage.obtemErros();
//		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
//		Assert.assertEquals(1, erros.size());
	}
		
}
