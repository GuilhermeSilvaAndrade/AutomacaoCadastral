package br.mg.gsandrade.pages;

import static br.mg.gsandrade.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.mg.gsandrade.core.BasePage;

public class ResumoMensalPage extends BasePage {

	public void removerMovimentacaoEspecifica(String string) {
		obterCelula("Descrição", string, "Ações", "tabelaExtrato")
		.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
	
	public void removerPrimeiraMovimentacao() {
		clicaBy(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String obtemMensagemSucessoDeRemocao() {
		return obtemTexto(By.xpath("//div[@class='alert alert-success']"));
	}

	public boolean validaTabelaVazia() {
		try {
			getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
