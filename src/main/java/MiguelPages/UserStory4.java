package MiguelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object da UserStoryTest2.
 * US4 – Criar link de convite.
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

    private final By playButton =
            By.cssSelector(".w-100:nth-child(1) .flex-grow-1");

    private final By nicknameInput =
            By.cssSelector(".input-xl");

    private final By continueButton =
            By.cssSelector(".p-3 > .btn");

    public void openPage() {

        driver.get("https://papergames.io/en/battleship");
    }

    public void acceptCookies() {

        wait.until(
                ExpectedConditions.elementToBeClickable(cookiesButton)
        ).click();
    }

    public void clickPlayOnline() {

        wait.until(
                ExpectedConditions.elementToBeClickable(playButton)
        ).click();
    }

    public void insertNickname(String nickname) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(nicknameInput)
        ).sendKeys(nickname);
    }

    public void clickContinue() {

        wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        ).click();
    }

    public boolean inviteCreated() {

        return driver.getPageSource()
                .toLowerCase()
                .contains("2000");
    }
}