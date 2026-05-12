package pt.iscte.blackbattleship.bart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Class for UserStoryTest3.
 * Represents the flow where a user opens Battleship and chooses to play against a robot.
 */
public class UserStory3 {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By consentButton = By.cssSelector(".fc-cta-consent > .fc-button-label");
    private final By battleshipThumbnail = By.cssSelector(".game-item:nth-child(1) .thumbnail");
    private final By robotGameButton = By.cssSelector(".w-100:nth-child(2) > .btn .flex-grow-1");
    private final By nicknameInput = By.cssSelector(".input-xl");
    private final By continueButton = By.cssSelector(".p-3 > .btn");

    /**
     * Creates a UserStory3 page object.
     *
     * @param driver Selenium WebDriver instance.
     */
    public UserStory3(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /**
     * Opens the PaperGames homepage.
     */
    public void openHomePage() {
        driver.get("https://papergames.io/en/");
        driver.manage().window().setSize(new Dimension(1296, 816));
    }

    /**
     * Accepts the cookie consent dialog if it is shown.
     */
    public void acceptConsentIfVisible() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(consentButton)).click();
            pause();
        } catch (Exception ignored) {
            // Consent popup may not appear in every execution.
        }
    }

    /**
     * Opens the Battleship game.
     */
    public void openBattleshipGame() {
        moveTo(battleshipThumbnail);
        click(battleshipThumbnail);
    }

    /**
     * Selects the option to play against a robot.
     */
    public void selectRobotGame() {
        moveTo(robotGameButton);
        click(robotGameButton);
    }

    /**
     * Types a nickname in the guest registration dialog.
     *
     * @param nickname nickname to be inserted.
     */
    public void typeNickname(String nickname) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(nicknameInput));
        input.clear();
        input.sendKeys(nickname);
        pause();
    }

    /**
     * Confirms the guest registration.
     */
    public void confirmNickname() {
        click(continueButton);
    }

    /**
     * Checks whether the nickname input is visible.
     *
     * @return true if visible.
     */
    public boolean isNicknameInputVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nicknameInput)).isDisplayed();
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        pause();
    }

    private void moveTo(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        new Actions(driver).moveToElement(element).perform();
        pause();
    }

    private void pause() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}