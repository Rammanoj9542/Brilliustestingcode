package Brillius.library;

import org.openqa.selenium.By;

import Utils.AppUtils;

public class Loginpage extends AppUtils

{

	public void login(String uid,String pwd)
	{
		driver.findElement(By.id("username")).sendKeys(uid);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
	}
	
	public boolean isAdminmoduledisplayed()
	{
		if(driver.findElement(By.xpath("//button[text()='User Registration']")).isDisplayed())
				{
			      return true;
				}else
				{
					return false;
				}
	}
	    
		public boolean Logout()
		{   
			driver.findElement(By.xpath("//button[text()='Logout']")).click();
			if(driver.findElement(By.xpath("//button[text()='Login']")).isDisplayed())
			{
				return true;
			}else
			{
				return false;
			}
			
		}
		public boolean isErrMsgDisplayed()
		{
			
			String errmsg;
			errmsg = driver.findElement(By.id("failFlashMsg")).getText();
			if(errmsg.contains("Invalid"))
			{
				return true;
			}else
			{
				return false;
			}		
		}
	    public boolean isusermoduledispalyed()
	    {
	 	    	if(driver.findElement(By.xpath("//button[contains(text(),'Start Session')]")).isDisplayed())
	 	    	{
	 	    		return true;
	 	    	}else
	 	    		{
	 	    			return false;
	 	    		}
	 	}
	    public boolean userLogout()
		{
			//driver.findElement(By.xpath("//button[contains(text(),'Menu')]")).click();
			//driver.findElement(By.xpath("//li[contains(text(),'Logout')]")).click();
			driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/button[1]/div[2]")).click();
			driver.findElement(By.xpath("//li[contains(text(),'Logout')]")).click();
			if(driver.findElement(By.xpath("//button[text()='Login']")).isDisplayed())
			{
				return true;
			}else
			{
				return false;
			}
			
		}
	    public boolean isErrorMsgDisplayed()
	    {
	    	String errmsg;
	    	errmsg = driver.findElement(By.id("failFlashMsg")).getText();
	    	if(errmsg.contains("Invalid login credentials. Please try again."))
	    	{
	    		return true;
	    	}else
	    	{
	    		return false;
	    	}
	    	
	    } 
	  

}
