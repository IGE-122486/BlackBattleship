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
 * Page Object Class for UserStoryTest8.
 * Represents the flow where a user starts a robot Battleship game.
 */
public class UserStory8 {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By consentButton = By.cssSelector(".fc-cta-consent > .fc-button-label");
    private final By battleshipImage = By.xpath("//img[@alt='Battleship']");
    private final By robotGameButton = By.cssSelector(".w-100:nth-child(2) > .btn .flex-grow-1");
    private final By nicknameInput = By.cssSelector(".input-xl");
    private final By continueButton = By.cssSelector(".p-3 > .btn");

    public UserStory8(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    /**
     * Opens the PaperGames homepage.
     */
    public void openHomePage() {
        driver.get("https://papergames.io/en/");
        driver.manage().window().setSize(new Dimension(1296, 816));
    }

    /**
     * Accepts the consent popup if it appears.
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
     * Opens the Battleship game page.
     */
    public void openBattleshipGame() {
        click(battleshipImage);
    }

    /**
     * Chooses the robot opponent game mode.
     */
    public void selectRobotGame() {
        moveTo(robotGameButton);
        click(robotGameButton);
    }

    /**
     * Inserts the nickname.
     *
     * @param nickname nickname to insert.
     */
    public void typeNickname(String nickname) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(nicknameInput));
        input.clear();
        input.sendKeys(nickname);
        pause();
    }

    /**
     * Confirms the nickname.
     */
    public void confirmNickname() {
        click(continueButton);
        pauseLong();
    }

    /**
     * Checks whether the user has entered a game room.
     *
     * @return true if the current URL corresponds to a generated game room.
     */
    public boolean isGameRoomOpened() {
        wait.until(ExpectedConditions.urlContains("/en/r/"));
        return driver.getCurrentUrl().contains("/en/r/");
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

    private void pauseLong() {
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}