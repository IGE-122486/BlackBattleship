package pt.iscte.blackbattleship.goncalo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Class da User Story 14.
 *
 * Esta classe contém os métodos e localizadores
 * necessários para validar que o sistema impede
 * o início do jogo sem nickname.
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
     * Localizador do botão Play vs Robot.
     */
    private final By playVsRobotButton =
            By.cssSelector(".w-100:nth-child(1) .flex-grow-1");

    /**
     * Localizador do botão Continue.
     */
    private final By continueButton =
            By.cssSelector(".p-3:nth-child(3)");

    /**
     * Localizador da mensagem de erro.
     */
    private final By errorMessage =
            By.xpath("//*[contains(text(),'Please choose a respectful username')]");

    /**
     * Construtor da classe.
     *
     * @param driver WebDriver utilizado no teste
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
        driver.findElement(ticTacToeGame).click();
    }

    /**
     * Seleciona a opção Play vs Robot.
     */
    public void clickPlayVsRobot() {
        driver.findElement(playVsRobotButton).click();
    }

    /**
     * Clica em Continue sem inserir nickname.
     */
    public void clickContinueWithoutNickname() {
        driver.findElement(continueButton).click();
    }

    /**
     * Obtém a mensagem de erro apresentada.
     *
     * @return texto da mensagem de erro
     */
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}