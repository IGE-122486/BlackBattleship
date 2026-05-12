package pt.iscte.blackbattleship.miguel.selenide.tests;

import Miguel.MiguelSelenidePages.UserStory4SelenidePage;

import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Teste automático da UserStory4SelenideTest.
 * US4 – Criar link de convite.
 */
public class UserStory4SelenideTest {

    @Test
    void testInviteLink() throws InterruptedException {

        UserStory4SelenidePage page =
                new UserStory4SelenidePage();

        page.openPage();

        page.acceptCookies();

        page.clickPlayOnline();

        page.insertNickname("Miguel");

        page.clickContinue();

        sleep(2000);

        assertTrue(page.inviteCreated());
    }
}