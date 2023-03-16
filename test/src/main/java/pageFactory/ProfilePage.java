package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasePage {

    static LoginPage loginPage;
    public ProfilePage()  {
        super();
    }

    @FindBy(xpath = "//*[@id=\"name\"]")
    WebElement nameInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div/article/section[1]/div[2]/div[1]/div[1]/span")
    WebElement nameText;
    @FindBy(xpath = "//*[@id=\"age\"]")
    WebElement ageInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div/article/section[1]/div[2]/div[1]/div[2]/span")
    WebElement ageText;
    @FindBy(xpath = "//*[@id=\"gender\"]")
    WebElement genderSelect;
    @FindBy(xpath = "//*[@id=\"app\"]/div/article/section[1]/div[2]/div[1]/div[3]/span")
    WebElement genderText;
    @FindBy(xpath = "//*[@id=\"location\"]")
    WebElement locationInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div/article/section[1]/div[2]/div[2]/div[1]/span")
    WebElement locationText;
    @FindBy(xpath = "//*[@id=\"description\"]")
    WebElement descriptionInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div/article/section[1]/div[2]/div[3]/p")
    WebElement descriptionText;
    @FindBy(xpath = "//*[@id=\"app\"]/div/header/nav/div[2]/button[2]")
    WebElement profileButton;
    @FindBy(className = "edit")
    WebElement editButton;

    public void login(String username, String password){

    }
    public void editName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(nameInput));
        this.nameInput.sendKeys(name);
    }

    public String getName(){
        wait.until(ExpectedConditions.elementToBeClickable(nameText));
        return nameText.getText();
    }

    public void changeBackName() {
        editButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(nameInput));
        nameInput.sendKeys("Hello");
        editButton.click();
    }

    public void editAge(String age) {
        wait.until(ExpectedConditions.elementToBeClickable(ageInput));
        this.ageInput.sendKeys(age);
    }

    public String getAge(){
        wait.until(ExpectedConditions.elementToBeClickable(ageText));
        return ageText.getText();
    }

    public void editGender(String gender){
        wait.until(ExpectedConditions.elementToBeClickable(genderSelect));
        Select select = new Select(genderSelect);
        select.selectByValue(gender);
    }

    public String getGender() {
        return genderText.getText();
    }

    public void editLocation(String newLocation) {
        wait.until(ExpectedConditions.elementToBeClickable(locationInput));
        locationInput.sendKeys(newLocation);
    }

    public String getLocation() {
        return locationText.getText();
    }

    public void editDescription(String newDescription) {
        wait.until(ExpectedConditions.elementToBeClickable(descriptionInput));
        descriptionInput.sendKeys(newDescription);
    }

    public String getDescription() {
        return descriptionText.getText();
    }

    public void navigateToProfile(){
        wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        profileButton.click();
    }

    public void clickEditButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButton.click();
        Thread.sleep(1000);
    }
}