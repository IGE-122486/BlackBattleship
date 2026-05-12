package pt.iscte.blackbattleship.rodrigo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Class da User Story 10.
 *
 * User Story 10:
 * "Como utilizador, quero conseguir alterar o idioma
 * da página para navegar no jogo numa língua que compreendo."
 *
 * @author Rodrigo
 */
public class UserStory10 {

    private final WebDriver driver;

    private final By languageButton =
            By.xpath("//*[contains(., 'EN') or contains(., 'English')]");

    public UserStory10(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebsite() {
        driver.get("https://papergames.io/en/battleship");
    }

    public void clickLanguageButton() {
        driver.findElement(languageButton).click();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }
}