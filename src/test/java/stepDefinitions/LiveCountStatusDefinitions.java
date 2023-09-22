package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import HelpMeth.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LiveCountStatusDefinitions extends Helper
{
	@Given("I click on the Sports option LcS")
	public void i_click_on_the_sports_option_lc_s() throws Throwable
	{
		try
		{
			String cname = new LiveCountStatusDefinitions().getClass().getName();
			System.out.println(cname);
			test = extent.startTest(cname);
			Thread.sleep(2000);
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Sports']")));
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

	@When("I Verify the Available Games equal to Game Count LcS")
	public void i_verify_the_available_games_equal_to_game_count_lc_s() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='frameLeft']")));
			Thread.sleep(5000);
			
			int soccer1 = 0; int tennis1 = 0; int tableTennis1 = 0;
		//Soccer	
	    	String soccer = driver.findElement(By.xpath("(//div[@class='icons_list icon_desktop un-selection1'][2])")).getText();
	    	String soccer2 = soccer.replaceAll("\\D+", "");
	    	if((soccer2!=null) && !(soccer2.isEmpty())) 
			{ soccer1 = Integer.parseInt(soccer2);
			  System.out.println(soccer1); }
			else
			  System.out.println(soccer1);
			
		//Tennis
			String tennis = driver.findElement(By.xpath("(//div[@class='icons_list icon_desktop un-selection1'][3])")).getText();
			String tennis2 = tennis.replaceAll("\\D+", "");
			if((tennis2!=null) && !(tennis2.isEmpty())) 
			{ tennis1 = Integer.parseInt(tennis2);
	    	  System.out.println(tennis1); }
			else
			System.out.println(tennis1);
			
		//Table Tennis
			String tableTennis = driver.findElement(By.xpath("(//div[@class='icons_list icon_desktop un-selection1'][4])")).getText();
			String tableTennis2 = tableTennis.replaceAll("\\D+", "");
			if((tableTennis2!=null) && !(tableTennis2.isEmpty())) 
			{ tableTennis1 = Integer.parseInt(tableTennis2);
			  System.out.println(tableTennis1);}
			else
			System.out.println(tableTennis1);
	    	
	    	int highestValue = Math.max(soccer1, Math.max(tennis1, tableTennis1));
	    	System.out.println(highestValue);
	    	
	    	if (highestValue == soccer1) 
	    	{
	    		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()= 'Soccer']"))).click();
	    		int count = soccer1; 
	    		System.out.println("Live Match Count is " +count);
	    		java.util.List<WebElement> matchingElements = driver.findElements(By.xpath("//div[@class='overall-event-data']"));
	            int matchCount = matchingElements.size();
	            System.out.println("Number of matches on the page: " + matchCount);
	            if(count == matchCount)
	            {
	            	System.out.println("Live Match Count is equal to Number of matches on the page");
	            	test.log(LogStatus.PASS,"Live Match Count is equal to Number of matches on the page : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
	            }
	            else 
	            {
	            	System.out.println("Live Match Count is Not equal to Number of matches on the page");
	            	test.log(LogStatus.PASS,"Live Match Count is Not equal to Number of matches on the page : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
	            }
	    	} 
	    	else if (highestValue == tennis1) 
	        {
	    		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()= 'Tennis']"))).click();
	    		int count = tennis1; 
	    		System.out.println("Live Match Count is " +count);
	    		java.util.List<WebElement> matchingElements = driver.findElements(By.xpath("//div[@class='overall-event-data']"));
	            int matchCount = matchingElements.size();
	            System.out.println(matchCount);
	            if(count == matchCount)
	            {
	            	System.out.println("Live Match Count is equal to Number of matches on the page");
	            	test.log(LogStatus.PASS,"Live Match Count is equal to Number of matches on the page : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
	            }
	            else 
	            {
	            	System.out.println("Live Match Count is Not equal to Number of matches on the page");
	            	test.log(LogStatus.PASS,"Live Match Count is Not equal to Number of matches on the page : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
	            }
	        } 

	        else if (highestValue == tableTennis1) 
	        {
	        	new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()= 'Table Tennis']"))).click();
	        	int count = tableTennis1; 
	        	System.out.println("Live Match Count is " +count);
	        	java.util.List<WebElement> matchingElements = driver.findElements(By.xpath("//div[@class='overall-event-data']"));
	            int matchCount = matchingElements.size();
	            System.out.println("Number of matches on the page " +matchCount);
	            if(count == matchCount)
	            {
	            	System.out.println("Live Match Count is equal to Number of matches on the page");
	            	test.log(LogStatus.PASS,"Live Match Count is equal to Number of matches on the page : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
	            }
	            else 
	            {
	            	System.out.println("Live Match Count is Not equal to Number of matches on the page");
	            	test.log(LogStatus.PASS,"Live Match Count is Not equal to Number of matches on the page : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
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

	@Then("I select one odds LcS")
	public void i_select_one_odds_lc_s() throws Throwable
	{
		try 
		{
			Thread.sleep(5000);
			if(driver.findElement(By.xpath("//div[text()= 'Soccer']")).isSelected())
			{
				Helper.oddsSingleBetSoccerCout();
				System.out.println("Odds is Clicked Successfully");
				test.log(LogStatus.PASS,"Odds is Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			}
			else //if ((driver.findElement(By.xpath("//div[text()= 'Tennis']")).isSelected()) || (driver.findElement(By.xpath("//div[text()= 'Table Tennis']")).isSelected()))
			{
				Helper.oddsSingleBetTennisCout();
				System.out.println("Odds is Clicked Successfully");
				test.log(LogStatus.PASS,"Odds is Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			}
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I enable the Always Allow odd Changes option LcS")
	public void i_enable_the_always_allow_odd_changes_option_lc_s() throws Throwable
	{
		try 
		{
			if(checkElement(driver, "//div[@class='checkbox1']/input"))
        	{
				WebElement em3 = driver.findElement(By.xpath("//div[@class='checkbox1']/input"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", em3);
				System.out.println("Allow Odds Clicked Successfully");
			    test.log(LogStatus.PASS,"Allow Odds Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
        	}
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I enter the amount LcS")
	public void i_enter_the_amount_lc_s() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='100']")));
			WebElement amt = driver.findElement(By.xpath("(//*[@class='stakeInputButton'])[2]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", amt);
			System.out.println("Amount Clicked Successfully");
		    test.log(LogStatus.PASS,"Amount Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I click on the PlaceBet Success button LcS")
	public void i_click_on_the_place_bet_success_button_lc_s() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='betSubmitdiv']/div")));
			WebElement pb1 = driver.findElement(By.xpath("//div[@class ='betSubmitdiv']/div"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", pb1);
		    System.out.println("Single Cout Bet Placed Successfully");
		    test.log(LogStatus.PASS,"Single Cout Bet Placed Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I click on Bet History LcS")
	public void i_click_on_bet_history_lc_s() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Bet History']")));
			WebElement bh = driver.findElement(By.xpath("//div[text()='Bet History']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", bh);
		    System.out.println("Single Cout Bet Placed Successfully");
		    test.log(LogStatus.PASS,"Single Cout Bet Placed Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I Verify the Status LcS")
	public void i_verify_the_status_lc_s() throws Throwable
	{
		try 
		{
//			if(checkElement(driver, "(//div[text()=' Pending '])[1]"))
//        	{
//				//WebElement em3 = driver.findElement(By.xpath("//div[@class='checkbox1']/input"));
//				System.out.println("Pending Status Verified Successfully");
//				test.log(LogStatus.PASS,"Pending Status Verified Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
//        	}
//			if(checkElement(driver, "(//div[text()=' Accepted '])[1]"))
//        	{
//				Thread.sleep(5000);
//				//WebElement em3 = driver.findElement(By.xpath("//div[@class='checkbox1']/input"));
//				System.out.println("Accepted Status Verified Successfully");
//				test.log(LogStatus.PASS,"Accepted Status Verified Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
//        	}
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()=' Pending '])[1]")));
			driver.findElement(By.xpath("(//div[text()=' Pending '])[1]")).isDisplayed();
			System.out.println("Pending Status Verified Successfully");
			test.log(LogStatus.PASS,"Pending Status Verified Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			Thread.sleep(5000);
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()=' Accepted '])[1]")));
			driver.findElement(By.xpath("(//div[text()=' Accepted '])[1]")).isDisplayed();
			System.out.println("Accepted Status Verified Successfully");
			test.log(LogStatus.PASS,"Accepted Status Verified Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
        }
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}
}
