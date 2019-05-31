package br.mg.gsandrade.pages;
import org.openqa.selenium.By;
import br.mg.gsandrade.core.BasePage;

public class ContasPage extends BasePage {

	public void setNome(String nome) {
		escreve("nome", nome);
	}
	
	public void salvarNome() {
		clicaBy(By.xpath("//button[.='Salvar']"));
	}
	
	public String obtemMensagemSucesso() {
		return obtemTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String obtemMensagemErro() {
		return obtemTexto(By.xpath("//div[@class='alert alert-danger']"));
	}

	public void clicarALterarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
		.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
		
	}
	
}
