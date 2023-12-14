package Brillius.library;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utils.AppUtils;

public class AdminUtils extends AppUtils

{
	
	Loginpage lp;
	
    @BeforeTest
	public void AdminLogin(String adminuid, String adminpwd)
	
	{
    	lp = new Loginpage();
		lp.login(adminuid, adminpwd);
		
	}
    
    @AfterTest
    public void AdminLogout()
    {
    	lp.Logout();
    }
	
	
}
