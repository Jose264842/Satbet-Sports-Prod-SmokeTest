package stepDefinitions;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;
import HelpMeth.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceBetDefinitions extends Helper
{
	@Given("I click on the Sports option PB")
	public void i_click_on_the_sports_option_pb() throws Throwable 
	{
		try
		{
			String cname = new PlaceBetDefinitions().getClass().getName();
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

	@When("I click on the Game Category PB-S")
	public void i_click_on_the_game_category_pb_s() throws Throwable 
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
			String tableTennis = driver.findElement(By.xpath("(//div[@class='icons_list icon_desktop un-selection1'][4])")).getText().replaceAll("\\D+", "");
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
	        } 
	    	else if (highestValue == tennis1) 
	        {
	    		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()= 'Tennis']"))).click();
	        } 
	        else if (highestValue == tableTennis1) 
	        {
	        	new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()= 'Table Tennis']"))).click();
	        }
		    System.out.println("Game Category Clicked Successfully");
		    test.log(LogStatus.PASS,"Game Category Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@When("I select one odds PB-S")
	public void i_select_one_odds_pb_s() throws Throwable 
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

	@When("I enable the Always Allow odd Changes option PB-S")
	public void i_enable_the_always_allow_odd_changes_option_pb_s() throws Throwable 
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

	@When("I enter the amount PB-S")
	public void i_enter_the_amount_pb_s() throws Throwable 
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

	@When("I click on the PlaceBet Success button PB-S")
	public void i_click_on_the_place_bet_success_button_pb_s() throws Throwable 
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='betSubmitdiv']/div")));
			WebElement pb1 = driver.findElement(By.xpath("//div[@class ='betSubmitdiv']/div"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", pb1);
		    System.out.println("Single Bet Placed Successfully");
		    test.log(LogStatus.PASS,"Single Bet Placed Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I select one odds PB-M")
	public void i_select_one_odds_pb_m() throws Throwable 
	{
		try 
		{
			Thread.sleep(5000);
			if(driver.findElement(By.xpath("//div[text()= 'Soccer']")).isSelected())
			{
				Helper.oddsMultiBetSoccerCout();
				System.out.println("Odds is Clicked Successfully");
				test.log(LogStatus.PASS,"Odds is Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			}
			else //if ((driver.findElement(By.xpath("//div[text()= 'Tennis']")).isSelected()) || (driver.findElement(By.xpath("//div[text()= 'Table Tennis']")).isSelected()))
			{
				Helper.oddsMultiBetTennisCout();
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

	@Then("I enable the Always Allow odd Changes option PB-M")
	public void i_enable_the_always_allow_odd_changes_option_pb_m() throws Throwable 
	{
		try 
		{
			if(checkElement(driver, "//div[@class='checkbox1']/input"))
        	{
				WebElement em3 = driver.findElement(By.xpath("//div[@class='checkbox1']/input"));
				if(!(em3.isEnabled())) 
				{
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", em3);
				System.out.println("Allow Odds Clicked Successfully");
			    test.log(LogStatus.PASS,"Allow Odds Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
				}
				else {System.out.println("Allow Odds Clicked Successfully");}
			}
        }
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I enter the amount PB-M")
	public void i_enter_the_amount_pb_m() throws Throwable 
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

	@Then("I click on the PlaceBet Success button PB-M")
	public void i_click_on_the_place_bet_success_button_pb_m() throws Throwable 
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'buttonCheckbox']/div[1]")));
			WebElement pb1 = driver.findElement(By.xpath("//div[@class = 'buttonCheckbox']/div[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", pb1);
		    System.out.println("Multi Bet Placed Successfully");
		    test.log(LogStatus.PASS,"Multi Bet Placed Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}
	

/*	@Then("I click on the Live Now option PB-M")
	public void i_click_on_the_live_now_option_pb_m() throws Throwable 
	{
		try 
		{
			//new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='frameLeft']")));
			//new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Live Now']"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[text()='Live Now']")).click();
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

	@Then("I select one odds PB-M")
	public void i_select_one_odds_pb_m() throws Throwable
	{
		try 
		{
			Helper.oddsClick();
			test.log(LogStatus.PASS,"Odds is Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I enable the Always Allow odd Changes option PB-M")
	public void i_enable_the_always_allow_odd_changes_option_pb_m() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='checkbox1']/input")));
			WebElement em3 = driver.findElement(By.xpath("//div[@class='checkbox1']/input"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", em3);
			System.out.println("Allow Odds Clicked Successfully");
			test.log(LogStatus.PASS,"Allow Odds Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I click on the Max PB-M")
	public void i_click_on_the_max_pb_m() throws Throwable 
	{
		try 
		{
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='checkbox1']/input")));
			WebElement max = driver.findElement(By.xpath("//button[@class='stakeInputButton_1']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", max);
			System.out.println("Max Amount Clicked Successfully");
			test.log(LogStatus.PASS,"Max Amount Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("I click on the PlaceBet Max button PB-M")
	public void i_click_on_the_place_bet_max_button_pb_m() throws Throwable 
	{
		try 
		{
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='betSubmitdiv']/div")));
			WebElement pb1 = driver.findElement(By.xpath("//div[@class ='betSubmitdiv']/div"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", pb1);
		    System.out.println("Place Bet Clicked Successfully");
		    test.log(LogStatus.PASS,"Place Bet Clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	} */

}
