package pages;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;


public class homePage {


    WebDriver webDriver;

    public homePage(WebDriver driver) throws Exception {
        this.webDriver = driver;
        PageFactory.initElements(this.webDriver, this);
        Thread.sleep(3000);

    }

    @FindBy(xpath = "//div[@class='pipptul6 a5q79mjw']")
    WebElement status;


    @FindBy(xpath = "//div[@contenteditable='true']")
    WebElement text;

    @FindBy(xpath = "//div[contains(text(),'Post')]")
    WebElement postButton;


    public void postStatus(String textStatus) throws IOException {


        status.click();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        text.sendKeys(textStatus);
        postButton.click();


        // Take Screenshot for Evidence
        File srce = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

        // Save the screenshot in the given path by the name FbStatus.png
        FileUtils.copyFile(srce, new File("./src/main/resources/screenshot/FbStatus.png"));

        System.out.println("screenshot successfully captured");

    }

}


