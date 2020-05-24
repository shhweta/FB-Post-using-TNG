import Utils.Base;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homePage;
import pages.login;
import pages.logout;


public class FacebookPostTest extends Base {
    String userName = ""; //Enter your username for facebook
    String password = ""; //Enter your password for facebook
    login objLogin;
    homePage objHome;
    logout objLogout;


    @BeforeClass
    public void initialize() {
        initiateTest();
    }

    @Test
    public void FacebookPostTest() throws Exception {
        // webDriver.get("https:\\www.facebook.com");
        objLogin = new login(webDriver);
        objHome = new homePage(webDriver);
        objLogout = new logout(webDriver);
        objLogin.login(userName, password);
        objHome.postStatus("Hello World");
        objLogout.logout();

    }

    @AfterTest
    public static void closeTest() {
        webDriver.quit();
    }
}