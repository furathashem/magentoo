package project4;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.NavigableMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class MyFourthTest {
	WebDriver driver = new ChromeDriver();
	String MyWebSite = "https://magento.softwaretestingboard.com/";
	Random rand = new Random();
	String password = "i-1LuvMyMum";
	String logoutpage = "https://magento.softwaretestingboard.com/customer/account/logout/\" ";
	String loginmnew = "";

	@BeforeTest
	public void Mysetup() {
		driver.manage().window().maximize();
		driver.get(MyWebSite);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Test(priority = 1,enabled = false)
	public void CreatAnAccount() {
		// xpath
		// WebElement
		// createAccount=driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"));
//creatAccount.click();
//PartialLinkText
//WebElement createAccount=driver.findElement(By.partialLinkText("Create"));
//createAccount.click();
//LinkText
		// WebElement createAccount = driver.findElement(By.linkText("Create an
		// Account"));
		// createAccount.click();
		WebElement createAccount = driver
				.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)"));
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
		loginmnew = firstname + lastname + randint + emailadressinput;
		passwordinput.sendKeys(password);
		confirmpass.sendKeys(password);
		creataccountbutton.click();
		WebElement MessagesAsWebElement = driver.findElement(By.className("messages"));
		String TheActualMessages = MessagesAsWebElement.getText();
		String ExepectedMessages = "Thank you for registering with Main Website Store.";
		Assert.assertEquals(TheActualMessages, ExepectedMessages);
	}

	@Test(priority = 2,enabled = false)
	public void logout() {
		driver.get(logoutpage);
		WebElement logoutMessages = driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']"));
		String actualms = logoutMessages.getText();
		String expectedms = "You are signed out";
		Assert.assertEquals(actualms, expectedms);
	}

	@Test(priority = 3,enabled = false)
	public void loginpage() {
		WebElement loginpagee = driver.findElement(By.linkText("Sign In"));
		loginpagee.click();
		WebElement emaillogin = driver.findElement(By.id("email"));
		emaillogin.sendKeys(loginmnew);
		WebElement passwordinput = driver.findElement(By.id("pass"));
		passwordinput.sendKeys(password);
		WebElement loginButton = driver.findElement(By.cssSelector(".action.login.primary"));
		loginButton.click();
		String welcomeMessage = driver.findElement(By.className("logged-in")).getText();
		boolean actualms = welcomeMessage.contains("Welcome");
		boolean expectedms = true;
		Assert.assertEquals(actualms, expectedms);
	}

	@Test(priority = 4,enabled = false)
	public void addMenItem() {
		WebElement MenSection = driver.findElement(By.id("ui-id-5"));
		MenSection.click();
		// System.out.println(driver.findElements(By.className("product-item")).size());
		WebElement productITemsContainer = driver.findElement(By.className("product-items"));
//System.out.println(productITemsContainer.findElements(By.tagName("li")).size());//4	( هون انا بحكي لل برودكت ايتيم كونتينر ابحثيلي فقط بداخلك على تاق الي اسمو li)
//System.out.println(driver.findElements(By.tagName("li")).size());//(هون انا بحكي للدرايفير ابحثلي عن تاق بكل الصفحة )58
		List<WebElement> AllItems = productITemsContainer.findElements(By.tagName("li"));
		int totalNumberOfItems = AllItems.size();
		int randomItem = rand.nextInt(totalNumberOfItems);
		AllItems.get(randomItem).click();
		WebElement theContainerOfTheSize = driver.findElement(By.cssSelector(".swatch-attribute-options.clearfix"));
		List<WebElement> ListOfSizes = theContainerOfTheSize.findElements(By.className("swatch-option"));
		int numberOfSizes = ListOfSizes.size();
		int randomSize = rand.nextInt(numberOfSizes);
		ListOfSizes.get(randomSize).click();
		WebElement theContainerOfColor = driver
				.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
		List<WebElement> ListOfColor = theContainerOfColor.findElements(By.tagName("div"));
		int numberofcolor = ListOfColor.size();
		int randomColor = rand.nextInt(numberofcolor);
		ListOfColor.get(randomColor).click();
		WebElement AddToCartButton = driver.findElement(By.id("product-addtocart-button"));
		AddToCartButton.click();
		WebElement MessageAdded = driver.findElement(By.className("message-success"));
		System.out.println(MessageAdded.getText().contains("You added"));
		Assert.assertEquals(MessageAdded.getText().contains("You added"), true);

//		for(int i=0;i<Items.size();i++); هاد الحكي غلط لانو انا ما بدي اضيف كل العناصر انا بدي اختار واضيف عنصر عشوائي
//		{
		// items.get(i).click();
//			Items.get(rand.nextInt(Items.size())).click(); 
//		}
//		System.out.println(Items.size());
//	Items.get(0).click();

//	driver.navigate().back();
//	driver.navigate().refresh();
//	Thread.sleep(8000);
//	Items.get(1).click();

	}
	@Test(priority = 5)
	public void addWomentem() throws InterruptedException 
	{
		WebElement womenSection=driver.findElement(By.id("ui-id-4"));
		womenSection.click();
		WebElement productsItemContainer=driver.findElement(By.className("product-items"));
		List<WebElement> allItems=productsItemContainer.findElements(By.tagName("li"));
		int totalNUM=allItems.size();
		int random=rand.nextInt(totalNUM);
		allItems.get(random).click();
		WebElement sizeSection=driver.findElement(By.className("swatch-attribute-options"));
		List<WebElement> listOfSize=sizeSection.findElements(By.tagName("div"));
		int numOfSize=listOfSize.size();
		int randomSize=rand.nextInt(numOfSize);
		listOfSize.get(randomSize).click();
		WebElement colorSection=driver.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
		List<WebElement> listOfColor=colorSection.findElements(By.tagName("div"));
		int numOfColor=listOfColor.size();
		int randomColor=rand.nextInt(numOfColor);
		listOfColor.get(randomColor).click();
		WebElement AddToCartButton = driver.findElement(By.id("product-addtocart-button"));
		AddToCartButton.click();
		Thread.sleep(5000);
		WebElement MessageAdded = driver.findElement(By.cssSelector(".message-success.success.message"));
		System.out.println(MessageAdded.getText().contains("You added"));
		Assert.assertEquals(MessageAdded.getText().contains("You added"), true);
		//reveiw Section
	WebElement reviewSection=driver.findElement(By.id("tab-label-reviews-title"));
			reviewSection.click();
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,1200)");
			Thread.sleep(2000);
	WebElement RatingStars=driver.findElement(By.cssSelector(".control.review-control-vote"));
	Thread.sleep(2000);
	
	System.out.println(RatingStars.findElements(By.tagName("label")).size()+"*********************");
	String[] ids= {"Rating_1","Rating_2","Rating_3","Rating_4","Rating_5"};
	int randomID=rand.nextInt(ids.length);
WebElement element=driver.findElement(By.id(ids[randomID]));
((JavascriptExecutor) driver).executeScript("arguments[0].click()",element);
//	RatingStars.findElements(By.tagName("label")).get(2).click();
	WebElement nickName=driver.findElement(By.id("nickname_field"));
			nickName.sendKeys("soso");
		WebElement summary=driver.findElement(By.id("summary_field"));
		summary.sendKeys("na");
		WebElement review=driver.findElement(By.id("review_field"));
		review.sendKeys("hello this is a test");
		WebElement subimtreviewbutton=driver.findElement(By.cssSelector(".action.submit.primary"));
		subimtreviewbutton.click();
	String actualText=	driver.findElement(By.cssSelector("message-success.success.message")).getText();
	String expectedText="You submitted your review for moderation.";
	Assert.assertEquals(actualText, expectedText);
		
		
		
	}

}
