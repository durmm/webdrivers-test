import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.Test;

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
                System.out.println("currently available: F for Firefox, C for Chrome, O for Opera.");
                return null;
        }
    }

    private WebDriver getWindowsDriver(char browser) {
        switch (browser) {
            case 'F':
                System.setProperty("webdriver.gecko.driver", "/var/www/webdrivers-test/windows drivers/geckodriver64.exe");
                return driver = new FirefoxDriver();
            case 'C':
                System.setProperty("webdriver.chrome.driver", "/var/www/webdrivers-test/windows drivers/chromedriver.exe");
                return driver = new ChromeDriver();
            case 'O':
                System.setProperty("webdriver.opera.driver", "/var/www/webdrivers-test/windows drivers/operadriver64.exe");
                OperaOptions options = new OperaOptions();
                options.setBinary("/usr/bin/opera"); //to be changed to windows directory
                return driver = new OperaDriver(options);
            case 'E':
                System.setProperty("webdriver.edge.driver", "/var/www/webdrivers-test/windows drivers/edgedriver.exe");
                return driver = new EdgeDriver();
            case 'I':
                System.setProperty("webdriver.ie.driver", "/var/www/webdrivers-test/windows drivers/iedriver.exe");
                return driver = new InternetExplorerDriver();
            default:
                System.out.println("currently available: F for Firefox, C for Chrome, O for Opera, E for Edge, I for Internet Explorer.");
                return null;
        }
    }

    @Test
    public void test() {
        if (os == "linux") {
            WebDriver driver = getLinuxDriver('F');
        } if (os == "windows") {
            WebDriver driver = getWindowsDriver('F');
        }
        driver.get("https://google.am");
        driver.close();
        driver.quit();
    }
}
