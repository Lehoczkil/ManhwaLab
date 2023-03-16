package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManhwaPage extends BasePage{
    @FindBy (xpath = "//*[@id=\'app\']/div/article/main/div[2]/div[1]/div[1]/div[1]/span")
    WebElement type;

    public String getType(){
        wait.until(ExpectedConditions.elementToBeClickable(type));
        return type.getText();
    }
}
