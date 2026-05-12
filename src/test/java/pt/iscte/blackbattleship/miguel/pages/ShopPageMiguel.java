package pt.iscte.blackbattleship.miguel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPageMiguel {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By shopButton =
            By.xpath("//span[text()='Shop']/ancestor::a");


    private final By interactiveElements =
            By.cssSelector("button, a");

    public ShopPageMiguel(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By nicknameInputHome =
            By.xpath("//input[@placeholder='Nickname']");

    private final By continueButtonHome =
            By.xpath("//button[contains(., 'Continue')]");


    public void openShop() {

        WebElement button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(shopButton)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                button
        );
    }

    public boolean isShopVisible() {

        return driver.getPageSource()
                .toLowerCase()
                .contains("shop");
    }

    public boolean hasInteractiveElements() {

        return driver.findElements(interactiveElements).size() > 0;
    }
}