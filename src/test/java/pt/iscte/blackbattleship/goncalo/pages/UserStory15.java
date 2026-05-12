package pt.iscte.blackbattleship.goncalo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Class da User Story 15.
 *
 * Esta classe contém os métodos e localizadores
 * necessários para validar o retorno à página inicial.
 *
 * User Story 15:
 * "Como jogador, quero voltar à página inicial
 * a partir do jogo."
 *
 * @author Goncalo
 */
public class UserStory15 {

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
     * Localizador do botão Play vs Robot.
     */
    private final By playVsRobotButton =
            By.cssSelector(".w-100:nth-child(2) > .btn .flex-grow-1");

    /**
     * Localizador do botão Abort Game.
     */
    private final By abortGameButton =
            By.cssSelector(".btn");

    /**
     * Localizador do botão de confirmação.
     */
    private final By confirmAbortButton =
            By.cssSelector(".btn-danger");

    /**
     * Localizador do botão Home.
     */
    private final By homeButton =
            By.cssSelector(".cdk-focused > .hide-if-collapsed");

    /**
     * Construtor da classe.
     *
     * @param driver WebDriver utilizado no teste
     */
    public UserStory15(WebDriver driver) {
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
     * Inicia um jogo contra o robot.
     */
    public void clickPlayVsRobot() {
        driver.findElement(playVsRobotButton).click();
    }

    /**
     * Seleciona a opção Abort Game.
     */
    public void clickAbortGame() {
        driver.findElement(abortGameButton).click();
    }

    /**
     * Confirma o abandono do jogo.
     */
    public void confirmAbortGame() {
        driver.findElement(confirmAbortButton).click();
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