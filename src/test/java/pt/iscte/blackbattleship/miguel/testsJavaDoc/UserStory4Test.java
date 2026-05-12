package pt.iscte.blackbattleship.miguel.testsJavaDoc;

import Miguel.MiguelPages.UserStory4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Teste automático da UserStoryTest2.
 * US4 – Criar link de convite.
 */
public class UserStory4Test {

    private WebDriver driver;

    @Test
    void testInviteLink() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        UserStory4 page =
                new UserStory4(driver);

        page.openPage();

        Thread.sleep(2000);

        page.acceptCookies();

        Thread.sleep(1000);

        page.clickPlayOnline();

        Thread.sleep(1000);

        page.insertNickname("Miguel");

        Thread.sleep(1000);

        page.clickContinue();

        Thread.sleep(3000);

        assertTrue(page.inviteCreated());
    }

    @AfterEach
    void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}