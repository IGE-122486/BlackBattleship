package pt.iscte.blackbattleship.rodrigo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Class da User Story 9.
 *
 * User Story 9:
 * "Como utilizador, quero conseguir aceder às páginas
 * de termos e privacidade para consultar informação legal do serviço."
 *
 * @author Rodrigo
 */
public class UserStory9 {

    private final WebDriver driver;

    private final By privacyOrTermsLink =
            By.xpath("//a[contains(., 'Privacy') or contains(., 'Terms')]");

    public UserStory9(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebsite() {
        driver.get("https://papergames.io/en/battleship");
    }

    public void clickPrivacyOrTermsLink() {
        driver.findElement(privacyOrTermsLink).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }
}