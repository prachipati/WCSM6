package testPackage;

import java.io.IOException;

import generic.BaseTest;
import generic.Flib;
import pagePackage.LoginPage;



public class TestActiTimeInvalidLogin extends BaseTest{

	public static void main(String[] args) throws IOException, InterruptedException {
		BaseTest bt = new BaseTest();
		bt.openBrowser();
		LoginPage lp = new LoginPage(driver);
		Flib flib = new Flib();
		
		int rc = flib.getRowCount("./data/Test Data2.xlsx", "Invalid Creds");
		
		for(int i=1;i<rc;i++)
		{
			String invalidUsername = flib.readExcelData("./data/Test Data2.xlsx", "Invalid Creds", i, 0);
			String invalidPassword = flib.readExcelData("./data/Test Data2.xlsx", "Invalid Creds", i, 1);
			
			lp.InvalidLogin(invalidUsername, invalidPassword);
		}
		
		bt.closeBrowser();
	}

}
