package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(name="passwd")
	WebElement txtPassword;
	
	@FindBy(css="#SubmitLogin")
	WebElement btnEnter;
	
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void completarEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void completarPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void hacerClicEnEnter() {
		btnEnter.click();
	}
}
