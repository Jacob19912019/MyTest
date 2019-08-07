import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSelenium {
    private WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        System.out.println("调用BeforeMethod方法");
        System.setProperty("webdriver.firefox.bin","D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        // System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void Testc() throws InterruptedException {

        driver.get("http://www.baidu.com/");
        System.out.println(driver.getTitle());
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(8000);
        String expect = driver.getTitle();
        Assert.assertEquals("selenium_百度搜索",expect);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        System.out.println("修改调用AfterMethod方法");
        }
}
