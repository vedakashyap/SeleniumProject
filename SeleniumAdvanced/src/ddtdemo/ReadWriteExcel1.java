package ddtdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class ReadWriteExcel1 {

	static WebDriver driver;
	static FileInputStream FRead;
	static FileOutputStream FWrite;
	static  XSSFWorkbook wb,wb1;
	static  XSSFSheet sh;
	
	public static void main(String[] args) throws InvalidFormatException, IOException, InterruptedException {

		String d1,d2;
		String login,pwd,wbmsg,xlmsg;
		int rowval,rowcount;
		String pass = "Test is Pass";
		String fail = "Test is Failed";
		
		System.setProperty("webdriver.chrome.driver", "C:/kashyap/chromedriver.exe/");	
		driver = new ChromeDriver();
		FRead = new FileInputStream("C:\\kashyap\\demoworkshop.xlsx");
		
		wb = new XSSFWorkbook(FRead);
		sh = wb.getSheetAt(0);
		d1 = sh.getRow(0).getCell(0).getStringCellValue();
        d2 = sh.getRow(0).getCell(1).getStringCellValue();
        rowcount = sh.getPhysicalNumberOfRows();
        
        for(rowval = 1; rowval < rowcount;rowval++) {

    		login = sh.getRow(rowval).getCell(0).getStringCellValue();
    		pwd = sh.getRow(rowval).getCell(1).getStringCellValue();
    		xlmsg = sh.getRow(rowval).getCell(2).getStringCellValue();
    		driver.get("http://demowebshop.tricentis.com");
            Thread.sleep(2000);
            driver.findElement(By.linkText("Log in")).click();
            Thread.sleep(500);
            driver.findElement(By.id("Email")).sendKeys(login);
            driver.findElement(By.id("Password")).sendKeys(pwd);
            driver.findElement(By.cssSelector("input[value='Log in']")).click();
            Thread.sleep(1000);
            wbmsg = driver.findElement(By.cssSelector("a.account")).getText();
            driver.findElement(By.linkText("Log out")).click();
            Thread.sleep(1000);
            FWrite = new FileOutputStream("C:\\kashyap\\demoworkshop.xlsx");
            sh.getRow(rowval).createCell(3).setCellValue(wbmsg);
            if(wbmsg.equals(xlmsg)) {
            	System.out.println(wbmsg);
        		System.out.println(d1);
                System.out.println(d2);
                System.out.println(login);
                System.out.println(pwd);
            	System.out.println("Test Pass");
                sh.getRow(rowval).createCell(4).setCellValue(pass);
            }
            else {
            	System.out.println("Test Fail");
            	sh.getRow(rowval).createCell(4).setCellValue(fail);
            }
          
            wb.write(FWrite);
            
        }
        
        wb.close();
        driver.close();
	}

}
