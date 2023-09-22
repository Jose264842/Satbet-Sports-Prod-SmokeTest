package stepDefinitions;

import HelpMeth.Helper;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;



public class CustomHooks
{  
	@BeforeAll		
    public static void m1() 
	{							
		Helper.start();	
    }
	
    @Before
    public void beforeScenario() 
    {
    	Helper.BrowserLaunch();
    }

    @After
    public void afterScenario() throws Throwable
    {
    	Helper.BrowserClose();
    }
    
    @AfterAll
    public static void m2() throws Throwable 
	{							
//    	Helper.excelUpdate();
    	Helper.end();
    }
}