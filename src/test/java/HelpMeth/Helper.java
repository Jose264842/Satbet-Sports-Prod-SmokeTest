package HelpMeth;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Helper 
{
	public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;
    
    
    public static void start() 
    {
    	extent = new ExtentReports("REPORTS\\Satbet Prod Sports Smoke Test Report.html", true);
    }
    
    public static void end()
    {
    	extent.endTest(test);
    	extent.flush();
    }
	
    @SuppressWarnings("deprecation")
	public static void BrowserLaunch() 
    {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	driver = new ChromeDriver(options);
    	System.out.println("Browser is launched !");
    	driver.manage().window().maximize();
    	driver.get("https://www.satbet.com/");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//a[@id='loginbutton']")).click();
    	driver.findElement(By.xpath("(//input[@name='username'])[2]")).sendKeys("sliveuser10");
    	driver.findElement(By.xpath("//input[@id='user-password']")).sendKeys("Test@123");
    	driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
    }

    public static void BrowserClose() throws InterruptedException 
    {
    	Thread.sleep(5000);
        driver.close();
    }
    
    public static String takeSnap() throws WebDriverException, IOException 
    {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; // Snapshort for unique Name
		String destination = "D:\\Digient Automation\\Satbet Prod Sports BDD\\Screenshot\\" + number + ".jpg";
		TakesScreenshot ts = (TakesScreenshot)driver; 
	    File source = ts.getScreenshotAs(OutputType.FILE); 
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
    
    public static void robot() throws Throwable 
    {
    	 Robot robot = new Robot(); 
    	 robot.delay(1000); robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER); robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_ENTER);
		 robot.delay(1000); robot.keyRelease(KeyEvent.VK_ENTER);
    }
    
    public static void oddsSingleBet() throws Throwable
    {
    	boolean odds1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[3]")).isEnabled();
        boolean odds2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]")).isEnabled();
        boolean odds3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[7]")).isEnabled();
        boolean odds4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[8]")).isEnabled();
        boolean odds5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[11]")).isEnabled();
        boolean odds6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]")).isEnabled();
    	
        try {
        if(odds1 == true)
        {
        	if(checkElement(driver, "(//*[@class = 'team-button'])[3]"))
        	{
                WebElement o1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[3]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o1);
                System.out.println("Clicked on Bet placing Button 1(1) !");
        	}
        }
        else if(odds2 == true  && odds1!= true)
        {
        	if(checkElement(driver, "(//*[@class = 'team-button'])[4]"))
        	{
            	WebElement o2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]"));
            	((JavascriptExecutor) driver).executeScript("arguments[0].click();", o2);
                System.out.println("Clicked on Bet placing Button 1(2) !");
        	}
        }
        else if(odds3 == true)
        {
        	if(checkElement(driver, "(//*[@class = 'team-button'])[7]"))
        	{
                WebElement o3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[7]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o3);
                System.out.println("Clicked on Bet placing Button 2(1) !");
        	}
        }
        else if(odds4 == true && odds5 != true)
        {
        	if(checkElement(driver, "(//*[@class = 'team-button'])[8]"))
        	{
                WebElement o4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[8]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o4);
                System.out.println("Clicked on Bet placing Button 2(2) !");
        	}
        }
        else if(odds5 == true)
        {
        	if(checkElement(driver, "(//*[@class = 'team-button'])[11]"))
        	{
                WebElement o5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[11]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o5);
                System.out.println("Clicked on Bet placing Button 3(1) !");
        	}
        }
        else if(odds6 == true && odds5 != true)
        {
        	if(checkElement(driver, "(//*[@class = 'team-button'])[12]"))
        	{
                WebElement o6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o6);
                System.out.println("Clicked on Bet placing Button 3(2) !");
        	}
        } 
        }
        catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
    }
    
    public static void oddsMultiBet() throws Throwable
    {
    	boolean odds1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[3]")).isEnabled();
        boolean odds2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]")).isEnabled();
        boolean odds3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[7]")).isEnabled();
        boolean odds4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[8]")).isEnabled();
        boolean odds5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[11]")).isEnabled();
        boolean odds6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]")).isEnabled();
        try {
    	if(odds1 == true || odds2 == true || odds3 == true || odds4 == true || odds5 == true || odds6 == true) 
    	{
        if(checkElement(driver, "(//*[@class = 'team-button'])[3]"))
    	{
            WebElement o1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[3]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o1);
            System.out.println("Clicked on Bet placing Button 1(1) !");
    	}
        if(checkElement(driver, "(//*[@class = 'team-button'])[4]"))
    	{
        	WebElement o2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]"));
        	((JavascriptExecutor) driver).executeScript("arguments[0].click();", o2);
            System.out.println("Clicked on Bet placing Button 1(2) !");
    	}
    	if(checkElement(driver, "(//*[@class = 'team-button'])[7]"))
    	{
            WebElement o3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[7]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o3);
            System.out.println("Clicked on Bet placing Button 2(1) !");
    	}
    	if(checkElement(driver, "(//*[@class = 'team-button'])[8]"))
    	{
            WebElement o4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[8]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o4);
            System.out.println("Clicked on Bet placing Button 2(2) !");
    	}
    	if(checkElement(driver, "(//*[@class = 'team-button'])[11]"))
    	{
            WebElement o5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[11]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o5);
            System.out.println("Clicked on Bet placing Button 3(1) !");
    	}
    	if(checkElement(driver, "(//*[@class = 'team-button'])[12]"))
    	{
            WebElement o6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o6);
            System.out.println("Clicked on Bet placing Button 3(2) !");
    	}
    	}
    }
    catch(Exception e)
	{
		test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		e.printStackTrace();
		Assert.assertFalse(true);
	}
    }
    
    public static void oddsSingleBetTennisCout() throws Throwable
    {
    	boolean odds1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[3]")).isEnabled();
        boolean odds2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]")).isEnabled();
        boolean odds3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[7]")).isEnabled();
        boolean odds4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[8]")).isEnabled();
        boolean odds5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[11]")).isEnabled();
        boolean odds6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]")).isEnabled();
        boolean cout = driver.findElement(By.xpath("//div[@class='cashout_desktopImg']")).isDisplayed();
        //boolean market1 = driver.findElement(By.xpath("//div[@class= 'matchDesk_desc']//div[text()= ' INTERRUPTED ']")).isDisplayed();
		//boolean market2 = driver.findElement(By.xpath("//div[@class= 'matchDesk_desc']//div[text()= ' SUSPENDED ']")).isDisplayed();
		
		try 
		{
	        if((odds1 == true && cout == true))
	        {
	        	if(checkElement(driver, "(//*[@class = 'team-button'])[3]"))
	        	{
	                WebElement o1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[3]"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o1);
	                System.out.println("Clicked on Bet placing Button 1(1) !");
	        	}
	        }
	        else if(odds2 == true && odds1!= true && cout== true)
	        {
	        	if(checkElement(driver, "(//*[@class = 'team-button'])[4]"))
	        	{
	            	WebElement o2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]"));
	            	((JavascriptExecutor) driver).executeScript("arguments[0].click();", o2);
	                System.out.println("Clicked on Bet placing Button 1(2) !");
	        	}
	        }
	        else if(odds3 == true && cout== true)
	        {
	        	if(checkElement(driver, "(//*[@class = 'team-button'])[7]"))
	        	{
	                WebElement o3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[7]"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o3);
	                System.out.println("Clicked on Bet placing Button 2(1) !");
	        	}
	        }
	        else if(odds4 == true && odds3 != true && cout== true)
	        {
	        	if(checkElement(driver, "(//*[@class = 'team-button'])[8]"))
	        	{
	                WebElement o4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[8]"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o4);
	                System.out.println("Clicked on Bet placing Button 2(2) !");
	        	}
	        }
	        else if(odds5 == true && cout== true)
	        {
	        	if(checkElement(driver, "(//*[@class = 'team-button'])[11]"))
	        	{
	                WebElement o5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[11]"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o5);
	                System.out.println("Clicked on Bet placing Button 3(1) !");
	        	}
	        }
	        else if(odds6 == true && odds5 != true && cout== true)
	        {
	        	if(checkElement(driver, "(//*[@class = 'team-button'])[12]"))
	        	{
	                WebElement o6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", o6);
	                System.out.println("Clicked on Bet placing Button 3(2) !");
	        	}
	        } 
	    }
	    catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
    }
    
    public static void oddsSingleBetSoccerCout() throws Throwable
    {
        boolean sodds1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]")).isEnabled();
        boolean sodds2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[6]")).isEnabled();
        boolean sodds3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[10]")).isEnabled();
        boolean sodds4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]")).isEnabled();
        boolean sodds5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[16]")).isEnabled();
        boolean sodds6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[18]")).isEnabled();  
        boolean cout = driver.findElement(By.xpath("//div[@class='cashout_desktopImg']")).isDisplayed();
		//boolean market1 = driver.findElement(By.xpath("//div[@class= 'matchDesk_desc']//div[text()= ' INTERRUPTED ']")).isDisplayed();
		//boolean market2 = driver.findElement(By.xpath("//div[@class= 'matchDesk_desc']//div[text()= ' SUSPENDED ']")).isDisplayed();
		
		try 
		{
	        if(sodds1 == true && cout== true)
	        {
	        	if(checkElement(driver, "(//*[@class = 'team-button'])[4]"))
	        	{
	                WebElement so1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", so1);
	                System.out.println("Clicked on Bet placing Button 1(1) !");
	        	}
	        }
	        else if(sodds2 == true && sodds1 != true && cout== true)
	        {
	        	if(checkElement(driver, "(//*[@class = 'team-button'])[6]"))
	        	{
	            	WebElement so2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[6]"));
	            	((JavascriptExecutor) driver).executeScript("arguments[0].click();", so2);
	                System.out.println("Clicked on Bet placing Button 1(2) !");
	        	}
	        }
	        else if(sodds3 == true && cout== true)
	        {
	        	if(checkElement(driver, "(//*[@class = 'team-button'])[10]"))
	        	{
	                WebElement so3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[10]"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", so3);
	                System.out.println("Clicked on Bet placing Button 3(1) !");
	        	}
	        }
	        else if(sodds4 == true && sodds3 != true && cout== true)
	        {
	        	if(checkElement(driver, "(//*[@class = 'team-button'])[12]"))
	        	{
	                WebElement so4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", so4);
	                System.out.println("Clicked on Bet placing Button 3(2) !");
	        	}
	        }
	        else if(sodds5 == true && cout== true)
	        {
	        	if(checkElement(driver, "(//*[@class = 'team-button'])[16]"))
	        	{
	                WebElement so5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[16]"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", so5);
	                System.out.println("Clicked on Bet placing Button 3(1) !");
	        	}
	        }
	        else if(sodds6 == true && sodds5 != true && cout== true)
	        {
	        	if(checkElement(driver, "(//*[@class = 'team-button'])[18]"))
	        	{
	                WebElement so6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[18]"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", so6);
	                System.out.println("Clicked on Bet placing Button 3(2) !");
	        	}
	        } 
	    }
	    catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
    }
    
    public static void oddsMultiBetSoccerCout() throws Throwable
    {
    	boolean sodds1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]")).isEnabled();
        boolean sodds2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[6]")).isEnabled();
        boolean sodds3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[10]")).isEnabled();
        boolean sodds4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]")).isEnabled();
        boolean sodds5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[16]")).isEnabled();
        boolean sodds6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[18]")).isEnabled();  
       // boolean cout = driver.findElement(By.xpath("//div[@class='cashout_desktopImg']")).isDisplayed();
        
        try 
        {
        	if(sodds1 == true && sodds3 == true)
	        {
        		WebElement so1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", so1);
	            System.out.println("Clicked on Bet placing Button 1 !");
	            Thread.sleep(1000);
	            WebElement so3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[10]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", so3);
	            System.out.println("Clicked on Bet placing Button 2 !");
	        }
	        else if(sodds1 == true && sodds5 == true)
	        {
	        	WebElement so1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", so1);
	            System.out.println("Clicked on Bet placing Button 2 !");
	            Thread.sleep(1000);
	            WebElement so5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[16]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", so5);
	            System.out.println("Clicked on Bet placing Button 3 !");
	        }
	        else if (sodds3 == true && sodds5 == true)
	        {
	        	WebElement so3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[10]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", so3);
	            System.out.println("Clicked on Bet placing Button 2 !");
	            Thread.sleep(1000);
	            WebElement so5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[16]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", so5);
	            System.out.println("Clicked on Bet placing Button 3 !");
	        }
	        else if (sodds2 == true && sodds4 == true)
	        {
	        	WebElement so2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[6]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", so2);
	            System.out.println("Clicked on Bet placing Button 2 !");
	            Thread.sleep(1000);
	            WebElement so4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", so4);
	            System.out.println("Clicked on Bet placing Button 3 !");
	        }
	        else if (sodds2 == true && sodds6 == true)
	        {
	        	WebElement so2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[6]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", so2);
	            System.out.println("Clicked on Bet placing Button 2 !");
	            Thread.sleep(1000);
	            WebElement so6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[18]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", so6);
	            System.out.println("Clicked on Bet placing Button 3 !");
	        }
	        else if (sodds4 == true && sodds6 == true)
	        {
	        	WebElement so4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", so4);
	            System.out.println("Clicked on Bet placing Button 2 !");
	            Thread.sleep(1000);
	            WebElement so6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[18]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", so6);
	            System.out.println("Clicked on Bet placing Button 3 !");
	        }
    	}
    catch(Exception e)
	{
		test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		e.printStackTrace();
		Assert.assertFalse(true);
	}
    }
    
    public static void oddsMultiBetTennisCout() throws Throwable
    {
    	boolean odds1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[3]")).isEnabled();
        boolean odds2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]")).isEnabled();
        boolean odds3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[7]")).isEnabled();
        boolean odds4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[8]")).isEnabled();
        boolean odds5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[11]")).isEnabled();
        boolean odds6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]")).isEnabled();
       // boolean cout = driver.findElement(By.xpath("//div[@class='cashout_desktopImg']")).isDisplayed();
        //boolean market1 = driver.findElement(By.xpath("//div[@class= 'matchDesk_desc']//div[text()= ' INTERRUPTED ']")).isDisplayed();
		//boolean market2 = driver.findElement(By.xpath("//div[@class= 'matchDesk_desc']//div[text()= ' SUSPENDED ']")).isDisplayed();
		
        try 
        {
        	if(odds1 == true && odds3 == true)
	        {
        		WebElement o1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[3]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", o1);
	            System.out.println("Clicked on Bet placing Button 1 !");
	            Thread.sleep(1000);
	            WebElement o3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[7]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", o3);
	            System.out.println("Clicked on Bet placing Button 2 !");
	        }
	        else if(odds1 == true && odds5 == true)
	        {
	        	WebElement o1 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[3]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", o1);
	            System.out.println("Clicked on Bet placing Button 1 !");
	            Thread.sleep(1000);
	            WebElement o5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[11]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", o5);
	            System.out.println("Clicked on Bet placing Button 2 !");
	        }
	        else if (odds3 == true && odds5 == true)
	        {
	        	WebElement o3 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[7]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", o3);
	            System.out.println("Clicked on Bet placing Button 2 !");
	            Thread.sleep(1000);
	            WebElement o5 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[11]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", o5);
	            System.out.println("Clicked on Bet placing Button 3 !");
	        }
	        else if (odds2 == true && odds4 == true)
	        {
	        	WebElement o2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", o2);
	            System.out.println("Clicked on Bet placing Button 2 !");
	            Thread.sleep(1000);
	            WebElement o4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[8]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", o4);
	            System.out.println("Clicked on Bet placing Button 3 !");
	        }
	        else if (odds2 == true && odds6 == true)
	        {
	        	WebElement o2 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[4]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", o2);
	            System.out.println("Clicked on Bet placing Button 2 !");
	            Thread.sleep(1000);
	            WebElement o6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", o6);
	            System.out.println("Clicked on Bet placing Button 3 !");
	        }
	        else if (odds4 == true && odds6 == true)
	        {
	        	WebElement o4 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[8]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", o4);
	            System.out.println("Clicked on Bet placing Button 2 !");
	            Thread.sleep(1000);
	            WebElement o6 = driver.findElement(By.xpath("(//*[@class = 'team-button'])[12]"));
        		((JavascriptExecutor) driver).executeScript("arguments[0].click();", o6);
	            System.out.println("Clicked on Bet placing Button 3 !");
	        }
    	}
	    catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
    }
    
	public static boolean checkElement(WebDriver driver, String xpath) throws Throwable 
	{
        boolean flag = false;
        try 
        {
        	new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = driver.findElement(By.xpath(xpath));
            if (element.isDisplayed()) 
            {
                flag = true;
                System.out.println("Element is available in CheckElement");
            }
        } 
        catch (RuntimeException ee) 
        {
            if (ee.toString().contains("NoSuchElementException")) 
            {
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                WebElement element = driver.findElement(By.xpath(xpath));
                if (element.isDisplayed()) 
                {
                    flag = true;
                    System.out.println("Element is available in CheckElement Catch");
                }
            }
        }
        return flag;
    }
	
	public static void clearCashout() throws Throwable
	{
		try 
		{
			int i = 0;
			for(i=0; i<=10; i++)
			{
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='full_cashout'])[1]")));
				WebElement fco = driver.findElement(By.xpath("(//div[@class='full_cashout'])[1]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", fco);
				Thread.sleep(3000);
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='full_cashout'])[1]")));
				WebElement fcoConf = driver.findElement(By.xpath("(//div[@class='full_cashout'])[1]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", fcoConf);
				Thread.sleep(10000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Cashout Sheet is Empty");
//			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
//			e.printStackTrace();
//			Assert.assertFalse(true);
		}
	}
} 
