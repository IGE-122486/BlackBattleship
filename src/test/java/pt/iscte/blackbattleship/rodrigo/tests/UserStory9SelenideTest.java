package pt.iscte.blackbattleship.rodrigo.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.iscte.blackbattleship.rodrigo.pages.UserStory9Selenide;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de teste da User Story 9 usando Selenide.
 *
 * @author Rodrigo
 */
public class UserStory9SelenideTest {

    private UserStory9Selenide page;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1389x793";
        page = new UserStory9Selenide();
    }

    @Test
    public void accessPrivacyPageTest() {
        page.openWebsite();

        page.clickPrivacyLink();

        sleep(2000);

        String url = webdriver().driver().url().toLowerCase();
        String source = webdriver().driver().source().toLowerCase();

        assertTrue(
                url.contains("privacy")
                        || url.contains("terms")
                        || source.contains("privacy")
                        || source.contains("terms")
                        || source.contains("personal data")
                        || source.contains("legal")
        );
    }
}