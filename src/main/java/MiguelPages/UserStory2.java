package MiguelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object da UserStoryTest1.
 * US2 – Iniciar novo jogo.
 */
public class UserStory2 {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public UserStory2(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By cookiesButton =
            By.cssSelector(".fc-cta-do-not-consent > .fc-button-label");

    private final By playButton =
            By.cssSelector(".w-100:nth-child(2) > .btn .flex-grow-1");

    private final By nicknameInput =
            By.cssSelector(".input-xl");

    private final By continueButton =
            By.cssSelector(".p-3 > .btn");

    public void openPage() {

        driver.get("https://papergames.io/en/battleship");
    }

    public void rejectCookies() {

        wait.until(
                ExpectedConditions.elementToBeClickable(cookiesButton)
        ).click();
    }

    public void clickPlay() {

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

    public boolean gameStarted() {

        return driver.getPageSource()
                .toLowerCase()
                .contains("2000");
    }
}