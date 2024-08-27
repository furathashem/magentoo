package project4;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFourthTest {
	WebDriver driver = new ChromeDriver();
	String MyWebSite = "https://magento.softwaretestingboard.com/";
	Random rand = new Random();
	String password = "i-1LuvMyMum";
	String logoutpage= "https://magento.softwaretestingboard.com/customer/account/logout/\" ";
	String loginmnew="";

	@BeforeTest
	public void Mysetup() {
		driver.manage().window().maximize();
		driver.get(MyWebSite);

	}

	@Test(priority = 1)
	public void CreatAnAccount() {
		// xpath
		// WebElement
		// createAccount=driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"));
//creatAccount.click();
//PartialLinkText
//WebElement createAccount=driver.findElement(By.partialLinkText("Create"));
//createAccount.click();
//LinkText
		WebElement createAccount = driver.findElement(By.linkText("Create an Account"));
		createAccount.click();
		// WebElement firstnameetest=driver.findElement(By.id("firstname")).sendKeys(
		// FirstName[TheIndexForFirstName]);
		String[] First_Namearray = { "ahmad", "mohammed", "salem", "leen", "sara", "rami", "mahmoud", "dana", "furat",
				"feras" };
		String[] Last_Namearray = { "john", "lama", "saja", "aya", "anfal", "deema", "reem", "hashem", "sara", "ola" };
		int TheIndexForFirstName = rand.nextInt(First_Namearray.length);
		int TheIndexForLastName = rand.nextInt(Last_Namearray.length);

		System.out.println(TheIndexForFirstName);
		System.out.println(TheIndexForLastName);
		WebElement emailadress = driver.findElement(By.id("email_address"));
		WebElement firstnametest = driver.findElement(By.id("firstname"));
		WebElement lastnametest = driver.findElement(By.id("lastname"));
		WebElement passwordinput = driver.findElement(By.id("password"));
		WebElement confirmpass = driver.findElement(By.id("password-confirmation"));
		WebElement creataccountbutton = driver.findElement(By.xpath("//button[@title='Create an Account']"));
		String firstname = First_Namearray[TheIndexForFirstName];
		String lastname = Last_Namearray[TheIndexForLastName];
		String emailadressinput = "@gmail.com";
		int randint = rand.nextInt(3657);

		firstnametest.sendKeys(firstname);
		lastnametest.sendKeys(lastname);
		emailadress.sendKeys(firstname + lastname + randint + emailadressinput);
		 loginmnew=firstname + lastname + randint + emailadressinput;
		passwordinput.sendKeys(password);
		confirmpass.sendKeys(password);
		creataccountbutton.click();

	}
	@Test(priority = 2)
	public void logout() {
		driver.get(logoutpage);
		
		
	}
	@Test(priority = 3)
	public void loginpage()
	{
		WebElement loginpagee=driver.findElement(By.linkText("Sign In"));
		loginpagee.click();
		WebElement emaillogin=driver.findElement(By.id("email"));
		emaillogin.sendKeys(loginmnew);
		WebElement passwordinput=driver.findElement(By.id("pass"));
		passwordinput.sendKeys(password);
		WebElement loginButton=driver.findElement(By.cssSelector(".action.login.primary"));
		loginButton.click();
	}

}
