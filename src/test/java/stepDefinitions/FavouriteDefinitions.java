package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;
import HelpMeth.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FavouriteDefinitions extends Helper
{
	@Given("I click On the Sports option Fav")
	public void i_click_on_the_sports_option_fav() throws Throwable
	{
		try
		{
			String cname = new FavouriteDefinitions().getClass().getName();
			System.out.println(cname);
			test = extent.startTest(cname);
			Thread.sleep(2000);
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sports']")));
			driver.findElement(By.xpath("//a[text()='Sports']")).click();
		    System.out.println("Sports Option Clicked Successfully");
		    test.log(LogStatus.PASS,"Sports Option Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I Select One Match To Favaurite Fav")
	public void i_select_one_match_to_favaurite_fav() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='frameLeft']")));
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='far fa-star'])[1]"))).click();
			Thread.sleep(2000);
			System.out.println("Select One Match To Favaurite Successfully");
		    test.log(LogStatus.PASS,"Select One Match To Favaurite Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I Click On The Favourite Fav1")
	public void i_click_on_the_favourite_fav1() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Favourites']"))).click();
			Thread.sleep(2000);
		    System.out.println("Click On The Favourite Successfully");
		    test.log(LogStatus.PASS,"Click On The Favourite Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I Observe Match Availablity Fav")
	public void i_observe_match_availablity_fav() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='overall-event-data']"))).click();
			Thread.sleep(2000);
		    System.out.println("Observe Match Availablity Successfully");
		    test.log(LogStatus.PASS,"Observe Match Availablity Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I Click On Live Now Fav")
	public void i_click_on_live_now_fav() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Live Now']"))).click();
			Thread.sleep(2000);
		    System.out.println("Live Option Clicked Successfully");
		    test.log(LogStatus.PASS,"Live Option Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I Un-Select Match Which Added To Favourite Fav")
	public void i_un_select_match_which_added_to_favourite_fav() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-star fillColor']"))).click();
			Thread.sleep(2000);
		    System.out.println("Un-Select Match Which Added To Favourite Successfully");
		    test.log(LogStatus.PASS,"Un-Select Match Which Added To Favourite Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I Again click On The Favourite Fav2")
	public void i_again_click_on_the_favourite_fav2() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Favourites']"))).click();
			Thread.sleep(2000);
		    System.out.println("Clicked On The Favourite Successfully");
		    test.log(LogStatus.PASS,"Clicked On The Favourite Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I Observe Match Un-Availablity Fav")
	public void i_observe_match_un_availablity_fav() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()=' No Favourite are available.']"))).click();
			Thread.sleep(2000);
		    System.out.println("Observed Match Un-Availablity Successfully");
		    test.log(LogStatus.PASS,"Observed Match Un-Availablity Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}
}
