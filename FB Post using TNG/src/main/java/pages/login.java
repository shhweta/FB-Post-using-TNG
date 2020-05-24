package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
    WebDriver webDriver;

    public login(WebDriver driver) throws Exception {
        this.webDriver = driver;
        PageFactory.initElements(this.webDriver, this);
        Thread.sleep(2000);
    }

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(id = "loginbutton")
    WebElement loginButton;

    public void login(String username, String password){
        emailField.sendKeys(username);
        System.out.println("Entered Username: "+username);
        passwordField.sendKeys(password);
        System.out.println("Entered Password: "+password);
        loginButton.click();
        System.out.println("Clicked on Login button");
        System.out.println("logged in successfully");

    }
}