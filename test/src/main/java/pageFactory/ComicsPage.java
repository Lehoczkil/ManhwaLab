package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ComicsPage extends BasePage{
    @FindBy (xpath = "//*[@id='app']/div/header/nav/div[1]/button[text()='Search']")
    WebElement searchBtn;
    @FindBy (xpath = "//*[@id='search']")
    WebElement searchFild;
    @FindBy (xpath = "/html/body/h1")
    WebElement errorMsg;
    @FindBy (xpath = "//*[@id='Genre']")
    WebElement genreDropDown;
    @FindBy(xpath = "//*[@id='Theme']")
    WebElement themeDropDown;
    @FindBy(xpath = "//*[@id='Type']")
    WebElement typeDropDown;
    @FindBy(xpath = "//*[@id='sort']")
    WebElement sortByDropDown;
    @FindBy(xpath = "//*[@id=\'app\']/div/article/section/div[3]/button")
    WebElement goBtn;

    public void clickSearchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        searchBtn.click();
    }
    public void fillSearchField(String title){
        wait.until(ExpectedConditions.elementToBeClickable(searchFild));
        searchFild.sendKeys(title);
    }
    public WebElement findComicByTitel(String title){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
                By.xpath("//*[text()='"+title+"']"))));
        WebElement comic = driver.findElement(By.xpath("//*[text()='"+title+"']"));
        return comic;
    }
    public String getErrorMsg(){
        wait.until(ExpectedConditions.elementToBeClickable(errorMsg));
        return errorMsg.getText();
    }
    public void navigateToComics(){
        driver.get("http://localhost:8081/comics");
    }
    public void selectGenre(String value){
        wait.until(ExpectedConditions.elementToBeClickable(genreDropDown));
        Select select = new Select(genreDropDown);
        select.selectByValue(value);
    }
    public void selectType(String value){
        wait.until(ExpectedConditions.elementToBeClickable(typeDropDown));
        Select select = new Select(typeDropDown);
        select.selectByValue(value);
    }
    public void slectTheme(String value){
        wait.until(ExpectedConditions.elementToBeClickable(themeDropDown));
        Select select = new Select(themeDropDown);
        select.selectByValue(value);
    }
    public void slectShortBy(String value){
        wait.until(ExpectedConditions.elementToBeClickable(sortByDropDown));
        Select select = new Select(sortByDropDown);
        select.selectByValue(value);
    }
    public void clickGoBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(goBtn));
        goBtn.click();
    }

    public void navigateToNotExistComic(){
        driver.get("http://localhost:8081/comics/9999");
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }


}
