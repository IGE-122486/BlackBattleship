package pt.iscte.blackbattleship.rodrigo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RodrigoSitePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final String url = "https://papergames.io/en/battleship";

    private final By privacyLink =
            By.xpath("//a[contains(., 'Privacy') or contains(., 'Terms')]");

    private final By languageButton =
            By.xpath("//*[contains(., 'EN') or contains(., 'English')]");

    private final By shareText =
            By.xpath("//*[contains(., 'Invite') or contains(., 'Share')]");

    private final By paperGamesHomeLink =
            By.xpath("//a[contains(@href, 'papergames.io') or contains(., 'PaperGames')]");

    public RodrigoSitePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get(url);
    }

    // US09
    public boolean hasPrivacyLink() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(privacyLink)).isDisplayed();
    }

    public void clickPrivacyLink() {
        wait.until(ExpectedConditions.elementToBeClickable(privacyLink)).click();
    }

    public boolean openedPrivacyPage() {
        return wait.until(driver ->
                driver.getCurrentUrl().toLowerCase().contains("privacy")
                        || driver.getCurrentUrl().toLowerCase().contains("terms")
                        || driver.getPageSource().toLowerCase().contains("privacy")
                        || driver.getPageSource().toLowerCase().contains("terms")
        );
    }

    // US10
    public boolean hasLanguageButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(languageButton)).isDisplayed();
    }

    public void clickLanguageButton() {
        wait.until(ExpectedConditions.elementToBeClickable(languageButton)).click();
    }

    public boolean languageMenuOpened() {
        return wait.until(driver ->
                driver.getPageSource().toLowerCase().contains("fr")
                        || driver.getPageSource().toLowerCase().contains("pt")
                        || driver.getPageSource().toLowerCase().contains("es")
        );
    }

    // US11
    public boolean hasShareOption() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shareText)).isDisplayed();
    }

    // US12
    public boolean hasPaperGamesHomeLink() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paperGamesHomeLink)).isDisplayed();
    }

    public void clickPaperGamesHomeLink() {
        wait.until(ExpectedConditions.elementToBeClickable(paperGamesHomeLink)).click();
    }

    public boolean openedPaperGamesHomePage() {
        return wait.until(driver ->
                driver.getCurrentUrl().equals("https://papergames.io/")
                        || driver.getCurrentUrl().equals("https://papergames.io")
                        || driver.getCurrentUrl().contains("papergames.io")
        );
    }
}