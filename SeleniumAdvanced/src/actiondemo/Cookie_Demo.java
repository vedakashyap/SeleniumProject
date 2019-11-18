package actiondemo;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookie_Demo {
	static WebDriver driver;
	public static void main(String[] args) {
		 
		System.setProperty("webdriver.chrome.driver", "C:/kashyap/chromedriver.exe/");	
		driver = new ChromeDriver();
		driver.get("http://www.rediff.com/");
		driver.manage().window().maximize();
		
		Cookie TestCookie1 = new Cookie("Username", "TestUser");
		driver.manage().addCookie(TestCookie1);
		Cookie TestCookie2 = new Cookie("Password", "TestPassword");
		driver.manage().addCookie(TestCookie2);
		
		Set<Cookie> ck = driver.manage().getCookies();
		for(Cookie c:ck) {
			System.out.println("Name "+c.getName());
			System.out.println("Value "+c.getValue());
			System.out.println("Domain "+c.getDomain());
			System.out.println("Path "+c.getPath());
			System.out.println("Expiry "+c.getExpiry());
			System.out.println(" ");
			
		}
	}

}
