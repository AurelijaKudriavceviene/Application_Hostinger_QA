
package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CareersPage extends BasePage {
    public CareersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "career-accordion-section__position-item")
    private List<WebElement> jobElements;

    public void findJuniorQAPosition() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed

        WebElement technicalSection = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[contains(@class, 'career-accordion-section__accordion') and .//h3[text()='Technical']]")
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", technicalSection
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getLocalizedMessage());
        }
        technicalSection.click();
    }

    public boolean hasAJobTitle(String searchingTitle) {
        for (WebElement jobElement : jobElements) {
            String jobTitle = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", jobElement);
            if (jobTitle.contains(searchingTitle)) {
                return true;
            }
        }
        return false;
    }
}
