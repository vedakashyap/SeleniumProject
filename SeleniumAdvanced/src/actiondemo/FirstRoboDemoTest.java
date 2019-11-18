package actiondemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class FirstRoboDemoTest {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		//System.setProperty("webdriver.ie.driver","C:/kashyap/IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "C:/kashyap/chromedriver.exe/");
		driver = new ChromeDriver();
		driver.get("https://postimages.org");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("C:\\temp\\Demo.png"));
		Thread.sleep(2000);
		driver.findElement(By.id("uploadFile")).click();
		
		StringSelection copy = new StringSelection("C:\\temp\\Demo.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(copy, null);
		Thread.sleep(2000);
		
		Robot robo = new Robot();
		
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.setAutoDelay(1000);
		
		robo.keyPress(KeyEvent.VK_V);
		robo.setAutoDelay(1000);
		
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.setAutoDelay(1000);
		
		robo.keyRelease(KeyEvent.VK_V);
		robo.setAutoDelay(1000);

		robo.keyPress(KeyEvent.VK_ENTER);
		robo.setAutoDelay(1000);
		
		driver.close();
	}

}
