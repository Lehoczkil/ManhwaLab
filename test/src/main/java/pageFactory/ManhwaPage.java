package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ManhwaPage extends BasePage{
    @FindBy (xpath = "//*[@id=\'app\']/div/article/main/div[2]/div[1]/div[1]/div[1]/span")
    WebElement type;

    public String getType(){
        wait.until(ExpectedConditions.elementToBeClickable(type));
        return type.getText();
    }

    public WebElement getElementByText(String text){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(
                By.xpath("//*[text()='"+text+"']"))));
        WebElement element = driver.findElement(By.xpath("//*[text()='"+text+"']"));
        return element;
    }

}
