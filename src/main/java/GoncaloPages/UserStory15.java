package GoncaloPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Class da User Story 15.
 *
 * Esta classe contém os localizadores e operações
 * necessárias para voltar à página inicial.
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
            By.cssSelector(".w-100:nth-child(2) > .btn > .front");

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
     * Localizador do botão Abort.
     */
    private final By abortButton =
            By.xpath("//*[contains(text(),'Abort')]");

    /**
     * Localizador do botão Confirm.
     */
    private final By confirmButton =
            By.cssSelector(".btn-danger");

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

        driver.findElement(battleshipGame)
                .click();
    }

    /**
     * Seleciona o modo Play vs Robot.
     */
    public void clickPlayVsRobot() {

        driver.findElement(playVsRobotButton)
                .click();
    }

    /**
     * Introduz nickname.
     *
     * @param nickname nickname do jogador
     */
    public void enterNickname(String nickname) {

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
     * Aborta o jogo.
     */
    public void clickAbortButton() {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        driver.findElement(abortButton)
                );
    }

    /**
     * Confirma o abandono do jogo.
     */
    public void clickConfirmButton() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(confirmButton)
                .click();
    }

    /**
     * Volta à página inicial.
     */
    public void clickHomeButton() {

        driver.findElement(homeButton)
                .click();
    }
}