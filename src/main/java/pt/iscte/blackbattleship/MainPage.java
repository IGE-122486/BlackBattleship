package pt.iscte.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.jetbrains.com/");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // espera até encontrar o botão e só depois clica
        wait.until(d -> d.findElement(By.cssSelector("button[aria-label='Search']")));
        driver.findElement(By.cssSelector("button[aria-label='Search']")).click();
    }

    public boolean isSearchInputVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        return wait.until(d ->
                d.findElement(By.cssSelector("input[type='search']")).isDisplayed()
        );
    }
}