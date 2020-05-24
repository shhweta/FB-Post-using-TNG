package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logout {
    WebDriver webDriver;
    @FindBy(xpath = "//body/div[@id='mount_0_0']/div/div/div/div[4]/div[1]/span[1]/div[1]")
    WebElement AccSettings;

    @FindBy(xpath = "//span[contains(text(),'Log Out')]")
    WebElement logout;

    public logout(WebDriver driver) throws Exception {
        this.webDriver = driver;
        PageFactory.initElements(this.webDriver, this);
        Thread.sleep(3000);

    }

    public void logout() {

        AccSettings.click();
        System.out.println(" successfully");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logout.click();
        System.out.println("log out successfully");

    }
}
