package pt.iscte.blackbattleship.miguel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GamePageMiguel {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By nicknameInput = By.cssSelector("input[type='text']");
    private final By startButton = By.xpath("//button[contains(., 'Play')]");
    private final By continueButton =
            By.xpath("//button[.//text()[contains(., 'Continue')]]");

    // locator do tabuleiro (ajusta com inspect!!)
    private final By board = By.cssSelector("table.table-board");


    public GamePageMiguel(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isBoardVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(board)).isDisplayed();
    }

    public void enterNickname(String name) {

        // esperar input
        wait.until(ExpectedConditions.visibilityOfElementLocated(nicknameInput));

        driver.findElement(nicknameInput).clear();
        driver.findElement(nicknameInput).sendKeys(name);

        // esperar botão correto
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));

        // clicar corretamente
        try {
            driver.findElement(continueButton).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    driver.findElement(continueButton)
            );
        }
    }
}