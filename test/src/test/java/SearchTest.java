import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageFactory.LoginPage;

public class SearchTest {
    static String VALID_USERNAME = System.getProperty("username");
    static final String VALID_PASSWORD = System.getProperty("password");
    static LoginPage loginPage;
    @BeforeEach
    public void init(){
        loginPage = new LoginPage();
        loginPage.navigateToLogin();
        loginPage.loggingIn(VALID_USERNAME,VALID_PASSWORD);
    }
    @AfterEach
    public void tearDown(){
        loginPage.quit();
    }

}
