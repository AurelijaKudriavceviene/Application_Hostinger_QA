package pageobject;
import helpers.ScrollingHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Karjera']")
    private WebElement karjeraBtnInputElement;

    public void goToCareersPage() {
        waitForVisibility(cookiesBtnElement);
        cookiesBtnElement.click();
        waitForVisibility(kodeePopupBTnElement);
        kodeePopupBTnElement.click();
        ScrollingHelper.scrollToBottom(driver, 10);
        karjeraBtnInputElement.click();
    }
}