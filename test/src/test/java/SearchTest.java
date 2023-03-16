import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageFactory.ComicsPage;
import pageFactory.LoginPage;
import pageFactory.ManhwaPage;

public class SearchTest {
    static String VALID_USERNAME = System.getProperty("username");
    static final String VALID_PASSWORD = System.getProperty("password");
    static LoginPage loginPage;
    static ComicsPage comicsPage;
    static ManhwaPage manhwaPage;
    static String EXPECTING_URL = "http://localhost:8081/comics";
    static String NOT_EXISTING_MANWHA_ERROR_MSG = "Whitelabel Error Page";

    @BeforeEach
    public void init(){
        loginPage = new LoginPage();
        comicsPage = new ComicsPage();
        manhwaPage = new ManhwaPage();
        loginPage.navigateToLogin();
        loginPage.openLoginModal();
        loginPage.loggingIn(VALID_USERNAME, VALID_PASSWORD);
        comicsPage.clickSearchBtn();
    }

    @Test
    public void ExistingManhwa() throws InterruptedException {
        comicsPage.fillSearchField("Villain To Kill");
        comicsPage.clickSearchBtn();
        Thread.sleep(1000);
        String actualTitle = comicsPage.findComicByTitel("Villain To Kill").getText();
        Assertions.assertEquals("Villain To Kill",actualTitle);
    }
    @Test
    public void emptyField(){
        comicsPage.clickSearchBtn();
        String currentUrl = comicsPage.getCurrentUrl();
        Assertions.assertEquals(EXPECTING_URL,currentUrl);
    }

    @Test
    public void nonExistingManhwa(){
        comicsPage.navigateToNotExistComic();
        Assertions.assertEquals(comicsPage.getErrorMsg(),NOT_EXISTING_MANWHA_ERROR_MSG);
    }
    @AfterEach
    public void tearDown(){
        loginPage.quit();
    }
}
