import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.module.Configuration;

public class LoginFeatureTest {
    private static final WebDriver driver = new ChromeDriver();
    static ChromeOptions chromeOptions = new ChromeOptions();

    static HomePage homePage = new HomePage(driver);
    static LoginPage loginPage = new LoginPage(driver);
    static AccountSummaryPage accountSummaryPage = new AccountSummaryPage(driver);
    public static String expectedHeaderString = "Log in to ZeroBank";
    public static String expectedAlertErrorMessage = "Login and/or password are wrong";

   @BeforeClass
   public void beforeClass(){
       driver.get("http://zero.webappsecurity.com/index.html");
       chromeOptions.addArguments("--allow-insecure-localhost");
       chromeOptions.addArguments("--incognito");
       chromeOptions.addArguments("--ignore-certificate-errors");
   }


    @Test
    public void successfulLoginTest() {

        boolean isHeaderDisplayed = loginPage.isHeaderElementDisplayed();
        String actualHeaderText = loginPage.getHeaderText();

        Assert.assertTrue(isHeaderDisplayed);
        Assert.assertEquals(actualHeaderText, expectedHeaderString);

        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.clickLogInButton();

        String currentUrl = driver.getCurrentUrl();
        accountSummaryPage.getText();

    }

    @Test
    public void invalidLoginTest(){
      loginPage.clickLogInButton();
      String expectedMessage = "Login and/or password are wrong. ";

      Assert.assertEquals(loginPage.getInvalidCredentialsText(),expectedMessage);





    }
        @AfterClass
        public void afterClass () {
            driver.close();
            driver.quit();
        }
    }


