package pt.iscte.blackbattleship.miguel.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pt.iscte.blackbattleship.pages.BattleshipHomePage;
import pt.iscte.blackbattleship.miguel.pages.InvitePageMiguel;

import static org.junit.jupiter.api.Assertions.*;

public class InviteLinkTest {

    private WebDriver driver;

    @Test
    void testCreateInviteLink() throws InterruptedException {
        driver = new ChromeDriver();

        BattleshipHomePage home = new BattleshipHomePage(driver);
        home.open();

        Thread.sleep(6000);

        home.clickPlayWithFriend();

        Thread.sleep(6000);

        InvitePageMiguel invitePage = new InvitePageMiguel(driver);

        String link = invitePage.getInviteLink();
        assertNotNull(link);
        assertTrue(link.contains("papergames.io"));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}