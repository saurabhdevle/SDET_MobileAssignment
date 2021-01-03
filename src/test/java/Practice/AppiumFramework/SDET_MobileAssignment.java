package Practice.AppiumFramework;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

public class SDET_MobileAssignment extends Capability {

	AndroidDriver<AndroidElement> driver;	  
		@BeforeTest
		public void beforetest() throws IOException, InterruptedException {
		//	driver = capability(appActivity, appPackage, deviceName, chromedriverExecutable);
			 Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Thread.sleep(2000);
		}
		
		
		
		  @AfterClass public void afterclass() throws IOException, InterruptedException
		  {
		  
		  service.stop();
		  } 
		
	
		/*
		 * @Test(enabled = false)
		 * 
		 * public void TC01() throws InterruptedException, MalformedURLException,
		 * IOException {
		 * 
		 * //service.start();
		 * 
		 * service = startserver(); driver = capability(appActivity, appPackage,
		 * deviceName, chromedriverExecutable);
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * driver.findElement(MobileBy.AndroidUIAutomator(
		 * "UiSelector().text(\"Dismiss\")")).click(); driver.findElement(By.xpath(
		 * "//android.widget.Button[@content-desc=\"Dismiss\"]/android.widget.TextView")
		 * ).click();
		 * 
		 * }
		 */
	@Test(priority = 0 ,enabled = true)

	public void signIn() throws MalformedURLException, IOException, InterruptedException {

		service = startserver();
		driver = capability(appActivity, appPackage, deviceName, chromedriverExecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Dismiss\"]/android.widget.TextView")).click();

		
		
		
		/*
		 * driver = capability(appActivity, appPackage, deviceName,
		 * chromedriverExecutable); driver.manage().timeouts().implicitlyWait(30,
		 * TimeUnit.SECONDS); driver.findElement(MobileBy.AndroidUIAutomator(
		 * "UiSelector().text(\"Dismiss\")")).click(); driver.findElement(By.xpath(
		 * "//android.widget.Button[@content-desc=\"Dismiss\"]/android.widget.TextView")
		 * ).click();
		 */
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in with Google\")")).click();
		driver.findElement(By.id("com.google.android.gms:id/account_name")).click();
	
	}
	
	@Test(priority = 1 ,enabled = true)
	public void joinClass() throws InterruptedException {
		
		
		
		/*
		 * String Expected = "Need to add a class?"; String Actual =
		 * driver.findElement(MobileBy.
		 * AndroidUIAutomator("UiSelector().text(\"Need to add a class?\")")).getText();
		 * Assert.assertEquals(Actual, Expected);
		 */
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Join class\")")).click();
		Thread.sleep(3000);

		driver.findElement(MobileBy.AccessibilityId("e.g. ABC123 or teacher@example.com")).sendKeys("Test@gmail.com");
		Thread.sleep(2000);
		driver.hideKeyboard();
		Thread.sleep(5000);

		try {

			driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		}

		catch (Exception ex) {

			ex.printStackTrace();

			System.out.println("Add button disabled");
		}

		Thread.sleep(4000);

		AndroidElement teacherAdded = driver.findElement(MobileBy.id("android:id/alertTitle"));

		if (teacherAdded.isDisplayed()) {

			System.out.println("Teacher has been successfully added to join the class");

			driver.switchTo().alert().accept();
		
		}

	}

	@Test(priority = 2 ,enabled = true)
	public void courseSearch() throws Exception {

		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Select language\"))").click();

		driver.findElement(By.id("org.khanacademy.android:id/tab_bar_button_search")).click();

		driver.findElement(By.xpath("//*[@text='Science']")).click();

		Thread.sleep(4000);

		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Class 10 Physics (India)\")")).click();

		Thread.sleep(4000);

		String actualTitle = "Light – reflection & refraction";
		String expectedTitle = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Light – reflection & refraction\")")).getText();

		Assert.assertEquals(actualTitle, expectedTitle);

		System.out.println("Course selected");
		
		driver.navigate().back();
		
		Thread.sleep(2000);

		
		driver.navigate().back();
		
		Thread.sleep(2000);

		
		driver.navigate().back();
		
		Thread.sleep(2000);

		
	}

	@Test(priority = 3 ,enabled = true)
	public void manageTeacher() throws Exception {

				
						Thread.sleep(3000);

				driver.findElement(MobileBy.AccessibilityId("Settings")).click();

				Thread.sleep(2000);

				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Manage teachers\"))").click();

				driver.findElements(MobileBy.AccessibilityId("Delete")).get(0).click();
				
				Thread.sleep(2000);

				driver.switchTo().alert().accept();
				
				Thread.sleep(2000);

				driver.navigate().back();
				
				Thread.sleep(2000);
				
				driver.navigate().back();
			}

			
	
	@Test(priority = 4 ,enabled = true)
	
	public void termsOfservice() {
		
	try {

		Thread.sleep(3000);

		driver.findElement(MobileBy.AccessibilityId("Settings")).click();

		Thread.sleep(2000);

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Licenses\"))").click();

		Thread.sleep(2000);

		driver.navigate().back();

		Thread.sleep(2000);

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Terms of service\"))").click();
		

		Thread.sleep(16000);

		try {

			Set<String> contextNames = driver.getContextHandles();
			for (String contextName : contextNames) {
				System.out.println(contextName);
			}

			try {
				driver.context("WEBVIEW_chrome");
				System.out.println("Successfully switched to web view");

			}

			catch (Exception ex) {

				ex.printStackTrace();
				System.out.println("Could not switch to web view");
			}

			Thread.sleep(4000);

			boolean webElementIsDisplayed = driver.findElement(By.xpath("//a[@aria-label='Khan Academy']")).isDisplayed();

			if (webElementIsDisplayed) {

				System.out.println("The web element is displayed");
			}

		}

		catch (Exception ex) {

			ex.printStackTrace();

			System.out.println("Some Exception is there");

		}

		Thread.sleep(2000);

		try {

			driver.context("NATIVE_APP");

			Thread.sleep(2000);

			System.out.println("Successfully switched to native view");

			driver.navigate().back();

			Thread.sleep(2000);

			driver.navigate().back();

		}

		catch (Exception ex) {

			ex.printStackTrace();

			System.out.println("Could not switch to native view");
		}

	}

	catch (Exception ex) {

		ex.printStackTrace();
		service.stop();
	}			
}
}
