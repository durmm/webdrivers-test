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

public class TestWebdriver {
    private WebDriver driver;
    private String os = "windows";

    private WebDriver getLinuxDriver(char browser) {
        switch (browser) {
            case 'F':
                System.setProperty("webdriver.gecko.driver", "/var/www/webdrivers-test/linux-drivers/geckodriver64linux");
                return driver = new FirefoxDriver();
            case 'C':
                System.setProperty("webdriver.chrome.driver", "/var/www/webdrivers-test/linux-drivers/chromedriver64linux");
                return driver = new ChromeDriver();
            case 'O':
                System.setProperty("webdriver.opera.driver", "/var/www/webdrivers-test/linux-drivers/operadriver64linux");
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
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\windows-drivers\\geckodriver-v0.19.1-win64.exe");
                return driver = new FirefoxDriver();
            case 'C':
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\windows-drivers\\chromedriver-v2.35-win32.exe");
                return driver = new ChromeDriver();
            case 'O':
                System.setProperty("webdriver.opera.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\windows-drivers\\operadriver-v2.33-win64.exe");
                OperaOptions options = new OperaOptions();
                options.setBinary("C:\\Program Files (x86)\\Opera\\launcher.exe");
                return driver = new OperaDriver(options);
            case 'E':
                System.setProperty("webdriver.edge.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\windows-drivers\\edgedriver-v16299.exe");
                return driver = new EdgeDriver();
            case 'I':
                System.setProperty("webdriver.ie.driver", "C:\\Users\\Narine\\Documents\\Test Studio Projects\\webdrivers-test\\windows-drivers\\iedriver-v3.8.0-win64.exe");
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
        if (os.equals("linux")) {
            driver = getLinuxDriver('a');
        } else if (os.equals("windows")) {
            driver = getWindowsDriver('F');
        } else if (os.equals("mac")) {
            driver = getMacDriver();
        }
        driver.get("https://google.am");
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys("english setter");
        element.sendKeys(ENTER);
        Thread.sleep(5000);
        driver.close();
//        driver.quit();
    }
}
