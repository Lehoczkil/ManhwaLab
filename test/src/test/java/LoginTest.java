import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageFactory.*;

public class LoginTest {
    static LoginPage loginPage;
    static final String VALID_USERNAME = System.getProperty("username");
    static final String VALID_PASSWORD = System.getProperty("password");
    static final String EXPECTED_ERROR_MSG = "Invalid username or password";

    static final String INVALID_USERNAME = "aaa";
    static final String INVALID_PASSWORD = "111";

    @BeforeEach
    public void init(){
        loginPage = new LoginPage();
        loginPage.navigateToLogin();
    }

    @Test
    public void validLogin(){
        loginPage.openLoginModal();
        loginPage.loggingIn(VALID_USERNAME, VALID_PASSWORD);
        Assertions.assertTrue(loginPage.logoutIsDisplayed());
    }
    @Test
    public void emptyFieldLogin(){
        loginPage.openLoginModal();
        loginPage.clickOnLoginBtn();
        String errorMsg = loginPage.getErrorMsg();
        Assertions.assertEquals(errorMsg, EXPECTED_ERROR_MSG);
    }

    @Test
    public void logoutAfterSuccessfulLogin(){
        loginPage.openLoginModal();
        loginPage.loggingIn(VALID_USERNAME, VALID_PASSWORD);
        loginPage.logout();
        Assertions.assertTrue(loginPage.loginIsDisplayed());
    }

    @Test
    public void loginWithInvalidUsername(){
        loginPage.openLoginModal();
        loginPage.loggingIn(INVALID_USERNAME, VALID_PASSWORD);
        String errorMsg = loginPage.getErrorMsg();
        Assertions.assertEquals(errorMsg, EXPECTED_ERROR_MSG);
    }
    @Test
    public void loginWithInvalidPassword(){
        loginPage.openLoginModal();
        loginPage.loggingIn(VALID_USERNAME, INVALID_PASSWORD);
        String errorMsg = loginPage.getErrorMsg();
        Assertions.assertEquals(errorMsg, EXPECTED_ERROR_MSG);
    }

    @AfterEach
    public void tearDown(){
        loginPage.quit();
    }


}
