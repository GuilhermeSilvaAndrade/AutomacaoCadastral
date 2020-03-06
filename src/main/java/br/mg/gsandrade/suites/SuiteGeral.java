package br.mg.gsandrade.suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.mg.gsandrade.core.DriverFactory;
import br.mg.gsandrade.pages.LoginPage;
import br.mg.gsandrade.tests.ContaTest;
import br.mg.gsandrade.tests.HomeTest;
import br.mg.gsandrade.tests.MovimentacaoTest;
import br.mg.gsandrade.tests.RemoverContaComMovimentacaoTest;
import br.mg.gsandrade.tests.RemoverContaSemMovimentacaoTest;
import br.mg.gsandrade.tests.ResumoMensalTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverContaComMovimentacaoTest.class,
	HomeTest.class,
	ResumoMensalTest.class,
	RemoverContaSemMovimentacaoTest.class
})
public class SuiteGeral {

	private static LoginPage loginPage = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		loginPage.acessarTelaInicial();
		loginPage.setEmail("conta10@conta10");
		loginPage.setSenha("123456");
		loginPage.entrar();
		loginPage.resetar();
		DriverFactory.killDriver();
	}
}
