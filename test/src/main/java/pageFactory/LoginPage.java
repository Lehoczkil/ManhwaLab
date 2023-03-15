package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {
    public LoginPage()  {
        super();
    }

    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy (xpath = "//button[text()='Login']")
    WebElement loginModal;

    @FindBy (xpath = "//button[text()='Logout']")
    WebElement logoutBtn;

    @FindBy (xpath = "//*[@class='btn login']")
    WebElement loginBtn;

    @FindBy (xpath = "//*[@class='invalid']")
    WebElement errorMsg;

    @FindBy(id = "browse")
    WebElement browseBtn;


    public void setUsername(String name) {
        username.sendKeys(name);
    }
    public void setPassword(String pwd){

        password.sendKeys(pwd);
    }

    public void openLoginModal(){
        wait.until(ExpectedConditions.elementToBeClickable(loginModal));
        loginModal.click();
    }

    public void clickOnLoginBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }
    public String getErrorMsg(){
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        return errorMsg.getText();
    }

    public void loggingIn(String user, String pwd) {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        setUsername(user);
        setPassword(pwd);
        clickOnLoginBtn();
    }

    public void logout(){
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        logoutBtn.click();
    }

    public boolean logoutIsDisplayed(){
        wait.until((ExpectedConditions.elementToBeClickable(logoutBtn)));
        return logoutBtn.isDisplayed();
    }

    public boolean loginIsDisplayed(){
        wait.until((ExpectedConditions.elementToBeClickable(loginModal)));
        return loginModal.isDisplayed();
    }

    public void navigateToLogin(){
        driver.get("http://localhost:8081/");
        wait.until(ExpectedConditions.elementToBeClickable(browseBtn));
    }

    public void quit () {
        WebDriverFactory.shutDown();
    }


}
