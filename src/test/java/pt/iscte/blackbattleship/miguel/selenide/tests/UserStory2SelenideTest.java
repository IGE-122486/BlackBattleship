package pt.iscte.blackbattleship.miguel.selenide.tests;

import Miguel.MiguelSelenidePages.UserStory2SelenidePage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStory2SelenideTest {

    @Test
    void testStartNewGame() {

        UserStory2SelenidePage page =
                new UserStory2SelenidePage();

        page.openPage();

        page.rejectCookies();

        page.clickPlay();

        page.insertNickname("Miguel");

        page.clickContinue();

        assertTrue(page.gameStarted());
    }
}