package pt.iscte.blackbattleship.miguel.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pt.iscte.blackbattleship.pages.BattleshipHomePage;
import pt.iscte.blackbattleship.miguel.pages.GamePageMiguel;
import pt.iscte.blackbattleship.miguel.pages.ShopPageMiguel;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopAccessTest {

    private WebDriver driver;

    @Test
    void testOpenShop() throws InterruptedException {

        driver = new ChromeDriver();

        BattleshipHomePage home =
                new BattleshipHomePage(driver);

        home.open();

        home.acceptCookiesIfPresent();

        ShopPageMiguel shop =
                new ShopPageMiguel(driver);

        shop.openShop();

        Thread.sleep(1000);

        assertTrue(shop.isShopVisible());

        assertTrue(shop.hasInteractiveElements());
    }

    @AfterEach
    void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}