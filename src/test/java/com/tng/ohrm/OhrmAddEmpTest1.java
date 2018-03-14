package com.tng.ohrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wd.util.DriverFactory;

public class OhrmAddEmpTest1 {

	public WebDriver driver;

	@BeforeClass
	public void openApplication() {

		driver = DriverFactory.getDriver("chrome");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://opensource.demo.orangehrmlive.com/");
	}

	@Test
	public void login() {

		// Enter username, password then click on login button

		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();

	}

	@Test(dependsOnMethods = "login")
	public void addEmployee() {

		// Click on PIM by linkText method
		driver.findElement(By.linkText("PIM")).click();

		// click on Add Employee by partial link method
		driver.findElement(By.partialLinkText("Add Emp")).click();

		// Enter first name, last name, empid then save
		driver.findElement(By.id("firstName")).sendKeys("Jaya");
		driver.findElement(By.id("lastName")).sendKeys("Bharathi");
		driver.findElement(By.id("employeeId")).clear();
		driver.findElement(By.id("employeeId")).sendKeys("20015008");
		driver.findElement(By.xpath("//input[@value = 'Save']")).click();

	}

	@AfterClass
	public void closeApplication() {
		driver.close();
	}

}

// Ctrl+Shift+f for nicely arranging(correct means indentation) the code also XML files