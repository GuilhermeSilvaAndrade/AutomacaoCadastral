package br.mg.gsandrade.core;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.mg.gsandrade.core.Propriedades.TipoExecucao;

public class DriverFactory {


	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
		@Override
		protected  synchronized WebDriver initialValue(){
			return initDriver();
		}
	};
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		
		WebDriver driver = null;
		
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {	
			switch (Propriedades.BROWSER) {
			
				case FIREFOX: 
					System.setProperty("webdriver.gecko.driver", "resources\\drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
					break;
				
				case CHROME: 
					System.setProperty("webdriver.chrome.driver", "resources\\drivers\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
					
				case IE:
					System.setProperty("webdriver.ie.driver", "resources\\drivers\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					break;
			}
		}
		
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			
			DesiredCapabilities cap = null;
			switch (Propriedades.BROWSER) {
				
			case FIREFOX: 
				System.setProperty("webdriver.gecko.driver", "resources\\drivers\\geckodriver.exe");
				cap = DesiredCapabilities.firefox();
				break;
			
			case CHROME: 
				System.setProperty("webdriver.chrome.driver", "resources\\drivers\\chromedriver.exe");
				cap = DesiredCapabilities.chrome();
				break;
				
			case IE:
				System.setProperty("webdriver.ie.driver", "resources\\drivers\\IEDriverServer.exe");
				cap = DesiredCapabilities.internetExplorer();
				break;
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://10.216.104.46:4444/wd/hub"), cap);
			} catch(MalformedURLException e) {
				System.err.println("Falha na conexão com GRID");
				e.printStackTrace();
			}
			
		}
		
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.NUVEM) {
			
			DesiredCapabilities cap = null;
			switch (Propriedades.BROWSER) {
				
			case FIREFOX: 
				System.setProperty("webdriver.gecko.driver", "resources\\drivers\\geckodriver.exe");
				cap = DesiredCapabilities.firefox();
				break;
			
			case CHROME: 
				System.setProperty("webdriver.chrome.driver", "resources\\drivers\\chromedriver.exe");
				cap = DesiredCapabilities.chrome();
				break;
				
			case IE:
				System.setProperty("webdriver.ie.driver", "resources\\drivers\\IEDriverServer.exe");
				cap = DesiredCapabilities.internetExplorer();
				break;
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://"+"Login"+":"+"Chave"+"@"+"ondemand.saucelabs.com:80/wd/hub"), cap);
			} catch(MalformedURLException e) {
				System.err.println("Falha na conexão com Saucelabs");
				e.printStackTrace();
			}
			
		}
		
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		if(driver != null) {
		driver.quit();
		driver = null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}
}
