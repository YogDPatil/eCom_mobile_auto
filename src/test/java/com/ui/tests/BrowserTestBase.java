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
import com.ui.pages.MobileBrowserPage;
import com.ui.pages.StartPage;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public abstract class BrowserTestBase {
	private DesiredCapabilities caps;
	protected AndroidDriver androidDriver;
	private AppiumDriverLocalService service;
	protected MobileBrowserPage mobileBrowserPage;
	private UiAutomator2Options opt;

	@BeforeMethod(alwaysRun = true)
	public void intialiseAppiumServer() {
		Map<String, String> env = new HashMap(System.getenv());
		caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("chromedriverExecutable",
				"/Users/codeclouds-yogesh/Desktop/chromedriver-mac-x64/chromedriver");
		caps.setCapability("browserName", "Chrome");

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withEnvironment(env).build();
		service.start();
		try {
			androidDriver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), caps);
		} catch (MalformedURLException | URISyntaxException e) {
			e.printStackTrace();
		}
		mobileBrowserPage = new MobileBrowserPage(androidDriver);
	}

	@AfterMethod(alwaysRun = true)
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
