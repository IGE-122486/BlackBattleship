package pt.iscte.blackbattleship.miguel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TournamentPageMiguel {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By tournamentsButton =
            By.xpath("//span[text()='My tournaments']/ancestor::a");

    private final By interactiveElements =
            By.cssSelector("button, a");

    public TournamentPageMiguel(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openTournaments() {

        WebElement button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(tournamentsButton)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                button
        );
    }

    public boolean isTournamentPageVisible() {

        return driver.getPageSource()
                .toLowerCase()
                .contains("tournament");
    }

    public boolean hasInteractiveElements() {

        return driver.findElements(interactiveElements).size() > 0;
    }
}