package pt.iscte.blackbattleship.bart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GamePageBartolomeu {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By nicknameInput = By.xpath(
            "//input[@type='text' or " +
                    "contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'name') or " +
                    "contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'nickname') or " +
                    "contains(translate(@aria-label,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'name') or " +
                    "contains(translate(@aria-label,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'nickname')]"
    );

    private final By gameLoadedElement = By.xpath(
            "//*[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'your turn') or " +
                    "contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'opponent') or " +
                    "contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'ships') or " +
                    "contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'fleet') or " +
                    "contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'battle')]"
    );

    private final By possibleBoardCells = By.cssSelector(
            "td, canvas, .cell, [class*='cell'], [class*='square'], [class*='case'], [class*='board'] button"
    );

    public GamePageBartolomeu(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isRobotGamePageOpen() {
        return wait.until(d -> d.getCurrentUrl().contains("/r/"));
    }

    public boolean isNicknameInputVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nicknameInput)).isDisplayed();
    }

    public void insertAndSubmitNickname(String nickname) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(nicknameInput));
        input.clear();
        input.sendKeys(nickname);
        input.sendKeys(Keys.ENTER);
    }

    public boolean isGameLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(gameLoadedElement)).isDisplayed()
                    || hasBoardOrCanvas();
        } catch (TimeoutException e) {
            return hasBoardOrCanvas();
        }
    }

    public boolean hasBoardOrCanvas() {
        try {
            List<WebElement> elements = wait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(possibleBoardCells)
            );
            return !elements.isEmpty();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean pageContains(String text) {
        return driver.getPageSource().toLowerCase().contains(text.toLowerCase());
    }
}