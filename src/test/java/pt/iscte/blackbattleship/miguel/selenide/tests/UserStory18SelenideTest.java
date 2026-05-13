package pt.iscte.blackbattleship.miguel.selenide.tests;

import Miguel.MiguelSelenidePages.UserStory18SelenidePage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Teste automático da UserStory18SelenideTest.
 * US18 – Validar acesso aos meus torneios.
 */
public class UserStory18SelenideTest {

    @Test
    void testTournamentAccess() throws InterruptedException {

        UserStory18SelenidePage page =
                new UserStory18SelenidePage();

        page.openPage();

        page.acceptCookies();

        page.openMyTournaments();

        Thread.sleep(1000);

        assertTrue(page.tournamentsPageOpened());
    }
}