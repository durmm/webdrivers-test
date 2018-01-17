import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;

/**
 * Created by durmm on 16/01/18.
 */
public class TestWebdriver {
    private WebDriver driver;
    private String os = "linux";

    private WebDriver getLinuxDriver(char browser) {
        switch (browser) {
            case 'F':
                System.setProperty("webdriver.gecko.driver", "/var/www/webdrivers-test/linux drivers/geckodriver64linux");
                return driver = new FirefoxDriver();
            case 'C':
                System.setProperty("webdriver.chrome.driver", "/var/www/webdrivers-test/linux drivers/chromedriver64linux");
                return driver = new ChromeDriver();
            case 'O':
                System.setProperty("webdriver.opera.driver", "/var/www/webdrivers-test/linux drivers/operadriver64linux");
                OperaOptions options = new OperaOptions();
                options.setBinary("/usr/bin/opera");
                return driver = new OperaDriver(options);
            default:
                System.out.println("available browsers: 'F' for Firefox, 'C' for Chrome, 'O' for Opera.");
                return driver = new HtmlUnitDriver();
        }
    }

    private WebDriver getWindowsDriver(char browser) {
        switch (browser) {
            case 'F':
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\windows drivers\\geckodriver64.exe");
                return driver = new FirefoxDriver();
            case 'C':
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\windows drivers\\chromedriver.exe");
                return driver = new ChromeDriver();
            case 'O':
                System.setProperty("webdriver.opera.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\windows drivers\\operadriver64.exe");
                OperaOptions options = new OperaOptions();
                options.setBinary("C:\\Program Files (x86)\\Opera\\launcher.exe");
                return driver = new OperaDriver(options);
            case 'E':
                System.setProperty("webdriver.edge.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\windows drivers\\edgedriver.exe");
                return driver = new EdgeDriver();
            case 'I':
                System.setProperty("webdriver.ie.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\windows drivers\\iedriver.exe");
                return driver = new InternetExplorerDriver();
            default:
                System.out.println("available browsers: 'F' for Firefox, 'C' for Chrome, 'O' for Opera, 'E' for Edge, 'I' for Internet Explorer.");
                return driver = new HtmlUnitDriver();
        }
    }

    private WebDriver getMacDriver() {
        return driver = new SafariDriver();
    }

    @Test
    public void test() throws InterruptedException {
        if (os == "linux") {
            driver = getLinuxDriver('C');
        } if (os == "windows") {
            driver = getWindowsDriver('O');
        } if (os == "mac") {
            driver = getMacDriver();
        }
        driver.get("https://google.am");
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys("english setter");
        element.sendKeys(ENTER);
        Thread.sleep(5000);
        driver.close();
//        driver.quit();
    }

    @Test
    public void systemPropertiesTest() {
        System.out.println(System.getProperty("user.home"));
    }
}
