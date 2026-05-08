package MiguelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object da UserStoryTest3.
 * US17 - Validar abertura da loja no site.
 */
public class UserStoryTest3Page {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public UserStoryTest3Page(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators obtidos do ficheiro .side

    private final By consentButton =
            By.cssSelector(".fc-cta-consent > .fc-button-label");

    private final By shopButton =
            By.cssSelector(".cdk-focused > .hide-if-collapsed");

    private final By coinsButton =
            By.linkText("Coins");

    /**
     * Abre a página principal do jogo.
     */
    public void openHomePage() {

        driver.get("https://papergames.io/en/battleship");
    }

    /**
     * Aceita os cookies.
     */
    public void acceptCookies() {

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(consentButton)
        );

        button.click();
    }

    /**
     * Abre a página da loja.
     */
    public void openShop() {

        WebElement button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(shopButton)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                button
        );
    }

    /**
     * Verifica se o botão Coins está visível.
     */
    public boolean isCoinsButtonVisible() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(coinsButton)
        ).isDisplayed();
    }

    /**
     * Verifica se a página da loja abriu corretamente.
     */
    public boolean isShopPageOpened() {

        return driver.getCurrentUrl().contains("shop")
                || driver.getPageSource().toLowerCase().contains("coins");
    }
}