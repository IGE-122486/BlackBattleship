package pt.iscte.blackbattleship.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BattleshipHomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final String BASE_URL = "https://papergames.io/en/battleship";

    private final By playVsRobotLink = By.xpath("//*[contains(text(), 'Play vs robot')]");
    private final By playWithFriendLink = By.xpath("//*[contains(text(), 'Play with a friend')]");
    private final By rulesTitle = By.xpath("//*[contains(text(), 'Rules of Battleship game online')]");

    public BattleshipHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public boolean isPageOpen() {
        return driver.getTitle().toLowerCase().contains("battleship");
    }

    public boolean isPlayVsRobotVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(playVsRobotLink)).isDisplayed();
    }

    public boolean isPlayWithFriendVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(playWithFriendLink)).isDisplayed();
    }

    public void clickPlayVsRobot() {
        wait.until(ExpectedConditions.elementToBeClickable(playVsRobotLink)).click();
    }

    public void scrollToRules() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(rulesTitle));
    }

    public boolean areRulesVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(rulesTitle)).isDisplayed();
    }

    public boolean pageContains(String text) {
        return driver.getPageSource().toLowerCase().contains(text.toLowerCase());
    }
}