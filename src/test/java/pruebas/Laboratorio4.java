package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio4 {
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
	
	@Test(dataProvider="Datos para el login desde Excel")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.completarEmail(email);
		login.completarPassword(password);
		login.hacerClicEnEnter();
	}
	
	@DataProvider(name="Datos para el login desde Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionIT11Sep\\Datos\\datosLab4_E2.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Datos para el login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[3][2];
		
		datos[0][0] = "correo123@correo.com"; // Correo
		datos[0][1] = "9876555!"; // Contraseña
		
		datos[1][0] = "correo124@correo.com";
		datos[1][1] = "32wesdtr";
		
		datos[2][0] = "correo125@correo.com";
		datos[2][1] = "78uityur";
		
		return datos;
	}
	
	@AfterSuite 
	public void tearDown() {
		//driver.close();
		System.out.println("Fin de la Prueba");
	}
}
