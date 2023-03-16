package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComicsPage extends BasePage{
    @FindBy (xpath = "//*[@id='app']/div/header/nav/div[1]/button[text()='Search']")
    WebElement searchBtn;
    @FindBy (xpath = "//*[@id='search']")
    WebElement searchFild;

    public void clickSearchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        searchBtn.click();
    }
    public void fillSearchField(String title){
        wait.until(ExpectedConditions.elementToBeClickable(searchFild));
        searchFild.sendKeys(title);
    }
    public void navigateToComics(){
        driver.get("http://localhost:8081/comics");
    }


}
