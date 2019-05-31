package br.mg.gsandrade.pages;

import static br.mg.gsandrade.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.mg.gsandrade.core.BasePage;


public class MovimentacaoPage extends BasePage {

	public void setTipoMovimentacaoReceita() {
		selecionaComboPorTexto("tipo", "Receita");
	}
	
	public void setTipoMovimentacaoDespesa() {
		selecionaComboPorTexto("tipo", "Despesa");
	}
	
	public void setDataMovimentacao(String data) {
		escreve("data_transacao", data);
	}
	
	public void setDataPagamento(String data) {
		escreve("data_pagamento", data);
	}
	
	public void setDescricao(String descricao) {
		escreve("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escreve("interessado", interessado);
	}
	
	public void setValor(String valorInteiro) {
		escreve("valor", valorInteiro);
	}
	
	public void setConta(String conta) {
		selecionaComboPorTexto("conta", conta);
	}
	
	public void setSituacaoPago() {
		clica("status_pago");
	}
	
	public void setSituacaoPendente() {
		clica("status_pendente");
	}
	
	public void salvarMovimentacao() {
		clicaBy(By.xpath("//*[.='Salvar']"));
		//*[.='Salvar']//div[@class='btn-group']
	}
	
	public String obtemMensagemSucesso() {
		return obtemTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String obtemMensagemErroDataFutura() {
		return obtemTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	public List<String> obtemErros() {
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro: erros) {
			retorno.add(erro.getText());
		}
		return retorno;
	}
	
}
