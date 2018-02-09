import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

public class TestWebdriver {
    private WebDriver driver;
    private String os = "linux";

    private WebDriver getLinuxDriver(char browser) {
        switch (browser) {
            case 'F':
                System.setProperty("webdriver.gecko.driver", "/var/www/webdrivers-test/drivers/linux-drivers/geckodriver-v0.19.1-linux64");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("PageLoadStrategy", "eager");
                return driver = new FirefoxDriver(firefoxOptions);
            case 'C':
                System.setProperty("webdriver.chrome.driver", "/var/www/webdrivers-test/drivers/linux-drivers/chromedriver-v2.35-linux64");
                return driver = new ChromeDriver();
            case 'O':
                System.setProperty("webdriver.opera.driver", "/var/www/webdrivers-test/drivers/linux-drivers/operadriver-v2.33-linux64");
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.setBinary("/usr/bin/opera");
                return driver = new OperaDriver(operaOptions);
            default:
                System.out.println("available browsers: 'F' for Firefox, 'C' for Chrome, 'O' for Opera.");
                return driver = new HtmlUnitDriver();
        }
    }

    private WebDriver getWindowsDriver(char browser) {
        switch (browser) {
            case 'F':
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\drivers\\windows-drivers\\geckodriver-v0.19.1-win64.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("PageLoadStrategy", "normal");
                return driver = new FirefoxDriver(firefoxOptions);
            case 'C':
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\drivers\\windows-drivers\\chromedriver-v2.35-win32.exe");
                return driver = new ChromeDriver();
            case 'O':
                System.setProperty("webdriver.opera.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\drivers\\windows-drivers\\operadriver-v2.33-win64.exe");
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.setBinary("C:\\Program Files (x86)\\Opera\\launcher.exe");
                return driver = new OperaDriver(operaOptions);
            case 'E':
                System.setProperty("webdriver.edge.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\drivers\\windows-drivers\\edgedriver-v16299.exe");
                return driver = new EdgeDriver();
            case 'I':
                System.setProperty("webdriver.ie.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\drivers\\windows-drivers\\iedriver-v3.8.0-win64.exe");
                return driver = new InternetExplorerDriver();
            default:
                System.out.println("available browsers: 'F' for Firefox, 'C' for Chrome, 'O' for Opera, 'E' for Edge, 'I' for Internet Explorer.");
                return driver = new HtmlUnitDriver();
        }
    }

    private WebDriver getMacDriver() {
        return driver = new SafariDriver();
    }

    @BeforeMethod
    public void beforeTest() {
        if (os.equals("linux")) {
            driver = getLinuxDriver('F');
        } else if (os.equals("windows")) {
            driver = getWindowsDriver('F');
        } else if (os.equals("mac")) {
            driver = getMacDriver();
        }
    }

    @Test
    public void test1() {

        driver.get("https://google.am");
        WebElement element = driver.findElement(By.id("lst-ib"));
//        WebElement element = driver.findElement(By.xpath("//input[@class='lst-ib']"));
        element.sendKeys("english setter");
        element.sendKeys(ENTER);
        driver.close();
//        driver.quit();
    }

    @Test
    public void test2() {
        driver.get("https://mailinator.com");
        WebElement inboxInput = driver.findElement(By.id("inboxfield"));
        inboxInput.sendKeys("durmm");
        inboxInput.sendKeys(ENTER);
        driver.close();
    }
}