package br.mg.gsandrade.pages;


import br.mg.gsandrade.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarTelaInserirConta() {
		clicaLink("Contas");
		clicaLink("Adicionar");
	}
	
	public void acessarTelaListarConta() {
		clicaLink("Contas");
		clicaLink("Listar");
	}
	
	public void acessarTelaMovimentacao() {
		clicaLink("Criar Movimentação");
	}
}
