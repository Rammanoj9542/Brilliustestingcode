package Brillius.Testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Brillius.library.Loginpage;
import Brillius.library.Userpage;
import Utils.AppUtils;
import Utils.XLUtils;

public class BrilliusTestSuite extends AppUtils
{
	String tcfile ="C:\\Selenium testing\\Brillius_Pvtltd_Hybrid\\testdatafiles\\Brillius Testcases_Hybrid.xlsx";
    String tcsheet ="Testcases";
    String tssheet ="Teststeps";
    @Test
	public void checkBrilliusPvtLtd() throws IOException, InterruptedException
	{
    	String tcexflag , tcid, tstcid, keyword, stepres, tcres;
    	String uid = null,pwd = null;
    	String fname, lname, emailadd, uname, pword, cnumber, role,server;
    	Loginpage lp = new Loginpage();
    	Userpage up = new Userpage();
    	boolean res = false;
		int tccount = XLUtils.getrowCount(tcfile, tcsheet);
		int tscount = XLUtils.getrowCount(tcfile, tssheet);
		
		for(int i=1;i<=tccount;i++)
		{
			tcexflag = XLUtils.getstringdata(tcfile, tcsheet, i, 2);
			if(tcexflag.contains("y"))
			{
				tcid = XLUtils.getstringdata(tcfile, tcsheet, i, 0);
				for(int j=1;j<=tscount;j++)
				{
					tstcid = XLUtils.getstringdata(tcfile, tssheet, j, 0);
					if(tstcid.equalsIgnoreCase(tcid))
					{
						keyword = XLUtils.getstringdata(tcfile, tssheet, j, 4);
						switch (keyword) 
						{
						 case "Adminlogin":
							server = XLUtils.getstringdata(tcfile, tssheet, j, 5);
							uid = XLUtils.getstringdata(tcfile, tssheet, j, 6);
							pwd = XLUtils.getstringdata(tcfile, tssheet, j, 7);
							driver.get(server);
							 lp.login(uid, pwd);
							 res = lp.isAdminmoduledisplayed();
							 break;
						 case"Logout":
							 lp.Logout();
							 break;
						 case"Invalid Login":
							 server = XLUtils.getstringdata(tcfile, tssheet, j, 5);
							 uid = XLUtils.getstringdata(tcfile, tssheet, j, 6);
							 pwd = XLUtils.getstringdata(tcfile, tssheet, j, 7);
							 driver.get(server);
							 lp.login(uid, pwd);
							 res = lp.isErrMsgDisplayed();
							 break;	 
						 case"UserReg":
							 server = XLUtils.getstringdata(tcfile, tssheet, j, 5);
							 fname = XLUtils.getstringdata(tcfile, tssheet, j, 6);
							 lname = XLUtils.getstringdata(tcfile, tssheet, j, 7);
							 emailadd = XLUtils.getstringdata(tcfile, tssheet, j, 8);
							 uname = XLUtils.getstringdata(tcfile, tssheet, j, 9);
							 pword = XLUtils.getstringdata(tcfile, tssheet, j, 10);
							 cnumber = XLUtils.getstringdata(tcfile, tssheet, j, 11);
							 role = XLUtils.getstringdata(tcfile, tssheet, j, 12);
							 driver.get(server);
							 lp.login(uid, pwd);
							 res = up.Adduser(fname, lname, emailadd, uname, pword, cnumber, role);
							 res = lp.Logout();
							 break; 
						 case "Userlogin":
							    server = XLUtils.getstringdata(tcfile, tssheet, j, 5);
								uid = XLUtils.getstringdata(tcfile, tssheet, j, 6);
								pwd = XLUtils.getstringdata(tcfile, tssheet, j, 7);
								driver.get(server);
								lp.login(uid, pwd);
								up.isusersession();
								res = lp.isusermoduledispalyed();
								 break;
						  case"UserLogout":
							 lp.userLogout();
								 
						}	
				
						
						//code to update step Result
						if(res)
						{
							stepres = "Pass";
							XLUtils.setcelldata(tcfile, tssheet, j, 3, stepres);
							XLUtils.fillgreencolor(tcfile, tssheet, j, 3);
						}else
						{
							stepres = "Failed";
							XLUtils.setcelldata(tcfile, tssheet, j, 3, stepres);
							XLUtils.fillredcolor(tcfile, tssheet, j, 3);
						}
						
						//code to update Test case Result
						
						tcres = XLUtils.getstringdata(tcfile, tcsheet, i, 3);
						if(!tcres.contains("Failed"))
						{
							XLUtils.setcelldata(tcfile, tcsheet, i, 3, stepres);
						}
						
						//code to fill colours
						
						 tcres = XLUtils.getstringdata(tcfile, tcsheet, i, 3);
						 if(tcres.contains("Pass"))
						 {
							 XLUtils.fillgreencolor(tcfile, tcsheet, i, 3);
						 }else
						 {
							 XLUtils.fillredcolor(tcfile, tcsheet, i, 3);
						 }
					  
					}
				
				}
				
			}else
			{
				XLUtils.setcelldata(tcfile, tcsheet, i, 3, "Blocked");
				XLUtils.fillredcolor(tcfile, tcsheet, i, 3);
			}
		}
		
	}
	
}
