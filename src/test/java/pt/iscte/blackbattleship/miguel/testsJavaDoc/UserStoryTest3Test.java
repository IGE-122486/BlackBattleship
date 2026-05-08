package pt.iscte.blackbattleship.miguel.testsJavaDoc;

import MiguelPages.UserStoryTest3Page;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testes automáticos da UserStoryTest3.
 * US17 - Validar abertura da loja no site.
 */
public class UserStoryTest3Test {

    private WebDriver driver;
    private UserStoryTest3Page page;

    @BeforeEach
    void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        page = new UserStoryTest3Page(driver);
    }

    /**
     * Valida a abertura da loja.
     */
    @Test
    void testOpenShop() throws InterruptedException {

        page.openHomePage();

        Thread.sleep(2000);

        page.acceptCookies();

        Thread.sleep(2000);

        page.openShop();

        Thread.sleep(3000);

        assertTrue(page.isShopPageOpened());

        assertTrue(page.isCoinsButtonVisible());
    }

    @AfterEach
    void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}