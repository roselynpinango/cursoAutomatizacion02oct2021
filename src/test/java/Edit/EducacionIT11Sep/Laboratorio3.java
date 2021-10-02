package Edit.EducacionIT11Sep;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio3 {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionIT11Sep\\Drivers\\chromedriver.exe";
	String urlEsperada = "http://automationpractice.com/index.php?controller=my-account";
	File screen;
	
	@BeforeSuite
	public void setUp() {
		// Acciones que se ejecutan antes de la prueba
		// Inicialización del Driver y abrir el navegador en la página
		System.setProperty("webdriver.chrome.driver", driverPath);
						
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		System.out.println("Inicio de la Suite de Pruebas");
	}
	
	@Test(priority=0,description="Registrar Usuario - AutomationPractice")
	public void registrarUsuario() {
		// Caso de prueba registrar usuario
		// Escribir el correo y hacer clic en el botón Create An Account
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("micorreo" + Math.random() + "@correo.com");
				
		WebElement btnCreate = driver.findElement(By.name("SubmitCreate"));
		btnCreate.click();
				
		// Completar el formulario
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
				
		driver.findElement(By.id("id_gender1")).click();
			
		driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Rodrigo");
			
		driver.findElement(By.id("customer_lastname")).sendKeys("Jimenez");
				
		driver.findElement(By.name("passwd")).sendKeys("1q2w3e4r5t");
				
		Select days = new Select(driver.findElement(By.id("days")));
		days.selectByValue("18");
				
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByIndex(5);
				
		Select years = new Select(driver.findElement(By.xpath("//*[@id='years']")));
		years.selectByValue("1985");
				
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
				
		driver.findElement(By.cssSelector("#address1")).sendKeys("Micalle 2345 6B");
				
		driver.findElement(By.id("city")).sendKeys("Cordoba");
				
		Select state = new Select(driver.findElement(By.name("id_state")));
		state.selectByVisibleText("Arizona");
				
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("54345");
				
		Select country = new Select(driver.findElement(By.id("id_country")));
		country.selectByValue("21");
				
		driver.findElement(By.name("phone_mobile")).sendKeys("4657463736");
				
		WebElement txtAlias = driver.findElement(By.id("alias"));
		txtAlias.clear();
		txtAlias.sendKeys("Dirección de Trabajo");
				
		driver.findElement(By.cssSelector("#submitAccount")).click();
		
		Assert.assertEquals(urlEsperada, driver.getCurrentUrl());
	}
	
	@Test(priority=2,description="Buscar Palabra - AutomationPractice")
	public void buscarPalabra() throws IOException {
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionIT11Sep\\Evidencias\\01_pagina_inicial.png"));
		
		// Acciones del caso de prueba Buscar Palabra
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionIT11Sep\\Evidencias\\02_palabra_a_buscar.png"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionIT11Sep\\Evidencias\\03_resultado_obtenido.png"));
	}
	
	@Test(priority=1,description="Contact Us - AutomationPractice")
	public void irAContactUs() {
		// Acciones del caso de prueba Ir a Contact Us
		WebElement lnkContactUs = driver.findElement(By.linkText("Contact us"));
		lnkContactUs.click();
	}
	
	@AfterSuite
	public void tearDown() {
		// Acciones que se ejecutan después de la prueba
		System.out.println("Fin de la Suite de Pruebas");
		//driver.close();
	}
}
