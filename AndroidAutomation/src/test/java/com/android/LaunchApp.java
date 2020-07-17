package com.android;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
public class LaunchApp {
  public static URL url;
  public static DesiredCapabilities capabilities;
  public static AndroidDriver<MobileElement> driver;
  //1
  @BeforeSuite
  public void setupAppium() throws MalformedURLException {
    //2
    final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
    url = new URL(URL_STRING);
//3
    capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M105F");
    //capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/LeanApps/Downloads/15.apk");
    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.stramplerbande");
    capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,".MainActivity");  
    
    
   // capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
    //4
    driver = new AndroidDriver<MobileElement>(url, capabilities);
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  
  }
  //6
  @Test(priority=1, description="Login into Application")
  public void loginTest() throws InterruptedException {
  
	  //To set the username
	  Thread.sleep(6000);
	  List<MobileElement> uname = driver.findElements(By.className("android.widget.EditText"));
	  uname.get(0).sendKeys("amolzinjade");
	  
	  //To set the password
	  Thread.sleep(3000);
	  uname.get(1).sendKeys("Admin@123");
	  
	  //To click on sign In button
	  Thread.sleep(3000);
	  //System.out.println(driver.getPageSource());
	  List<MobileElement> btnSignIn = driver.findElements(By.className("android.view.View"));
	  btnSignIn.get(9).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  Thread.sleep(3000);
	
  }
  @Test(priority=2, description="Verify Messages on Mobile")
  public void likeUnlikePost() throws InterruptedException {
  
	  //To click on like icon
	  Thread.sleep(6000);
	  MobileElement likes = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]/android.view.View[4]/android.view.View/android.widget.Image"));
	  likes.click();
  }
  
  @Test(priority=3, description="Verify Messages on Mobile")
  public void verifyMessages() throws InterruptedException {
  
	  //To click on message icon
	  Thread.sleep(3000);
	  MobileElement msgIcon = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]"));
	  msgIcon.click();
	  
	  //To click on show all messages
	  Thread.sleep(3000);
	  MobileElement showAll = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View[6]"));
	  showAll.click();
  }
  
  @Test(priority=4, description="Verify Web Notifications on Mobile")
  public void verifyWebNotifications() throws InterruptedException {
  
	  //To click on the notification icon
	  Thread.sleep(3000);
	  MobileElement notiIcon = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[1]"));
	  notiIcon.click();
	  
	  //To click on the show all notification
	  Thread.sleep(5000);
	  MobileElement showAllNoti = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View/android.view.View[5]"));
	  showAllNoti.click();
  }
    @Test(enabled = true,priority=5, description="Create Post in groups")
  public void createPost() throws InterruptedException {

	//To click on my groups
	Thread.sleep(3000);
	MobileElement myGroup = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[1]");
	myGroup.click();
	
	//To click on the LeanApps Group
	Thread.sleep(5000);
	MobileElement groupName = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[3]/android.view.View[4]"));
  	groupName.click();
  	
  	//Below logic is to scroll down till find text
  	String text = "Filter";
    String uiSelector = "new UiSelector().textMatches(\"" + text + "\")";
  	String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";

  	 driver.findElementByAndroidUIAutomator(command);
  	//To set the post in input box
  	Thread.sleep(6000);
  	List<MobileElement> setpost = driver.findElements(By.className("android.widget.EditText"));;
  	setpost.get(0).click();
  	
  	Thread.sleep(4000);
  	List<MobileElement> setText = driver.findElements(By.className("android.widget.EditText"));;
  	for(MobileElement el : setText)
  	{
  		System.out.println(el.getText());
  	}
  	setText.get(0).sendKeys("Mobile Automation Group Post");
  	
  	//To click on submit button
  	Thread.sleep(4000);
  	MobileElement submitBtn = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]/android.view.View[3]"));
   	submitBtn.click();
  	
}
}