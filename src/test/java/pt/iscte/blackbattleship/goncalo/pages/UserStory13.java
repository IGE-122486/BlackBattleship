package pt.iscte.blackbattleship.goncalo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Class da User Story 13.
 *
 * Esta classe contém os localizadores e operações
 * necessárias para validar nicknames inválidos.
 *
 * User Story 13:
 * "Como jogador, quero que o sistema valide
 * o nickname introduzido."
 *
 * @author Goncalo
 */
public class UserStory13 {

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
            By.cssSelector(".w-100:nth-child(1) > .btn");

    /**
     * Localizador do campo nickname.
     */
    private final By nicknameField =
            By.cssSelector(".input-xl");

    /**
     * Localizador do botão Continue.
     */
    private final By continueButton =
            By.cssSelector(".p-3 > .btn");

    /**
     * Localizador da mensagem de erro.
     */
    private final By errorMessage =
            By.cssSelector(".text-center");

    /**
     * Construtor da classe.
     *
     * @param driver WebDriver utilizado
     */
    public UserStory13(WebDriver driver) {
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
     * Seleciona a opção Play vs Robot.
     */
    public void clickPlayVsRobot() {
        driver.findElement(playVsRobotButton).click();
    }

    /**
     * Introduz nickname inválido.
     *
     * @param nickname nickname inválido
     */
    public void enterInvalidNickname(String nickname) {

        driver.findElement(nicknameField)
                .sendKeys(nickname);
    }

    /**
     * Clica no botão Continue.
     */
    public void clickContinue() {

        driver.findElement(continueButton)
                .click();
    }

    /**
     * Obtém a mensagem de erro.
     *
     * @return texto da mensagem
     */
    public String getErrorMessage() {

        return driver.findElement(errorMessage)
                .getText();
    }
}