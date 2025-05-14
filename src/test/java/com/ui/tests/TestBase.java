package com.ui.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.LanguagePage;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public abstract class TestBase {
	private DesiredCapabilities caps;
	protected AndroidDriver androidDriver;
	private AppiumDriverLocalService service;
	protected LanguagePage languagePage;

	@BeforeMethod(alwaysRun = true)
	public void intialiseAppiumServer() {
		Map<String, String> env = new HashMap(System.getenv());
		caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/testing_app/meesho.apk");
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withEnvironment(env).build();
		service.start();
		try {
			androidDriver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), caps);
		} catch (MalformedURLException | URISyntaxException e) {
			e.printStackTrace();
		}
		languagePage = new LanguagePage(androidDriver);
		
		// Start the main activity explicitly (not usually needed if app already opens
		// to this)
//	    Map<String, Object> args = new HashMap<>();
//	    args.put("appPackage", "com.meesho.supply");
//	    args.put("appActivity", "com.meesho.supply.main.HomeActivity");
//	    androidDriver.executeScript("mobile: startActivity", args);

	}

	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		androidDriver.quit();
		service.stop();
	}

}
