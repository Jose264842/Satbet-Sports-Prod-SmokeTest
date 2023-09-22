package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import HelpMeth.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SingleBetCashoutDefinitions extends Helper
{
	@Given("I click on the Sports option SB")
	public void i_click_on_the_sports_option_sb() throws Throwable
	{
		try
		{
			String cname = new SingleBetCashoutDefinitions().getClass().getName();
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

	@When("I click on the Game Category SB-FCout")
	public void i_click_on_the_game_category_sb_f_cout() throws Throwable
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

	@When("I select one odds SB-FCout")
	public void i_select_one_odds_sb_f_cout() throws Throwable
	{
		try 
		{
			Thread.sleep(10000);
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

	@When("I enable the Always Allow odd Changes option SB-FCout")
	public void i_enable_the_always_allow_odd_changes_option_sb_f_cout() throws Throwable
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

	@When("I enter the amount SB-FCout")
	public void i_enter_the_amount_sb_f_cout() throws Throwable
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

	@When("I click on the PlaceBet Success button SB-FCout")
	public void i_click_on_the_place_bet_success_button_sb_f_cout() throws Throwable
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

	@When("Click on Cashout SB-FCout")
	public void click_on_cashout_sb_f_cout() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Cash Out']")));
			WebElement co = driver.findElement(By.xpath("//div[text()='Cash Out']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", co);
		    System.out.println("Cout clicked from Betslip Successfully");
		    test.log(LogStatus.PASS,"Cout clicked from Betslip Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@When("Click on Full Cashout Btn SB-FCout")
	public void click_on_full_cashout_btn_sb_f_cout() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='full_cashout'])[1]")));
			WebElement fco = driver.findElement(By.xpath("(//div[@class='full_cashout'])[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", fco);
		    System.out.println("FCout Button clicked Successfully");
		    test.log(LogStatus.PASS,"FCout Button clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@When("Click on Confirm Full Cashout Btn SB-FCout")
	public void click_on_confirm_full_cashout_btn_sb_f_cout() throws Throwable
	{
		try 
		{
			Thread.sleep(3000);
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='full_cashout'])[1]")));
			WebElement fcoConf = driver.findElement(By.xpath("(//div[@class='full_cashout'])[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", fcoConf);
		    System.out.println("FCout Conformation Button clicked Successfully");
		    test.log(LogStatus.PASS,"FCout Conformation Button clicked Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

//	@When("Observe the Full Cashout Successful SB-FCout")
//	public void observe_the_full_cashout_successful_sb_f_cout() throws Throwable
//	{
//		try 
//		{
//			Thread.sleep(10000);
//			//Helper.clearCashout();
//			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Cash Out is empty']")));
//			String coMsg = driver.findElement(By.xpath("//div[text()=' Cash Out is empty']")).getText();
//			//String elementText = (String)((JavascriptExecutor) driver).executeScript("arguments[0].click();", coMsg);
//		    System.out.println("Observe Cout Success Message");
//		    System.out.println("Betslip Msg : "+coMsg);
//		    test.log(LogStatus.PASS,"Observe Cout Success Message : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
//		}
//		catch(Exception e)
//		{
//			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
//			e.printStackTrace();
//			Assert.assertFalse(true);
//		}
//	}

	@Then("I select one odds SB-PCout")
	public void i_select_one_odds_sb_p_cout() throws Throwable
	{
		try 
		{
			Thread.sleep(10000);
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
	
	@Then("I enable the Always Allow odd Changes option SB-PCout")
	public void i_enable_the_always_allow_odd_changes_option_sb_p_cout() throws Throwable
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

	@Then("I enter the amount SB-PCout")
	public void i_enter_the_amount_sb_p_cout() throws Throwable
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

	@Then("I click on the PlaceBet Success button SB-PCout")
	public void i_click_on_the_place_bet_success_button_sb_p_cout() throws Throwable
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

	@Then("Click on Cashout SB-PCout")
	public void click_on_cashout_sb_p_cout() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Cash Out']")));
			WebElement co = driver.findElement(By.xpath("//div[text()='Cash Out']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", co);
		    System.out.println("Cout clicked from Betslip Successfully");
		    test.log(LogStatus.PASS,"Cout clicked from Betslip Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("Click on Partial Cashout Btn SB-PCout")
	public void click_on_partial_cashout_btn_sb_p_cout() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='partial_cashout']")));
			WebElement pco = driver.findElement(By.xpath("//div[@class='partial_cashout']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", pco);
		    System.out.println("Partial cout Btn clicked from Betslip Successfully");
		    test.log(LogStatus.PASS,"Partial cout Btn clicked from Betslip Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		    WebElement elementToSlide = driver.findElement(By.xpath("//span[@class='ngx-slider-span ngx-slider-pointer ngx-slider-pointer-min']"));
		    ((JavascriptExecutor) driver).executeScript(
	                "var element = arguments[0];" +
	                "var startX = 100;" +
	                "var endX = 50;" +
	                "var distance = startX - endX;" +
	                "var step = Math.sign(distance) * 10;" +
	                "var currentPosition = startX;" +
	                "var interval = setInterval(function() {" +
	                "   if (Math.abs(currentPosition - endX) < Math.abs(step)) {" +
	                "       clearInterval(interval);" +
	                "       currentPosition = endX;" +
	                "   } else {" +
	                "       currentPosition -= step;" +
	                "   }" +
	                "   var event = document.createEvent('MouseEvent');" +
	                "   event.initMouseEvent('mousemove', true, true, window, 0, 0, 0, currentPosition, 0, false, false, false, false, 0, null);" +
	                "   element.dispatchEvent(event);" +
	                "}, 10);" +
	                "element.dispatchEvent(new MouseEvent('mousedown'));" +
	                "element.dispatchEvent(new MouseEvent('mouseup'));", elementToSlide);
	        System.out.println("Slider Moved Successfully");
		    test.log(LogStatus.PASS,"Slider Moved Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

	@Then("Click on Confirm Partial Cashout Btn SB-PCout")
	public void click_on_confirm_partial_cashout_btn_sb_p_cout() throws Throwable
	{
		try 
		{
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='full_cashout']")));
			WebElement pcoc = driver.findElement(By.xpath("//div[@class='full_cashout']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", pcoc);
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='full_cashout']")));
			WebElement pcoConf = driver.findElement(By.xpath("//div[@class='full_cashout']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", pcoConf);
		    System.out.println("Cout clicked from Betslip Successfully");
		    test.log(LogStatus.PASS,"Cout clicked from Betslip Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}

//	@Then("Observe the Partial Cashout Successful SB-PCout")
//	public void observe_the_partial_cashout_successful_sb_p_cout() throws Throwable
//	{
//		try 
//		{
//			Helper.clearCashout();
//			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Cash Out Successfull']")));
//			String pcoConf = driver.findElement(By.xpath("//div[text()='Cash Out Successfull']")).getText();
//			//((JavascriptExecutor) driver).executeScript("arguments[0].click();", pcoConf);
//		    System.out.println("Cout clicked from Betslip Successfully");
//		    System.out.println("Betslip Msg : "+pcoConf);
//		    test.log(LogStatus.PASS,"Cout clicked from Betslip Successfully : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
//		}
//		catch(Exception e)
//		{
//			test.log(LogStatus.FAIL,"Failed : <a href= '"+takeSnap()+"'>Click here </a> to view the screen shot");
//			e.printStackTrace();
//			Assert.assertFalse(true);
//		}
//	}
}
