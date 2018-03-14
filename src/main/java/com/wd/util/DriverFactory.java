package com.wd.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public static WebDriver getDriver(String brName) {
		WebDriver driver = null;
		switch (brName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium drivers\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--disable-notifications");
			driver = new ChromeDriver(co);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium drivers\\geckodriver.exe");

			FirefoxProfile p = new FirefoxProfile();
			p.setPreference("dom.webnotifications.enabled", false);
			FirefoxOptions fo = new FirefoxOptions();
			fo.setProfile(p);
			driver = new FirefoxDriver(fo);
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "C:\\Selenium drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "C:\\Selenium drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("No such browsers available");
			System.exit(0);
			break;
		}
		return driver;
	}

}
