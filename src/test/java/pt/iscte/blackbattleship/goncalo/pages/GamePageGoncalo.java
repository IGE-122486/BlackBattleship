package pt.iscte.blackbattleship.goncalo.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GamePageGoncalo {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By homeButton = By.cssSelector("a[href='/']");
    private final By nicknameInput = By.cssSelector("input[type='text']");
    private final By continueButton = By.xpath("//button[contains(., 'Continue')]");
    private final By board = By.cssSelector("table.table-board");

    public GamePageGoncalo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void insertNickname(String nickname) {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(nicknameInput)
        );

        input.clear();
        input.sendKeys(nickname);
    }

    public void submitNickname() {
        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        );

        try {
            button.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", button);
        }
    }

    public boolean isGameLoaded() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(board)
        ).isDisplayed();
    }

    public boolean isNicknameInputVisible() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(nicknameInput)
        ).isDisplayed();
    }

    public boolean isContinueButtonDisabled() {
        WebElement button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(continueButton)
        );

        return !button.isEnabled();
    }

    public void goToHomePage() {
        driver.get("https://papergames.io/");
    }
}