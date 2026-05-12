package pt.iscte.blackbattleship.goncalo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Class da User Story 16.
 *
 * Esta classe contém os métodos e localizadores
 * necessários para validar a navegação entre
 * diferentes páginas de jogos.
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
     * Localizador do jogo Battleship.
     */
    private final By battleshipGame =
            By.cssSelector(".game-item:nth-child(1) .img-fluid");

    /**
     * Localizador do jogo Tic Tac Toe.
     */
    private final By ticTacToeGame =
            By.cssSelector(".game-item:nth-child(2) .img-fluid");

    /**
     * Localizador do jogo Connect 4.
     */
    private final By connect4Game =
            By.cssSelector(".game-item:nth-child(3) .img-fluid");

    /**
     * Localizador do jogo Gomoku.
     */
    private final By gomokuGame =
            By.cssSelector(".game-item:nth-child(4) .img-fluid");

    /**
     * Localizador do botão Home.
     */
    private final By homeButton =
            By.linkText("Home");

    /**
     * Construtor da classe.
     *
     * @param driver WebDriver utilizado no teste
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
     * Seleciona o jogo Battleship.
     */
    public void selectBattleshipGame() {
        driver.findElement(battleshipGame).click();
    }

    /**
     * Seleciona o jogo Tic Tac Toe.
     */
    public void selectTicTacToeGame() {
        driver.findElement(ticTacToeGame).click();
    }

    /**
     * Seleciona o jogo Connect 4.
     */
    public void selectConnect4Game() {
        driver.findElement(connect4Game).click();
    }

    /**
     * Seleciona o jogo Gomoku.
     */
    public void selectGomokuGame() {
        driver.findElement(gomokuGame).click();
    }

    /**
     * Volta à página principal.
     */
    public void clickHomeButton() {
        driver.findElement(homeButton).click();
    }

    /**
     * Obtém o URL atual.
     *
     * @return URL atual
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}