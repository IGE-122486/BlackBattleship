package pt.iscte.blackbattleship.miguel.selenide.tests;

import Miguel.MiguelSelenidePages.UserStory17SelenidePage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Teste automático da UserStory17SelenideTest.
 * US17 - Validar abertura da loja no site.
 */
public class UserStory17SelenideTest {

    @Test
    void testOpenShop() throws InterruptedException {

        UserStory17SelenidePage page =
                new UserStory17SelenidePage();

        page.openHomePage();

        page.acceptCookies();

        page.openShop();

        Thread.sleep(1000);

        assertTrue(page.isShopPageOpened());

        assertTrue(page.isCoinsButtonVisible());
    }
}