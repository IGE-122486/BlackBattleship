package pt.iscte.blackbattleship.rodrigo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RodrigoHomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By playButton = By.xpath("//button[contains(., 'Play')]");
    private final By instructionsLink = By.xpath("//*[contains(text(), 'Instructions') or contains(text(), 'Rules')]");

    public RodrigoHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://papergames.io/en/battleship");
    }

    public boolean isPlayButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(playButton)).isDisplayed();
    }

    public boolean isInstructionsLinkVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(instructionsLink)).isDisplayed();
    }

    public void clickPlay() {
        wait.until(ExpectedConditions.elementToBeClickable(playButton)).click();
    }

    public boolean pageChangedAfterPlay() {
        return wait.until(driver ->
                driver.getPageSource().toLowerCase().contains("nickname")
                        || driver.getPageSource().toLowerCase().contains("continue")
                        || driver.getPageSource().toLowerCase().contains("join")
                        || driver.getPageSource().toLowerCase().contains("create")
                        || driver.getCurrentUrl().contains("battleship")
        );
    }
    public void clickInstructions() {
        wait.until(ExpectedConditions.elementToBeClickable(instructionsLink)).click();
    }

    public boolean instructionsPageOpened() {
        return wait.until(driver ->
                driver.getPageSource().toLowerCase().contains("instructions")
                        || driver.getPageSource().toLowerCase().contains("rules")
                        || driver.getPageSource().toLowerCase().contains("how to play")
        );
    }
}