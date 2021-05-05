package org.test;

import java.util.Date;

import org.base.LibGlobal;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample extends LibGlobal {
	@BeforeClass
	private void beforeClass() {
		getDriver();
		launchUrl("https://www.facebook.com/");
	}

	@BeforeMethod
	private void beforMethod() {
		Date date = new Date();
	}

	@Parameters({"username","password"})
	@Test
	private void tc0(String s,String s1) {
		driver.findElement(By.id("email")).sendKeys(s);
		driver.findElement(By.id("pass")).sendKeys(s1);
	}


}
