package Practice.AppiumFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Capability {

	protected static String appPackage;
	protected static String appActivity;
	protected static String deviceName;
	protected static String chromedriverExecutable;
	public AppiumDriverLocalService service;

	
	//this method is to start appium through nodejs//this is given by appium server
	public AppiumDriverLocalService startserver()
	{
	boolean flag = checkifserverisRunning(4723);	
		if(!flag)
		{
	//	service = AppiumDriverLocalService.buildDefaultService();
	
			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable (new File("C:\\Program Files\\nodejs\\node.exe"))
					.withAppiumJS(new File("C:\\Users\\SourabhDevle\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723));
			
			service.start();	
		}
		return service;		
	}
	
	public static boolean checkifserverisRunning(int port)
	{
		boolean isserverRunning = false;
		ServerSocket serverSocket;
		try
		{
			serverSocket = new ServerSocket(port);
            serverSocket.close();		
		}
		catch(Exception e) {
			isserverRunning=true;
		}
		finally {
			serverSocket=null;
		}		
			return isserverRunning;
		}
	
	public static void startEmulator() throws IOException, InterruptedException 
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Emulator.bat");
	Thread.sleep(8000);
	}
	
	public static AndroidDriver<AndroidElement> capability(String appPackage,String appActivity,String deviceName , String chromedriverExecutable ) throws MalformedURLException, IOException, InterruptedException {
			
		FileReader fis = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		appPackage = pro.getProperty("appPackage");
		appActivity = pro.getProperty("appActivity");
		deviceName = pro.getProperty("deviceName");
		
		if(deviceName.contains("saurabh")) {
			startEmulator();
		}
			
		chromedriverExecutable = pro.getProperty("chromedriverExecutable");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Selenium\\drivers\\chromedriver.exe");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
		
	}

}
