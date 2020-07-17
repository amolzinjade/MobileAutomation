package com.android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class PushNotification {

	public static URL url;
	  public static DesiredCapabilities capabilities;
	  public static AndroidDriver<MobileElement> driver;
	  
	  @BeforeTest
	  public void setupAppiumForPush() throws MalformedURLException {
		    //2
		    final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
		    url = new URL(URL_STRING);
		//3
		    capabilities = new DesiredCapabilities();
		    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M105F");
		    
		    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		   
		    
		    driver = new AndroidDriver<MobileElement>(url, capabilities);
		    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		  
		  }

	  @Test(priority=1, description="Test Push Notification")
	  public void pushNotification() throws InterruptedException {
	  
		//((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.HOME));
		  driver.openNotifications();

		  	Thread.sleep(5000);
		    List<MobileElement> allnotifications=driver.findElements(By.className("android.widget.TextView"));
		    boolean flag = false;
		    for (MobileElement webElement : allnotifications) {
		       // System.out.println(webElement.getText());
		        if(webElement.getText().contains("created")){
		        	flag = true;
		            System.out.println("New Content Notification found");
		        }
		        else if(webElement.getText().contains("likes")){
		        	flag = true;
		        	System.out.println("Likes Notification found");
		            
		        }
		        else if(webElement.getText().contains("mentioned")){
		        	flag = true;
		        	System.out.println("Mentioned Notification found");
		            
		        }
		        else if(webElement.getText().contains("commented")){
		        	flag = true;
		        	System.out.println("commented Notification found");
		            
		        }
		        else if(webElement.getText().contains("friend request")){
		        	flag = true;
		        	System.out.println("Friend request Notification found");
		            
		        }
		        else if(webElement.getText().contains("wrote message")){
		        	flag = true;
		        	System.out.println("Message Notification found");
		           
		        }
		        else if(webElement.getText().contains("has accessed")||webElement.getText().contains("was added")||webElement.getText().contains("has deleted")){
		        	flag = true;
		        	System.out.println("Administrative Notification found");
		           
		        }
		           
		    }
			Assert.assertTrue(flag, "No Notification found");
	  }

}
