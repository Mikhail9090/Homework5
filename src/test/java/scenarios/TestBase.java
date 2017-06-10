package scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mikhail_Churakov on 6/6/2017.
 */
public class TestBase {
    private static WebDriver webDriver;
    private String testHost = "https://epam.github.io/JDI/index.htm";
    private String geckoDriverPath = "C:\\GeckoDriver/\\geckodriver.exe";
    private String chromeDriverPath = "C:\\ChromeDriver\\chromedriver.exe";
    private String browser = "chrome";

    public WebDriver initWebDriver() {
        if (webDriver == null) {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--kiosk");
                webDriver = new ChromeDriver(options);
            }
            if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", geckoDriverPath);
                webDriver = new FirefoxDriver();
            }
            webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public void closeBrowser() {
        webDriver.close();
    }

    public void openBrowser() {
        webDriver.navigate().to(testHost);
    }

    public void assertTrue(boolean value) {
        Assert.assertTrue(value);
    }

    public void assertFalse(boolean value) {
        Assert.assertFalse(value);
    }

    public void assertsTrue(String input, String expected) {
        Assert.assertEquals(input, expected);
    }
    public void type(String input, WebElement webElement) {
        webElement.sendKeys(input);
    }
}
