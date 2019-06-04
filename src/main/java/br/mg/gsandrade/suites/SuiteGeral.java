package br.mg.gsandrade.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.mg.gsandrade.tests.ContaTest;
import br.mg.gsandrade.tests.HomeTest;
import br.mg.gsandrade.tests.MovimentacaoTest;
import br.mg.gsandrade.tests.RemoverContaComMovimentacaoTest;
import br.mg.gsandrade.tests.ResumoMensalTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverContaComMovimentacaoTest.class,
	HomeTest.class,
	ResumoMensalTest.class
})
public class SuiteGeral {

}
