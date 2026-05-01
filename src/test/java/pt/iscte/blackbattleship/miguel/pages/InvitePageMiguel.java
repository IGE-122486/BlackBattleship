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
            By.xpath("//*[starts-with(text(),'https://papergames.io')]");

    public InvitePageMiguel(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public String getInviteLink() {
        var element = wait.until(ExpectedConditions.visibilityOfElementLocated(inviteLink));

        return (String) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return arguments[0].textContent;", element);
    }
}