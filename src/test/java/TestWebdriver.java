import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.Test;

/**
 * Created by durmm on 16/01/18.
 */
public class TestWebdriver {

    private WebDriver getLinuxDriver(char browser) {
        WebDriver driver;
        switch (browser) {
            case 'F':
                System.setProperty("webdriver.gecko.driver", "/var/www/webdrivers-test/linux drivers/geckodriver64linux");
                return driver = new FirefoxDriver();
            case 'C':
                System.setProperty("webdriver.chrome.driver", "/var/www/webdrivers-test/linux drivers/geckodriver64linux");
                return driver = new ChromeDriver();
            case 'O':
                System.setProperty("webdriver.opera.driver", "/var/www/webdrivers-test/linux drivers/operadriver64linux");
                OperaOptions options = new OperaOptions();
                options.setBinary("/usr/bin/opera");
                return driver = new OperaDriver(options);
            default:
                System.setProperty("webdriver.gecko.driver", "/var/www/webdrivers-test/linux drivers/geckodriver64linux");
                return driver = new FirefoxDriver();
        }
    }

    @Test
    public void linuxTest() {

    }

    @Test
    public void windowsTest() {

    }
}
