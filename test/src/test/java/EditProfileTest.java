import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.bidi.log.Log;
import pageFactory.LoginPage;
import pageFactory.ProfilePage;

public class EditProfileTest {
    static ProfilePage profilePage;
    static LoginPage loginPage;
    static final String VALID_USERNAME = System.getProperty("username");
    static final String VALID_PASSWORD = System.getProperty("password");
    static final String NEW_NAME = "asd";
    static final String NEW_GENDER = "FEMALE";
    static final String NEW_AGE = "42";
    private static final String NEW_LOCATION = "Kecsked";
    private static final String NEW_DESCRIPTION = "Hello I'm Hello! This is new Description! c:";

    @BeforeEach
    public void init() throws InterruptedException {
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        loginPage.navigateToLogin();
        loginPage.openLoginModal();
        loginPage.loggingIn(VALID_USERNAME, VALID_PASSWORD);
        Thread.sleep(2000);
        profilePage.navigateToProfile();
    }

    @AfterEach
    public void tearDown(){
        loginPage.logout();
        profilePage.quit();
    }

    @Test
    public void changeUserAge() throws InterruptedException {
        profilePage.clickEditButton();
        profilePage.editAge(NEW_AGE);
        profilePage.clickEditButton();
//        System.out.println(NEW_AGE + " " + profilePage.getAge()); //Prints ages in console.
        Assertions.assertEquals(NEW_AGE,profilePage.getAge());

    }

    @Test
    public void changeUserGender() throws InterruptedException {
        profilePage.clickEditButton();
        profilePage.editGender(NEW_GENDER);
        profilePage.clickEditButton();
//        System.out.println(NEW_GENDER + " " + profilePage.getGender()); //Prints genders in console.
        Assertions.assertEquals(NEW_GENDER,profilePage.getGender());
    }

    @Test
    public void changeUserName() throws InterruptedException {
        profilePage.clickEditButton();
        profilePage.editName(NEW_NAME);
        profilePage.clickEditButton();
//        System.out.println(NEW_NAME + " " + profilePage.getName()); //Prints names in console.
        Assertions.assertEquals(NEW_NAME,profilePage.getName());
        profilePage.changeBackName();
    }

    @Test
    public void changeUserLocation() throws InterruptedException {
        profilePage.clickEditButton();
        profilePage.editLocation(NEW_LOCATION);
        profilePage.clickEditButton();
        System.out.println(NEW_LOCATION + " " + profilePage.getLocation()); //Prints locations in console.
        Assertions.assertEquals(NEW_LOCATION,profilePage.getLocation());
        profilePage.changeBackName();
    }

    @Test
    public void changeUserDescription() throws InterruptedException {
        profilePage.clickEditButton();
        profilePage.editDescription(NEW_DESCRIPTION);
        profilePage.clickEditButton();
        System.out.println(NEW_DESCRIPTION + " " + profilePage.getDescription()); //Prints descriptions in console.
        Assertions.assertEquals(NEW_DESCRIPTION,profilePage.getDescription());
        profilePage.changeBackName();
    }



}
