package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Elementos
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	@FindBy(linkText="Contact us")
	WebElement lnkContactUs;
	
	// Constructor
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this); // Inicializa los elementos de la página
	}
	
	// Métodos/Acciones
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void ingresarPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void simularEnterBusqueda() {
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	public void hacerClicEnContactUs() {
		lnkContactUs.click();
	}
}
