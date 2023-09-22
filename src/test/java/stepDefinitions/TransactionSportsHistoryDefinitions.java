package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;
import HelpMeth.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TransactionSportsHistoryDefinitions extends Helper
{
	@Given("Click on Deposit Option Txs")
	public void click_on_deposit_option_txs() throws Throwable
	{
		try 
		{
			String cname = new TransactionSportsHistoryDefinitions().getClass().getName();
			System.out.println(cname);
			test = extent.startTest(cname);
			Thread.sleep(2000);
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Deposit']")));
			driver.findElement(By.xpath("//a[text()='Deposit']")).click();
			System.out.println("Deposit Option Clicked Successfully");
		    test.log(LogStatus.PASS,"Deposit Option Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("Click on Transaction History Txs")
	public void click_on_transaction_history_txs() throws Throwable 
	{
		try 
		{
			Thread.sleep(2000);
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Transaction history')])[2]")));
			driver.findElement(By.xpath("(//a[contains(text(),'Transaction history')])[2]")).click();
			System.out.println("Transaction History Option Clicked Successfully");
		    test.log(LogStatus.PASS,"Transaction History Option Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");    
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}
	
	@Then("Observe The Transaction History Txs")
	public void observe_the_transaction_history_txs() throws Throwable 
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='sorting_1'])[1]")));
			WebElement tx = driver.findElement(By.xpath("(//td[@class='sorting_1'])[1]"));
		    if(tx.isDisplayed()) 
		    {
		    	System.out.println("Transaction History Verified Successfully");
		    	test.log(LogStatus.PASS,"Transaction History Verified Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		    }
		    else 
		    { 
		    	System.out.println("No data available in table");
		    	test.log(LogStatus.PASS,"No data available in table : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		    }   
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("Click on Game History Txs")
	public void click_on_game_history_txs() throws Throwable 
	{
		try 
		{
			Thread.sleep(2000);
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Game History')]")));
			driver.findElement(By.xpath("//a[contains(text(),'Game History')]")).click();
			System.out.println("Game History Option Clicked Successfully");
		    test.log(LogStatus.PASS,"Game History Option Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");  
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("Click on Drpodown Txs")
	public void click_on_dropdown_txs() throws Throwable 
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='categoryId']")));
			driver.findElement(By.xpath("//select[@id='categoryId']")).click();
			System.out.println("Drpodown Clicked Successfully");
		    test.log(LogStatus.PASS,"Drpodown Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}
	
	@Then("Select Sports From Drpodown Txs")
	public void select_sports_from_dropdown_txs() throws Throwable 
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='categoryId']/option[1]")));
			driver.findElement(By.xpath("//select[@id='categoryId']/option[1]")).click();
			System.out.println("Selected Sports From Drpodown Successfully");
		    test.log(LogStatus.PASS,"Selected Sports From Drpodown Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}
	
	@Then("Observe The Game History Txs")
	public void observe_the_game_history_txs() throws Throwable 
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='sorting_1'])[1]")));
			WebElement tx = driver.findElement(By.xpath("(//td[@class='sorting_1'])[1]"));
		    if(tx.isDisplayed()) 
		    {
		    	System.out.println("Game History Verified Successfully");
		    	test.log(LogStatus.PASS,"Game History Option Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		    }
		    else
		    {
		    	System.out.println("No data available in table");
		    	test.log(LogStatus.PASS,"No data available in table : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		    }
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}
}
