package pt.iscte.blackbattleship.rodrigo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Class da User Story 12.
 *
 * User Story 12:
 * "Como utilizador, quero conseguir aceder à página inicial
 * do PaperGames para navegar para outros jogos."
 *
 * @author Rodrigo
 */
public class UserStory12 {

    private final WebDriver driver;

    private final By paperGamesHomeLink =
            By.xpath("//a[contains(@href, 'papergames.io') or contains(., 'PaperGames')]");

    public UserStory12(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebsite() {
        driver.get("https://papergames.io/en/battleship");
    }

    public void clickPaperGamesHomeLink() {
        driver.findElement(paperGamesHomeLink).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}