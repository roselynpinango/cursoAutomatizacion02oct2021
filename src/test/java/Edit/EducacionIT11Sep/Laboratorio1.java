package Edit.EducacionIT11Sep;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio1 {
	
	/*
	 * Metodo para abrir la pagina AutomationPractice en Chrome
	 * */
	@Test
	public void abrirPaginaEnChrome() {
		// Paso 1 - Hacer referencia al driver correspondiente
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIT11Sep\\Drivers\\chromedriver.exe");
		
		// Paso 2 - Instanciar el navegador
		WebDriver driver = new ChromeDriver();
		
		// Paso 3 - Abrir la pagina en el navegador
		driver.get("http://automationpractice.com");
		
		// Paso 4 - Identificar el campo buscador, ingresar un valor y hacer la búsqueda
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Paso 5 - Cerrar el navegador
		driver.close();
	}
	
	/*
	 * Metodo para abrir la pagina AutomationPractice en Firefox
	 * */
	@Test
	public void abrirPaginaEnFirefox() {
		// Paso 1 - Hacer referencia al driver correspondiente
		System.setProperty("webdriver.gecko.driver", "..\\EducacionIT11Sep\\Drivers\\geckodriver.exe");
		
		// Paso 2 - Instanciar el navegador
		WebDriver driver = new FirefoxDriver();
		
		// Paso 3 - Abrir la pagina en el navegador
		driver.get("http://automationpractice.com");
		
		// Paso 4 - Identificar el campo buscador, ingresar un valor y hacer la búsqueda
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Paso 5 - Cerrar el navegador
		driver.close();
	}
}
