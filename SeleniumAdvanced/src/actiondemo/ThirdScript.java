package actiondemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ThirdScript {

	static WebDriver driver;
	static WebElement element;

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.ie.driver","C:/kashyap/IEDriverServer.exe/");
		System.setProperty("webdriver.chrome.driver", "C:/kashyap/chromedriver.exe/");
		//driver = new InternetExplorerDriver();
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		element=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"));
		//element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a)"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
		Thread.sleep(2000);

		element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[2]/a"));
		actions.moveToElement(element).click().build().perform();
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Notebooks");
		System.out.println(" Test Passed ");
		driver.close();
	}

}
