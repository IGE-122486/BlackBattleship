package GoncaloPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Class da User Story 16.
 *
 * Esta classe contém os localizadores e operações
 * necessárias para navegar entre páginas do jogo.
 *
 * User Story 16:
 * "Como jogador, quero navegar entre diferentes
 * páginas do jogo."
 *
 * @author Goncalo
 */
public class UserStory16 {

    /**
     * Instância do WebDriver.
     */
    private final WebDriver driver;

    /**
     * Localizador do Battleship.
     */
    private final By battleshipGame =
            By.cssSelector(".game-item:nth-child(1) .img-fluid");

    /**
     * Localizador do Tic Tac Toe.
     */
    private final By ticTacToeGame =
            By.cssSelector(".game-item:nth-child(2) .img-fluid");

    /**
     * Localizador do Connect 4.
     */
    private final By connect4Game =
            By.cssSelector(".game-item:nth-child(3) .img-fluid");

    /**
     * Localizador do Gomoku.
     */
    private final By gomokuGame =
            By.cssSelector(".game-item:nth-child(4) .img-fluid");

    /**
     * Localizador do Chess.
     */
    private final By chessGame =
            By.cssSelector(".game-item:nth-child(5) .thumbnail");

    /**
     * Localizador do último jogo.
     */
    private final By lastGame =
            By.cssSelector(".game-item:nth-child(6) .img-fluid");

    /**
     * Localizador do botão Home.
     */
    private final By homeButton =
            By.linkText("Home");

    /**
     * Construtor da classe.
     *
     * @param driver WebDriver utilizado
     */
    public UserStory16(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre o website PaperGames.
     */
    public void openWebsite() {

        driver.get("https://papergames.io/en/");
    }

    /**
     * Seleciona Battleship.
     */
    public void selectBattleship() {

        waitTime();

        driver.findElement(battleshipGame)
                .click();
    }

    /**
     * Seleciona Tic Tac Toe.
     */
    public void selectTicTacToe() {

        waitTime();

        driver.findElement(ticTacToeGame)
                .click();
    }

    /**
     * Seleciona Connect 4.
     */
    public void selectConnect4() {

        waitTime();

        driver.findElement(connect4Game)
                .click();
    }

    /**
     * Seleciona Gomoku.
     */
    public void selectGomoku() {

        waitTime();

        driver.findElement(gomokuGame)
                .click();
    }

    /**
     * Seleciona Chess.
     */
    public void selectChess() {

        waitTime();

        driver.findElement(chessGame)
                .click();
    }

    /**
     * Seleciona último jogo.
     */
    public void selectLastGame() {

        waitTime();

        driver.findElement(lastGame)
                .click();
    }

    /**
     * Volta à página inicial.
     */
    public void clickHomeButton() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        driver.findElement(homeButton)
                );
    }

    /**
     * Cria uma pausa na execução.
     */
    private void waitTime() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}