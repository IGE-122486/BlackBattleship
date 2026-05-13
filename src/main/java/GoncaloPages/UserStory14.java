package GoncaloPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Class da User Story 14.
 *
 * Esta classe contém os localizadores e operações
 * necessárias para impedir o início do jogo
 * sem nickname.
 *
 * User Story 14:
 * "Como jogador, quero que o sistema impeça
 * o início do jogo sem inserir um nickname."
 *
 * @author Goncalo
 */
public class UserStory14 {

    /**
     * Instância do WebDriver.
     */
    private final WebDriver driver;

    /**
     * Localizador do jogo Tic Tac Toe.
     */
    private final By ticTacToeGame =
            By.cssSelector(".game-item:nth-child(2) .text-light");

    /**
     * Localizador do botão Play.
     */
    private final By playButton =
            By.cssSelector(".w-100:nth-child(2) > .btn .flex-grow-1");

    /**
     * Localizador do botão fechar.
     */
    private final By cancelButton =
            By.cssSelector(".mat-mdc-button-touch-target");

    /**
     * Construtor da classe.
     *
     * @param driver WebDriver utilizado
     */
    public UserStory14(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre o website PaperGames.
     */
    public void openWebsite() {

        driver.get("https://papergames.io/en/");
    }

    /**
     * Seleciona o jogo Tic Tac Toe.
     */
    public void selectTicTacToeGame() {

        driver.findElement(ticTacToeGame)
                .click();
    }

    /**
     * Seleciona o modo de jogo.
     */
    public void clickPlayButton() {

        driver.findElement(playButton)
                .click();
    }

    /**
     * Clica no botão fechar.
     */
    public void clickCancelButton() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        driver.findElement(cancelButton)
                );
    }
}