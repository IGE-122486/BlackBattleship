package pt.iscte.blackbattleship.miguel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InvitePageMiguel {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By inviteLink =
            By.xpath("//*[contains(., 'papergames.io')]");

    public InvitePageMiguel(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public String getInviteLink() {
        return wait.until(driver ->
                driver.findElement(inviteLink).getText()
        );
    }
}