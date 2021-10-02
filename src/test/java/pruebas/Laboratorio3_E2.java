package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio3_E2 {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String driverPath = "..\\EducacionIT11Sep\\Drivers\\chromedriver.exe";
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		System.out.println("Inicio de la Prueba");
	}
	
	@Test
	public void login() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.completarEmail("correo01@mailinator.com");
		login.completarPassword("1q2w3e4r5t");
		login.hacerClicEnEnter();
	}
	
	@Test
	public void irAContactUs() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnContactUs();
	}
	
	@Test
	public void hacerBusqueda() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.ingresarPalabra("skirt");
		inicio.simularEnterBusqueda();
	}
	
	@AfterSuite 
	public void tearDown() {
		//driver.close();
		System.out.println("Fin de la Prueba");
	}
}
