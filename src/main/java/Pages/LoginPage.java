package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver){
        super(driver);
    }

    @FindBy(className = "page-header")
    private WebElement header;

    @FindBy(css= "input[name =\"user_login\"]")
    private WebElement usernameInputField;

    @FindBy(css= "input[name = \"user_password\"]")
    private WebElement passwordInputField;

    @FindBy(css = "input[name\"submit\"]")
    private WebElement submitButton;

    @FindBy(css = "div[class=\"alert alert-error\"]")
    private WebElement invalidCredentialsValidation;

    public  boolean isHeaderElementDisplayed(){
        return header.isDisplayed();
    }

    public String getHeaderText(){
        return header.getText();
    }

    public void enterUserName(){
        usernameInputField.sendKeys("username");
    }

    public void enterPassword(){
        passwordInputField.sendKeys("password");
    }
    public void clickLogInButton(){
        submitButton.click();
    }

    public String getInvalidCredentialsText(){
        return invalidCredentialsValidation.getText();
    }






}
