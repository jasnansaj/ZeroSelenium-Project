package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummaryPage extends BasePage {

    public AccountSummaryPage (WebDriver driver){
        super(driver);
    }

    @FindBy(css = "a[class\"dropdown-toggle\"]>i")
    private WebElement loggedInUser;

    public String getText(){
        return loggedInUser.getText();
    }
}
