package MiguelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object da UserStoryTest4.
 * US18 – Validar acesso aos meus torneios.
 */
public class UserStory4 {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public UserStory4(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By cookiesButton =
            By.cssSelector(".fc-cta-consent > .fc-button-label");

    private final By tournamentsButton =
            By.xpath("//span[contains(text(),'My tournaments')]");

    public void openPage() {

        driver.get("https://papergames.io/en/battleship");
    }

    public void acceptCookies() {

        wait.until(
                ExpectedConditions.elementToBeClickable(cookiesButton)
        ).click();
    }

    public void openMyTournaments() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(tournamentsButton)
        ).click();
    }

    public boolean tournamentsPageOpened() {

        return driver.getPageSource()
                .toLowerCase()
                .contains("tournament");
    }
}