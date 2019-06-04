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
		movimentacaoPage.setDescricao("teste descri��o");
		movimentacaoPage.setInteressado("interessado teste");
		movimentacaoPage.setValor("1000");
		movimentacaoPage.setConta("Conta alterada");
		movimentacaoPage.setSituacaoPago();
		movimentacaoPage.salvarMovimentacao();
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movimentacaoPage.obtemMensagemSucesso());
	}
	
	@Test
	public void test2_ValidarRegrasCampos() {
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
	public void test3_ValidarMovimentacaoFutura() {
		menuPage.acessarTelaMovimentacao();
		movimentacaoPage.setTipoMovimentacaoReceita();
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		movimentacaoPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movimentacaoPage.setDataPagamento(obterDataFormatada(dataFutura));
		movimentacaoPage.setDescricao("teste descri��o");
		movimentacaoPage.setInteressado("interessado teste");
		movimentacaoPage.setValor("1000");
		movimentacaoPage.setConta("Conta alterada");
		movimentacaoPage.setSituacaoPago();
		movimentacaoPage.salvarMovimentacao();
		Assert.assertEquals("Data da Movimenta��o deve ser menor ou igual � data atual", 
				movimentacaoPage.obtemMensagemErroDataFutura());
//		List<String> erros = movimentacaoPage.obtemErros();
//		Assert.assertTrue(erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));
//		Assert.assertEquals(1, erros.size());
	}
		
}
