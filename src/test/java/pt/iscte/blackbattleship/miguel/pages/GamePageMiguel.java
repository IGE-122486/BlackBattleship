package pt.iscte.blackbattleship.miguel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GamePageMiguel {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // locator do tabuleiro (ajusta com inspect!!)
    private final By board = By.cssSelector("table.table-board");


    public GamePageMiguel(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isBoardVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(board)).isDisplayed();
    }
}