package seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DemoGridExample {

	static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(BrowserType.CHROME);
		dc.setPlatform(Platform.ANY);
		URL link =new URL("http://192.168.138.1:3456/wd/hub");
	    
		driver = new RemoteWebDriver(link,dc);

		driver.get("http://demowebshop.tricentis.com");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Log in")).click();
        Thread.sleep(500);
        driver.findElement(By.id("Email")).sendKeys("TestUser_SQ@mail.test");
        driver.findElement(By.id("Password")).sendKeys("Test_Password");
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Log out")).click();
        Thread.sleep(1000);
        driver.close();
	}

}
