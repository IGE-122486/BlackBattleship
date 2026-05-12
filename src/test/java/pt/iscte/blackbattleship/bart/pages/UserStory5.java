package pt.iscte.blackbattleship.bart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Class for UserStoryTest5.
 * Represents the flow where the user opens the Battleship page and accesses the game guides.
 */
public class UserStory5 {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By gameGuidesLink = By.xpath("//a[contains(@href,'game-guides')]");

    /**
     * Creates a UserStory5 page object.
     *
     * @param driver Selenium WebDriver instance.
     */
    public UserStory5(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /**
     * Opens the Battleship page directly.
     */
    public void openBattleshipPage() {
        driver.get("https://papergames.io/en/battleship");
        driver.manage().window().setSize(new Dimension(1296, 816));
    }

    /**
     * Scrolls the page to the top.
     */
    public void scrollToTop() {
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
        pause();
    }

    /**
     * Clicks the game guides link.
     */
    public void openGameGuides() {
        String currentWindow = driver.getWindowHandle();

        wait.until(ExpectedConditions.elementToBeClickable(gameGuidesLink)).click();
        pause();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    /**
     * Checks whether the opened page is a game guide page.
     *
     * @return true if the current URL contains game-guides.
     */
    public boolean isGameGuidesPageOpened() {
        wait.until(ExpectedConditions.urlContains("game-guides"));
        return driver.getCurrentUrl().contains("game-guides");
    }

    private void pause() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}