package Brillius.library;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

import Utils.AppUtils;

public class Userpage extends AppUtils

{
	
    public boolean Adduser(String fname, String lname, String emailadd, String uname,String pword, String cnumber, String role) throws InterruptedException
    {
    	driver.findElement(By.xpath("//button[contains(text(),'User Registration')]")).click();
    	driver.findElement(By.id("firstname")).sendKeys(fname);
    	driver.findElement(By.id("lastname")).sendKeys(lname);
    	driver.findElement(By.id("email_address")).sendKeys(emailadd);
    	driver.findElement(By.id("username")).sendKeys(uname);
    	driver.findElement(By.id("password")).sendKeys(pword);
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//input[@id='contactnumber']")).getAttribute(cnumber);
   	      //driver.findElement(By.id("contactnumber")).sendKeys(cnumber);
    	
    	Select rolelist = new Select(driver.findElement(By.id("usertype")));
    	rolelist.selectByVisibleText(role);
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//button[contains(text(),'Back to Home')]")).click();
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//button[contains(text(),'Dashboard')]")).click();
    	
    	//Select sec = new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div/div[1]/select/option[12]")));
		 //List<WebElement> optios = sec.getOptions();
   	      //WebElement selectElement = driver.findElement(By.xpath("//option[contains(text(),'Select User')]"));
       // Select dropdown = new Select(selectElement);
        //dropdown.selectByVisibleText("Dravid");
		return true;
    	
        
    }
    public void isusersession() throws InterruptedException, IOException
    {
    	driver.findElement(By.xpath("//input[@id='audioSession']")).click();
    	//ChromeOptions Options = new ChromeOptions();
        //Options.addArguments("--use-fake-ui-for-media-stream");
        //Options.addArguments("--use-fake-device-for-media-stream");
    	driver.findElement(By.xpath("//input[@id='practiceSession']")).click();
    	driver.findElement(By.xpath("//button[contains(text(),'Start Session')]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//button[contains(text(),'Get Microphone')]")).click();
    	//Alert alert = driver.switchTo().alert();
    	//String alertMessage= driver.switchTo().alert().getText();
    	//System.out.println(alertMessage);
    	//Thread.sleep(2000);
    	//alert.accept();
    	//driver.findElement(By.xpath("//button[contains(text(),'Allow')]")).click();
    	
    	//Capture screenshots
        
    	driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//button[contains(text(),'Stop')]")).click();
    	Thread.sleep(2000);
    	
    	File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	Files.copy(f, new File("C:\\Users\\User\\Downloads\\Sample\\Brilliusscreenshot.jpg"));
    	
    	System.out.println(driver.findElement(By.xpath("//div[@id='questions']")).getText());
    	Thread.sleep(2000);
    	
    	System.out.println(driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[4]/center[1]/div[1]")).getText());
    	Thread.sleep(2000);
    	
    	System.out.println(driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/audio[1]")).getText());
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//button[contains(text(),'Get Feedback')]")).click();
    	Thread.sleep(2000);
    	
    	System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Encryption in transit refers to the process of enc')]")).getText());
    	Thread.sleep(2000);
    	
    	
    	driver.findElement(By.xpath("//button[contains(text(),'>>')]")).click();
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//button[contains(text(),'Stop')]")).click();
    	Thread.sleep(2000);
    	
    	File f2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	Files.copy(f2, new File("C:\\Users\\User\\Downloads\\Sample\\Brilliusscreenshot2.jpg"));
    	
    	System.out.println(driver.findElement(By.xpath("//div[@id='questions']")).getText());
    	Thread.sleep(2000);
    	
    	System.out.println(driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[4]/center[1]/div[1]")).getText());
    	Thread.sleep(2000);
    	
    	System.out.println(driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/audio[1]")).getText());
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//button[contains(text(),'Get Feedback')]")).click();
    	Thread.sleep(2000);
    	
        driver.findElement(By.xpath("//button[contains(text(),'Finish')]")).click();
    	Thread.sleep(2000);
    	
    	System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Docker is a containerization platform that allows ')]")).getText());
    	Thread.sleep(2000);
    	
    }
	
    

}
