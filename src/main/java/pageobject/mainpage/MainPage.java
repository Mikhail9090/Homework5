package pageobject.mainpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.mainpage.sections.LoginPanel;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Created by Mikhail_Churakov on 6/6/2017.
 */
public class MainPage {
    static MainPage obj;
    public static MainPage get(WebDriver driver) {
        if(obj != null)
            return obj;
        obj = new MainPage();
        initElements(driver, obj);
        return obj;
    }
    @FindBy(css=".profile-photo")
    public static WebElement expandLoginPanel;

    public static LoginPanel loginPanel;
    @FindBy(css = ".profile-photo>span")
    public static WebElement profileName;
}
