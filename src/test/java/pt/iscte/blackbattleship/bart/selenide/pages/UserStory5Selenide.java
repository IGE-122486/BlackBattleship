package pt.iscte.blackbattleship.bart.selenide.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object Class for UserStory5 using Selenide.
 * Represents the flow where the user opens the Battleship page and accesses the game guides.
 */
public class UserStory5Selenide {

    /**
     * Opens the Battleship page directly.
     */
    public void openBattleshipPage() {
        open("https://papergames.io/en/battleship");
        sleep(700);
    }

    /**
     * Scrolls the page to the top.
     */
    public void scrollToTop() {
        executeJavaScript("window.scrollTo(0,0)");
        sleep(700);
    }

    /**
     * Opens the game guides link.
     */
    public void openGameGuides() {
        String currentWindow = webdriver().driver().getWebDriver().getWindowHandle();

        $$("a[href*='game-guides']")
                .findBy(Condition.visible)
                .click();

        sleep(1000);

        for (String windowHandle : webdriver().driver().getWebDriver().getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                switchTo().window(windowHandle);
                break;
            }
        }
    }

    /**
     * Checks whether the game guides page was opened.
     *
     * @return true if the URL contains game-guides.
     */
    public boolean isGameGuidesPageOpened() {
        return webdriver().driver().url().contains("game-guides");
    }
}