package pt.iscte.blackbattleship.rodrigo.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.iscte.blackbattleship.rodrigo.pages.UserStory10Selenide;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe de teste da User Story 10 usando Selenide.
 *
 * @author Rodrigo
 */
public class UserStory10SelenideTest {

    private UserStory10Selenide page;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1389x793";
        page = new UserStory10Selenide();
    }

    @Test
    public void changeLanguageOptionsTest() {
        page.openWebsite();

        page.clickLanguageButton();

        sleep(2000);

        String source = webdriver().driver().source().toLowerCase();

        assertTrue(
                source.contains("fr")
                        || source.contains("pt")
                        || source.contains("es")
                        || source.contains("português")
                        || source.contains("français")
                        || source.contains("español")
        );
    }
}