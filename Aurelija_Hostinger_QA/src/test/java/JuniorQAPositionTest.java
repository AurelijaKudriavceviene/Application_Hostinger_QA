
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.CareersPage;
import pageobject.HomePage;


public class JuniorQAPositionTest extends BaseTest {

    @Test
    void searchingForJobTitle() {
        HomePage homePage = new HomePage(driver);
        CareersPage careersPage = new CareersPage(driver);

        String searchingTitle = "Junior Quality Assurance";

        homePage.goToCareersPage();
        careersPage.findJuniorQAPosition();

        boolean isThereJuniorQAPosition = careersPage.hasAJobTitle(searchingTitle);
        Assertions.assertTrue(isThereJuniorQAPosition, "So sad, there are no junior QA positions at the moment");
        
    }
}
