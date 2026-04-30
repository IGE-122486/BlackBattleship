package pt.iscte.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(By.cssSelector("button[aria-label='Search']")).click();
    }
}